package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.ActorRef

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Melundir extends Merchant{
  var toSell: mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(Military(8) -> 8, DrakeDestroyer(2) -> 2, BetterEquipment(0) -> 0)
  override var occupiedBy: Player = Noone

  override def returnSelf(): ActorRef = MerchantActor.melundir
  override def toString: String = "Melundir"
}
