package A_Akka.GameOfThrones.Places
import java.util.concurrent.TimeUnit

import A_Akka.GameOfThrones._
import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.{Actor, ActorRef}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.{Await, Future}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object West extends Place with Actor{
  override var name: String = "West"
  override var bandits: Int = 50000
  override var gold: Double = 300000
  override var militaryToGain: Int = 40000
  override var belongTo: Player = Noone
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0

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
    case TakeGoldFromPlace(place, player) =>
      player.returnSelf() ! GoldTaken(place.takeGoldOutOfPlace(player))
    case TakeMilitaryFromPlace(place, player) =>
      player.returnSelf() ! MilitaryTaken(place.takeMilitaryOutOfPlace(player))
    case PrintInfoAboutPlace(place) =>
      val print: Unit = place.printInfo()
      sender ! InfoReply(() => print)
  }

  override def returnSelf(): ActorRef = West.self
}
