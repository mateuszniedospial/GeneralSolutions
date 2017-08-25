package A_Akka.GameOfThrones.Places

import java.util.concurrent.TimeUnit

import A_Akka.GameOfThrones.Players.Player
import A_Akka.GameOfThrones._
import akka.actor.{Actor, ActorRef, Props}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.{Await, Future}

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
class PlaceActor extends Actor{
  override def receive: Receive = {
    case Attack(place, amountOfMilitary, sender) =>
      val player: Player =  place.fightBack(sender, amountOfMilitary)
      if(place.belongTo.equals(player)) {
        sender.returnSelf() ! Conquered("The place: " + place.name + " has been conquered.")
      } else if (place.occupiedBy.equals(player)){
        implicit val timeout: Timeout = Timeout(8, TimeUnit.SECONDS)
        val future: Future[Any] = place.belongTo.returnSelf() ? IsUnderAttack(place, player)
        val result = Await.result(future, timeout.duration)
        val owner: Player = place.belongTo
        result match {
          case defend: Defend =>
            place.defend(defend.amountOfMilitary)
            if(place.belongTo.equals(player)){
              player.returnSelf() ! Conquered("The place: " + place.name + " has been conquered.")
              owner.returnSelf() ! Defeat("The place: " + place.name + " has been lost.")
            } else {
              player.returnSelf() ! LostTheBattle("You've lost the battle over: " + place.name)
              owner.returnSelf() ! HoldThePlace("You won the battle and still own the: " + place.name)
            }
          case ddef: DoNotDefend =>
            place.doNotDefend()
            player.returnSelf() ! Conquered("The place: " + place.name + " has been conquered.")
            owner.returnSelf() ! Defeat("The place: " + place.name + " has been lost.")
        }
      } else {
        val owner: Player = place.belongTo
        player.returnSelf() ! LostTheBattle("You've lost the battle over: " + place.name)
        owner.returnSelf() ! HoldThePlace("The place: " + place.name + "was attacked by: " + player.toString + "" +
          "but remains yours for now.")
      }
    case PrintInfoAboutPlace(place) =>
      val print: Unit = place.printInfo()
      sender ! InfoReply(() => print)
  }
}

object PlaceActor {
  val dragonIsland: ActorRef = Starter.system.actorOf(Props[PlaceActor], "DragonIsland")
  val kingsLanding: ActorRef = Starter.system.actorOf(Props[PlaceActor], "KingsLanding")
  val winterfell: ActorRef = Starter.system.actorOf(Props[PlaceActor], "Winterfell")

  val east: ActorRef = Starter.system.actorOf(Props[PlaceActor], "East")
  val north: ActorRef = Starter.system.actorOf(Props[PlaceActor], "North")
  val west: ActorRef = Starter.system.actorOf(Props[PlaceActor], "West")
  val middle: ActorRef = Starter.system.actorOf(Props[PlaceActor], "Middle")
  val south: ActorRef = Starter.system.actorOf(Props[PlaceActor], "South")
}
