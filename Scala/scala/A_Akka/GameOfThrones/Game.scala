package A_Akka.GameOfThrones

import A_Akka.GameOfThrones.Players.{Cersei, Daenerys, Jon}
import akka.actor.{Actor, Props}

/**
  * Created by Mateusz Niedośpiał on 21.08.2017.
  */
class Game extends Actor{
  override def receive: Receive = {
    case StartTheGame() =>
      Cersei.self ! GameStarted
      Daenerys.self ! GameStarted
      Jon.self ! GameStarted
  }
}
