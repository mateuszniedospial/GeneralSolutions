package A_Akka.GameOfThrones.Players

import java.util.concurrent.TimeUnit

import A_Akka.GameOfThrones
import A_Akka.GameOfThrones._
import akka.actor.{Actor, ActorRef}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.{Await, Future}


/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Jon extends Actor with Player{
  Jon.preStart()
  override var gold: Double = 800000
  override var military: Int = 150000
  override var betterEquippedMilitary: Boolean = false
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  override def receive: Receive = {
    case GameStarted =>
      self ! NewAction
    case Continue =>
      self ! NewAction

    case NewAction =>
      val action: String = GameOfThrones.readActionFromConsole

      attackActionMatch(Jon, action) match {
        case Some(attack) =>
          attack.place.returnSelf() ! attack
      }
      buyActionMatch(Jon, action) match {
        case Some(buy) =>
          buy.fromWho.returnSelf() ! buy
          self ! Continue
      }
      showGoodsActionMatch(Jon, action) match {
        case Some(show) =>
          implicit val timeout: Timeout = Timeout(5, TimeUnit.SECONDS)
          val future: Future[Any] = show.merchant.returnSelf() ? show
          val reply: ServicesInfo = Await.result(future, timeout.duration).asInstanceOf[ServicesInfo]
          reply.f.apply()
          self ! Continue
      }
      placeInfoActionMatch(Jon, action) match {
        case Some(info) =>
          implicit val timeout: Timeout = Timeout(5, TimeUnit.SECONDS)
          val future: Future[Any] = info.place.returnSelf() ? info
          val reply: InfoReply = Await.result(future, timeout.duration).asInstanceOf[InfoReply]
          reply.f.apply()
          self ! Continue
      }
      goToActionMatch(Jon, action) match {
        case Some(goTo) =>
          implicit val timeout: Timeout = Timeout(5, TimeUnit.SECONDS)
          val future: Future[Any] = goTo.toWho.returnSelf() ? goTo
          val reply: String = Await.result(future, timeout.duration).asInstanceOf[String]
          println(reply)
          self ! Continue
      }
      defActionMatch(Jon, action) match {
        case Some(defend) =>
          implicit val timeout: Timeout = Timeout(5, TimeUnit.SECONDS)
          val future: Future[Any] = defend.place.returnSelf() ? defend
          val reply: String = Await.result(future, timeout.duration).asInstanceOf[String]
          println(reply)
          self ! Continue
      }
      doNotDefActionMatch(Jon, action) match {
        case Some(ddef) =>
          ddef.place.returnSelf() ! ddef
          self ! Continue
      }
      allyActionMatch(Jon, action) match {
        case Some(ally) =>
          implicit val timeout: Timeout = Timeout(5, TimeUnit.SECONDS)
          val future: Future[Any] = ally.toWho.returnSelf() ? ally
          val reply = Await.result(future, timeout.duration).asInstanceOf[String]
          println(reply)
          self ! Continue
      }
      surActionMatch(Jon, action) match {
        case Some(sur) =>
          sur.toWho.returnSelf() ! sur
          println("You have surrendered and therefore the game of thrones is over for you.")
      }

    case NotAllowed(message) =>
      println(message)
      self ! Continue

    case Sold(message) =>
      println(message)
      self ! Continue

    case Conquered(message) =>
      println(message)
      self ! Continue

    case IsUnderAttack(place, attackedBy) =>
      println("Your place: " + place.name + " is under attack.")
      println("Opponent: " + attackedBy.toString)
      place.printInfo()
      println("=============== ")
      println("Your choices: def(firstletters)(amount) || ddef(firstletters)")
      println("Available amounts: 50000, 100000, 150000, 200000, 300000, 500000")
      val action: String = GameOfThrones.readActionFromConsole

      defActionMatch(Jon, action) match {
        case Some(defend) =>
          implicit val timeout: Timeout = Timeout(5, TimeUnit.SECONDS)
          val future: Future[Any] = defend.place.returnSelf() ? defend
          val reply: String = Await.result(future, timeout.duration).asInstanceOf[String]
          println(reply)
          self ! Continue
      }
      doNotDefActionMatch(Jon, action) match {
        case Some(ddef) =>
          ddef.place.returnSelf() ! ddef
          self ! Continue
      }

    case HoldThePlace(message) =>
      println(message)
      self ! Continue
    case LostTheBattle(message) =>
      println(message)
      self ! Continue
    case Defeat(message) =>
      println(message)
      self ! Continue
    case GoldTaken(message) =>
      println(message)
      self ! Continue
    case MilitaryTaken(message) =>
      println(message)
      self ! Continue
    case _ =>
      println("Unknown action.")
      self ! Continue
  }


  override def toString: String = "Jon"
  override def returnSelf(): ActorRef = Jon.self
}
