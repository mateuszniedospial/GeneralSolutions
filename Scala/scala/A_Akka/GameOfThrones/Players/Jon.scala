package A_Akka.GameOfThrones.Players

import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Jon extends Player{
  override var gold: Double = 800000
  override var military: Int = 150000
  override var betterEquippedMilitary: Boolean = false
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  override def toString: String = "Jon"
  override def returnSelf(): ActorRef = JonActor.actor
}
