package A_Akka.GameOfThrones.Players

import A_Akka.GameOfThrones.{GameStarted, Starter}
import akka.actor.{Actor, ActorRef, Props}


/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
class CerseiActor extends Actor{
  override def receive: Receive = {
    case GameStarted =>
  }
}

object CerseiActor {
  val actor: ActorRef = Starter.system.actorOf(props, "Cersei")
  def props: Props = Props[CerseiActor]
}
