package A_Akka.GameOfThrones.NPCs
import A_Akka.GameOfThrones.Buyable.{BetterEquipment, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.Actor

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Frederick extends Merchant with Actor{
  override var toSell =  scala.collection.mutable.Map(DrakeDestroyer -> 3, Military -> 4, BetterEquipment -> 1)


  override def toString: String = "Frederick"

  override def receive: Receive = ???

  override var occupiedBy: Player = Noone
}
