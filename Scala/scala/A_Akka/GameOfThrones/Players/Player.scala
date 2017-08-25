package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones
import A_Akka.GameOfThrones.Buyable.Buyable
import A_Akka.GameOfThrones.NPCs.Merchant
import A_Akka.GameOfThrones.Places.Place
import akka.actor.ActorRef

import scala.concurrent.duration.Duration

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
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
