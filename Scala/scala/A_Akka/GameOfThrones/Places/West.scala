package A_Akka.GameOfThrones.Places

import A_Akka.GameOfThrones.Players.{Noone, Player}
import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 25.08.2017.
  */
object West extends Place{
  override var name: String = "West"
  override var bandits: Int = 50000
  override var gold: Double = 300000
  override var militaryToGain: Int = 40000
  override var belongTo: Player = Noone
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0

  override def returnSelf(): ActorRef = PlaceActor.west
}
