package A_Akka.GameOfThrones.NPCs
import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones._
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.{Actor, ActorRef}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Frederick extends Merchant with Actor{
  var toSell: scala.collection.mutable.HashMap[Buyable, Int] = scala.collection.mutable.HashMap(DrakeDestroyer(3) -> 3, Military(4) -> 4, BetterEquipment(1) -> 1)
  override var occupiedBy: Player = Noone

  override def receive: Receive = {
    case GoTo(receiver, sender) =>
      if(occupiedBy.equals(Noone)){
        sender.returnSelf() ! Occupied(receiver, sender)
      } else {
        val message: String = "Merchant is currently doing business with someone else."
        sender.returnSelf() ! NotAllowed(message)
      }
    case ShowAllGoods =>
      val print: Unit = printMerchantInfo()
      sender ! ServicesInfo(() => print)
    case Buy(sender, buyable, receiver) =>
      if(hasItem(buyable)){
        val message: String = sell(buyable, 1, sender)
        sender.returnSelf() ! Sold(message)
      } else {
        val message: String = receiver.toString + " can't sell something that He does not have..."
        sender.returnSelf() ! NotAllowed(message)
      }
  }

  override def returnSelf(): ActorRef = Frederick.self
  override def toString: String = "Frederick"
}
