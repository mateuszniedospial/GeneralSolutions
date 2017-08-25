package A_Akka.GameOfThrones.Places

import A_Akka.GameOfThrones.Players.{Jon, Noone, Player}
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object North extends Place{
  override var name: String = "North"
  override var bandits: Int = 30000
  override var gold: Double = 125000
  override var militaryToGain: Int = 40000
  override var belongTo: Player = Jon
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0

  override def returnSelf(): ActorRef = PlaceActor.north
}
