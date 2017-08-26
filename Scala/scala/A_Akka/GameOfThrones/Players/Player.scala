package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones
import A_Akka.GameOfThrones.Buyable.Buyable
import A_Akka.GameOfThrones.NPCs.Merchant
import A_Akka.GameOfThrones.Places.Place
import akka.actor.ActorRef

import scala.concurrent.duration.Duration

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  *
  * Simple trait implemented to represent players in the GameOfThrones.
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
trait Player{
  var gold: Double
  var military: Int
  var betterEquippedMilitary: Boolean
  var drakeDestroyer: Int

  var alliedWith: Player
  var surrenderedTo: Player

  def returnSelf(): ActorRef

  def attack(place: Place, amountOfMilitary: Int): Player = {
    if(place.belongTo.equals(Noone)){
      place.fightBack(this, amountOfMilitary)
      if(place.belongTo.equals(this)) {
        println("Success!")
        this
      } else {
        println("You've failed.")
        place.belongTo
      }
    } else {
      place.fightBack(this, amountOfMilitary)
    }
  }

  def defend(place: Place, amountOfMilitary: Int): Player = {
    if(place.belongTo.equals(this)){
      val winner: Player = place.defend(amountOfMilitary)
      winner
    } else {
      throw new UnsupportedOperationException("One cannot defend a place that one doesn't possess.")
    }
  }

  def doNotDefend(place: Place): Unit = {
    if(place.belongTo.equals(this)){
      place.doNotDefend()
    }
  }

  def printStatus(): Unit = {
    println("============ Status =============")
    println("=================================")
    println("== Gold : " + this.gold)
    println("== Military : " + this.military)
    println("== BetterEquipment : " + this.betterEquippedMilitary.toString)
    println("== DrakeDestroyers : " + this.drakeDestroyer.toString)
    println("== Alliance with : " + this.alliedWith.toString)
    println("=================================")
  }

  def buy(buyable: Buyable, amount: Int, fromWho: Merchant): Unit = {

  }

  def proposeAlliance(toWho: Player, duration: Duration): Unit = {}

  def surrender(toWho: Player): Unit = {
    if(this.betterEquippedMilitary && !toWho.betterEquippedMilitary) toWho.betterEquippedMilitary
    toWho.gold = toWho.gold + this.gold
    toWho.military = toWho.military + this.military
    toWho.drakeDestroyer = toWho.drakeDestroyer + this.drakeDestroyer

    this.gold = 0
    this.betterEquippedMilitary = false
    this.military = 0
    this.drakeDestroyer = 0
    this.alliedWith = Noone
    this.surrenderedTo = toWho

    for(place <- GameOfThrones.allPlaces) if(place.belongTo.equals(this)) place.belongTo = toWho
    println(this.toString + " has just surrendered to: " + toWho.toString)
  }
}
