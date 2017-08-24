package A_Akka.GameOfThrones.NPCs
import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.Actor

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Frederick extends Merchant with Actor{
  var toSell: scala.collection.mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(DrakeDestroyer(3) -> 3, Military(4) -> 4, BetterEquipment(1) -> 1)


  override def toString: String = "Frederick"

  override def receive: Receive = ???

  override var occupiedBy: Player = Noone
}
