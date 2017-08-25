package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Hulio extends Merchant{
  var toSell: scala.collection.mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(Military(6) -> 6, BetterEquipment(2) -> 2, DrakeDestroyer(0) -> 0)
  override var occupiedBy: Player = Noone

  override def returnSelf(): ActorRef = MerchantActor.hulio
  override def toString: String = "Hulio"
}
