package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Frederick extends Merchant{
  var toSell: scala.collection.mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(DrakeDestroyer() -> 3, Military() -> 4, BetterEquipment() -> 1)
  override var occupiedBy: Player = Noone

  override def returnSelf(): ActorRef = MerchantActor.frederick
  override def toString: String = "Frederick"
}
