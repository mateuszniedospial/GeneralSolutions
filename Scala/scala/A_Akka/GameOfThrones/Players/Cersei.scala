package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones.GameStarted
import akka.actor.{Actor, ActorRef}


/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Cersei extends Actor with Player{
  Cersei.preStart()
  override var gold: Double = 1500000
  override var military: Int = 200000
  override var betterEquippedMilitary: Boolean = false
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  override def receive: Receive = {
    case GameStarted =>
  }

  override def toString: String = "Cersei"

  override def returnSelf(): ActorRef = Cersei.self
}
