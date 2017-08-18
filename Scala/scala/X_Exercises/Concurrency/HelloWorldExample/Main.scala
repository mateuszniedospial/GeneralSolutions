package X_Exercises.Concurrency.HelloWorldExample

import akka.actor.{ActorSystem, Props}


/**
  * Created by Mateusz Niedośpiał on 14.08.2017.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloSystem")

    val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
    helloActor ! "hello"
    helloActor ! "buenos dias"
  }
}
