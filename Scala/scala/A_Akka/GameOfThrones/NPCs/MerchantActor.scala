package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Players.{Noone}
import A_Akka.GameOfThrones._
import akka.actor.{Actor, ActorRef, Props}

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
class MerchantActor extends Actor{
  override def receive: Receive = {
    case GoTo(receiver, sendBy) =>
      if(receiver.occupiedBy.equals(Noone)){
       sender() ! Occupied(receiver, sendBy)
      } else {
        val message: String = "Merchant is currently doing business with someone else."
        sender() ! Occupied(receiver, receiver.occupiedBy)
      }
    case ShowAllGoods(receiver) =>
      val print: Unit = receiver.printMerchantInfo()
      sender ! ServicesInfo(() => print)
    case Buy(sendBy, buyable, receiver) =>
      if(receiver.hasItem(buyable)){
        val message: String = receiver.sell(buyable, 1, sendBy)
        receiver.occupiedBy = Noone
        sender() ! Sold(message)
      } else {
        val message: String = receiver.toString + " can't sell something that He does not have..."
        sender() ! NotAllowed(message)
      }
  }
}

object MerchantActor {
  val alonso: ActorRef = Starter.system.actorOf(Props[MerchantActor], "Alonso")
  val frederick: ActorRef = Starter.system.actorOf(Props[MerchantActor], "Frederick")
  val hulio: ActorRef = Starter.system.actorOf(Props[MerchantActor], "Hulio")
  val melundir: ActorRef = Starter.system.actorOf(Props[MerchantActor], "Melundir")
}
