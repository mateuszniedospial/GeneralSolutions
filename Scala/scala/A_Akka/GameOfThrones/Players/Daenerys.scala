package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones.GameStarted
import A_Akka.GameOfThrones.Places.Place
import akka.actor.{Actor, ActorRef}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object Daenerys extends Actor with Player{
  Daenerys.preStart()
  override var gold: Double = 1000000
  override var military: Int = 300000
  override var betterEquippedMilitary: Boolean = false
  var dragons: Int = 3
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  override def receive: Receive = {
    case GameStarted =>

  }

  def dragonAttack(place: Place, amountOfDragons: Int): Unit = {

  }

  override def toString: String = "Daenerys"

  override def returnSelf(): ActorRef = Daenerys.self
}
