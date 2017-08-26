package A_Akka.GameOfThrones.Places

import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  *
  * Simple trait implemented to represent places in the GameOfThrones.
  *
  * !!!!!!!!!!!!!!!! NOTE !!!!!!!!!!!!!!!!!
  *
  * Unfortunately according to Scala Best Practices prepared by
  * experienced scala developers it is not preferable approach to
  * declare variables inside the traits. One should rather declare it
  * in more general way using def, since vars can only be overriden as vars:
  *
  * @see 2.6 : https://github.com/alexandru/scala-best-practices
  *
  * This kind of mistakes are the result of lack of experience in
  * coding using scala language. Please note that entire project
  * serves as a learning platform and therefore such mistakes
  * can and probably will occur during the phase of exploring
  * scala language, dedicated tools and different/new approaches.
  *
  * Almost all of the code written under Scala module is and probably will be
  * for a long time not very good in terms of functional programming and
  * all the best practises of how to use scala language. Nevertheless
  * the situation should improve with the time and gathered knowledge.
  */
trait Place {
  var name: String
  var bandits: Int

  var gold: Double
  var militaryToGain: Int

  var belongTo: Player

  var occupiedBy: Player
  var amountOfHostileMilitary: Int

  def returnSelf(): ActorRef

  def fightBack(against: Player, amountOfMilitary: Int): Player ={
    if(this.belongTo.equals(Noone) && occupiedBy.equals(Noone)){
      val resultInNumber: Int = banditsAttack(against, amountOfMilitary)
      if(hasLost(resultInNumber)) {
        println("You've failed.")
        Noone
      } else {
        taken(against)
        println("The place " + this.name + " was successfully conquered.")
        against
      }
    } else if(this.belongTo.equals(Noone) && (! occupiedBy.equals(Noone))) {
      val resultInNumber: Int = fightWithHostileMilitary(against, amountOfMilitary)
      if(hasLost(resultInNumber)) {
        println("You've failed")
        occupiedBy
      } else {
        amountOfHostileMilitary = resultInNumber
        occupiedBy = against
        isUnderAttackBy(against)
      }
    } else {
      val resultInNumber: Int = banditsAttack(against, amountOfMilitary)
      if(hasLost(resultInNumber)) {
        println("You've failed.")
        this.belongTo
      } else {
        amountOfHostileMilitary = resultInNumber
        occupiedBy = against
        isUnderAttackBy(against)
      }
    }
  }

  def defend(amountOfMilitary: Int): Player = {
    val resultInNumber: Int = fightWithHostileMilitary(this.belongTo, amountOfMilitary)
    if(hasLost(resultInNumber)){
      this.belongTo = occupiedBy
      this.amountOfHostileMilitary = 0
      this.belongTo.military = this.belongTo.military + militaryToGain
      this.belongTo.gold = this.belongTo.gold + this.gold
      this.gold = 0
      this.belongTo
    } else {
      this.occupiedBy = Noone
      this.amountOfHostileMilitary = 0
      this.belongTo
    }
  }

  def doNotDefend(): Player = {
    this.belongTo = occupiedBy
    this.amountOfHostileMilitary = 0
    this.belongTo.military = this.belongTo.military + militaryToGain
    this.belongTo.gold = this.belongTo.gold + this.gold
    this.gold = 0
    this.belongTo
  }

  def printInfo(): Unit = {
    println("========== " + this.name + " ===========")
    println("=================================")
    println("== Gold : " + this.gold)
    println("== Military to gain : " + this.militaryToGain)
    println("== Belong to : " + this.belongTo)
    println("== Bandits : " + this.bandits)
    println("== Occupied by : " + this.occupiedBy)
    println("== Hostile military : " + this.amountOfHostileMilitary)
    println("=================================")
  }

  private def taken(byWho: Player): Unit = {
    byWho.gold = byWho.gold + gold
    this.gold = 0
    byWho.military = byWho.military + militaryToGain
    this.militaryToGain = 0
    belongTo = byWho
  }

  private def isUnderAttackBy(player: Player): Player = player

  private def banditsAttack(against: Player, amountOfMilitary: Int): Int = {
    if(against.betterEquippedMilitary){
      against.military = against.military - amountOfMilitary
      val restOfMilitary = amountOfMilitary - (20/100 * bandits)
      if(restOfMilitary < 0) this.bandits = restOfMilitary
      else this.bandits = 0
      restOfMilitary
    } else {
      against.military = against.military - amountOfMilitary
      val restOfMilitary = amountOfMilitary - (50/100 * bandits)
      if(restOfMilitary < 0) this.bandits = restOfMilitary
      else this.bandits = 0
      restOfMilitary
    }
  }

  private def fightWithHostileMilitary(against: Player, amountOfMilitary: Int): Int = {
    if((against.betterEquippedMilitary && occupiedBy.betterEquippedMilitary) ||
      (!against.betterEquippedMilitary) && (!occupiedBy.betterEquippedMilitary)){
      against.military = against.military - amountOfMilitary
      val restOfMilitary = amountOfMilitary - amountOfHostileMilitary
      restOfMilitary
    } else if (against.betterEquippedMilitary && (! occupiedBy.betterEquippedMilitary)){
      against.military = against.military - amountOfMilitary
      val restOfMilitary: Int = amountOfMilitary - (20/100 * amountOfHostileMilitary)
      restOfMilitary
    } else {
      against.military = against.military - amountOfMilitary
      val restOfMilitary: Int = (20/100 * amountOfMilitary) - amountOfHostileMilitary
      restOfMilitary
    }
  }

  private def hasLost(resultInNumber: Int): Boolean = {
    if(resultInNumber < 0) true
    else false
  }
}
