package A_Akka.GameOfThrones.NPCs
import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.Actor

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Hulio extends Merchant with Actor{
  var toSell: scala.collection.mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(Military(6) -> 6, BetterEquipment(2) -> 2)


  override def toString: String = "Hulio"

  override def receive: Receive = ???

  override var occupiedBy: Player = Noone
}
