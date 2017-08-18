package X_Exercises.Concurrency.PingPongExample

import akka.actor.{Actor, ActorRef}

/**
  * Created by Mateusz Niedośpiał on 14.08.2017.
  *
  * HelloWorldExample & PingPongExample are packages with code
  * from tutorials made by Alvin Alexander.
  * Source: https://alvinalexander.com/scala/scala-akka-actors-ping-pong-simple-example
  *
  * They are used here for educational purposes only.
  */
class Ping(pong: ActorRef) extends Actor{
  var count = 0
  def incrementAndPrint(){ count += 1; println("Ping")}

  override def receive: Receive = {
    case StartMessage =>
      incrementAndPrint()
      pong ! PingMessage

    case PongMessage =>
      incrementAndPrint()
      if(count > 99){
        sender ! StopMessage
        println("Ping stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }
  }

}
