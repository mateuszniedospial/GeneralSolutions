package A_Akka.GameOfThrones.Places

import A_Akka.GameOfThrones.Players._
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object Winterfell extends Place{
  override var name: String = "Winterfell"
  override var bandits: Int = _
  override var gold: Double = _
  override var militaryToGain: Int = 75000
  override var belongTo: Player = Jon
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0

  override def returnSelf(): ActorRef = PlaceActor.winterfell
}
