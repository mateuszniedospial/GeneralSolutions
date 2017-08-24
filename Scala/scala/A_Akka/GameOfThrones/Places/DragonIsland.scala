package A_Akka.GameOfThrones.Places
import A_Akka.GameOfThrones.Players.{Cersei, Daenerys, Noone, Player}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
object DragonIsland extends Place{
  override var name: String = "Dragon Island"
  override var bandits: Int = _
  override var gold: Double = _
  override var militaryToGain: Int = 100000
  override var belongTo: Player = Daenerys
  override var occupiedBy: Player = Noone
  override var amountOfHostileMilitary: Int = 0
}
