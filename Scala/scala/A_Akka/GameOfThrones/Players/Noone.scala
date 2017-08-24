package A_Akka.GameOfThrones.Players
import A_Akka.GameOfThrones.Buyable.Buyable
import A_Akka.GameOfThrones.NPCs.Merchant
import A_Akka.GameOfThrones.Places.Place

import scala.concurrent.duration.Duration

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
case object Noone extends Player{
  override var gold: Double = 0
  override var military: Int = 0
  override var betterEquippedMilitary: Boolean = false
  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone
  override var drakeDestroyer: Int = 0
  override def attack(place: Place, amountOfMilitary: Int): Unit = {}
  override def defend(place: Place, amountOfMilitary: Int): Unit = {}
  override def buy(buyable: Buyable, fromWho: Merchant): Unit = {}
  override def proposeAlliance(toWho: Player, duration: Duration): Unit = {}
  override def surrender(toWho: Player): Unit = {}
  override def toString: String = "Noone"
}
