package X_Exercises.Concurrency.PingPongExample

import akka.actor.Actor

/**
  * Created by Mateusz Niedośpiał on 14.08.2017.
  *
  * HelloWorldExample & PingPongExample are packages with code
  * from tutorials made by Alvin Alexander.
  * Source: https://alvinalexander.com/scala/scala-akka-actors-ping-pong-simple-example
  *
  * They are used here for educational purposes only.
  */
class Pong extends Actor{

  def receive = {
    case PingMessage =>
      println("  pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
  }

}
