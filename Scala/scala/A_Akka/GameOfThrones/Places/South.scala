package A_Akka.GameOfThrones.Places
import A_Akka.GameOfThrones.Players.{Cersei, Noone, Player}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object South extends Place{
  override var name: String = "South"
  override var bandits: Int = 75000
  override var gold: Double = 500000
  override var militaryToGain: Int = 50000
  override var belongTo: Player = Cersei
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0
}
