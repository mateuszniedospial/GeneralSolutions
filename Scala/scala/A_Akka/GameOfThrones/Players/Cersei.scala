package A_Akka.GameOfThrones.Players

import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Cersei extends Player{
  override var gold: Double = 1500000
  override var military: Int = 200000
  override var betterEquippedMilitary: Boolean = false
  override var drakeDestroyer: Int = 0

  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  override def returnSelf(): ActorRef = CerseiActor.actor
  override def toString: String = "Cersei"
}
