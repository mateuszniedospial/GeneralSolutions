package X_Exercises.Concurrency.PingPongExample

import akka.actor.{ActorRef, ActorSystem, Props}

/**
  * Created by Mateusz Niedośpiał on 14.08.2017.
  *
  * HelloWorldExample & PingPongExample are packages with code
  * from tutorials made by Alvin Alexander.
  * Source: https://alvinalexander.com/scala/scala-akka-actors-ping-pong-simple-example
  *
  * They are used here for educational purposes only.
  */
object PingPongTest extends App{

  val system = ActorSystem("PingPongSystem")
  val pong: ActorRef = system.actorOf(Props[Pong], name = "pong")
  val ping: ActorRef = system.actorOf(Props(new Ping(pong)), name = "ping")
  ping ! StartMessage

}
