package A_Akka.GameOfThrones.Places
import A_Akka.GameOfThrones.Players.{Daenerys, Noone, Player}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object East extends Place{
  override var name: String = "East"
  override var bandits: Int = 30000
  override var gold: Double = 200000
  override var militaryToGain: Int = 75000
  override var belongTo: Player = Daenerys
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0
}
