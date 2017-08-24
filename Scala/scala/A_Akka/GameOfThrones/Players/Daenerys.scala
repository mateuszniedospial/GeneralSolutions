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
object Daenerys extends Actor with Player{
  override var gold: Double = 1000000
  override var military: Int = 300000
  override var betterEquippedMilitary: Boolean = false
  var dragons: Int = 3
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone


  def dragonAttack(place: Place, amountOfDragons: Int): Unit = {

  }

  override def buy(buyable: Buyable, fromWho: Merchant): Unit = {}

  override def proposeAlliance(toWho: Player, duration: Duration): Unit = {}

  override def surrender(toWho: Player): Unit = {}

  override def receive: Receive = {
    case GameStarted =>

  }

  override def toString: String = "Daenerys"

}
