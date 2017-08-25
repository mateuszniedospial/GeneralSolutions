package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones.Places.Place
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Daenerys extends Player{
  override var gold: Double = 1000000
  override var military: Int = 300000
  override var betterEquippedMilitary: Boolean = false
  override var drakeDestroyer: Int = 0
  override var alliedWith: Player = Noone
  override var surrenderedTo: Player = Noone

  var dragons: Int = 3

  override def toString: String = "Daenerys"
  override def returnSelf(): ActorRef = DaenerysActor.actor

  def dragonAttack(place: Place, amountOfDragons: Int): Unit = {}
}
