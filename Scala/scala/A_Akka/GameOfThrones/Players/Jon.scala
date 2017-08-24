package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones.Buyable.Buyable
import A_Akka.GameOfThrones.GameStarted
import A_Akka.GameOfThrones.NPCs.Merchant
import A_Akka.GameOfThrones.Places.Place
import akka.actor.Actor

import scala.concurrent.duration.Duration

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Jon extends Actor with Player{
  override var gold: Double = 800000
  override var military: Int = 150000
  override var betterEquippedMilitary: Boolean = false
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  override def attack(place: Place, amountOfMilitary: Int): Unit = ???

  override def defend(place: Place, amountOfMilitary: Int): Unit = ???

  override def buy(buyable: Buyable, fromWho: Merchant): Unit = ???

  override def proposeAlliance(toWho: Player, duration: Duration): Unit = ???

  override def surrender(toWho: Player): Unit = ???

  override def receive: Receive = {
    case GameStarted =>

  }

  override def toString: String = "Jon"
}
