package A_Akka

import A_Akka.TwoActorsCountdown.{CountdownActor, Start}
import akka.actor.{ActorRef, ActorSystem, Props}

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  */
object X_Test {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("CountdownSystem")
    val firstActor: ActorRef = system.actorOf(Props[CountdownActor], "CountdownActor1")
    val secondActor: ActorRef = system.actorOf(Props[CountdownActor], "CountdownActor2")

    firstActor ! Start(10, secondActor)
  }
}
