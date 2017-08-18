package X_Exercises.Concurrency.HelloWorldExample

import akka.actor.Actor

/**
  * Created by Mateusz Niedośpiał on 14.08.2017.
  *
  * HelloWorldExample & PingPongExample are packages with code
  * from tutorials made by Alvin Alexander.
  * Source: https://alvinalexander.com/scala/simple-scala-akka-actor-examples-hello-world-actors
  *
  * They are used here for educational purposes only.
  */
class HelloActor extends Actor{
  override def receive: Receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}
