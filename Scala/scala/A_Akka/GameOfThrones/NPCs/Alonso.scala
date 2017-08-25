package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.ActorRef

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Alonso extends Merchant {
  var toSell: mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(DrakeDestroyer(2) -> 2, Military(9) -> 9, BetterEquipment(0) -> 0)
  override var occupiedBy: Player = Noone

  override def returnSelf(): ActorRef = MerchantActor.alonso
  override def toString: String = "Alonso"
}
