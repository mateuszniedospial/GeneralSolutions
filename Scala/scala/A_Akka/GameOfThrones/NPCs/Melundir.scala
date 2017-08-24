package A_Akka.GameOfThrones.NPCs
import A_Akka.GameOfThrones.Buyable.{Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.Actor

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Melundir extends Merchant with Actor{
  var toSell:mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(Military(8) -> 8, DrakeDestroyer(2) -> 2)


  override def toString: String = "Melundir"

  override def receive: Receive = ???

  override var occupiedBy: Player = Noone
}
