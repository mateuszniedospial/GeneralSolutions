package A_Akka.GameOfThrones.NPCs
import A_Akka.GameOfThrones.Buyable.{Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.Actor

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Alonso extends Merchant with Actor{
  var toSell: mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(DrakeDestroyer(2) -> 2, Military(9) -> 9)
  override def toString: String = "Alonso"
  override def receive: Receive = ???

  override var occupiedBy: Player = Noone
}
