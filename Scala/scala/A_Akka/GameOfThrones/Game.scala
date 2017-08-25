package A_Akka.GameOfThrones

import A_Akka.GameOfThrones.Players.{CerseiActor, DaenerysActor, JonActor}
import akka.actor.{Actor, Props}

/**
  * Created by Mateusz Niedośpiał on 21.08.2017.
  */
class Game extends Actor{
  override def receive: Receive = {
    case StartTheGame() =>
      CerseiActor.actor ! GameStarted
      DaenerysActor.actor ! GameStarted
      JonActor.actor ! GameStarted
  }
}
