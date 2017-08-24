package A_Akka.GameOfThrones.Places
import A_Akka.GameOfThrones.Players.{Cersei, Noone, Player}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object KingsLanding extends Place{
  override var name: String = "Kings Landing"
  override var bandits: Int = null
  override var gold: Double = null
  override var militaryToGain: Int = 100000
  override var belongTo: Player = Cersei
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0
}
