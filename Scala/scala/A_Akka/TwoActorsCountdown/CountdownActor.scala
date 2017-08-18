package A_Akka.TwoActorsCountdown

import akka.actor.{Actor, ActorRef}

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  */
class CountdownActor extends Actor{
  override def receive: Receive = {
    case Start(n, other) =>
      println(n)
      other ! Countdown(n-1)
    case Countdown(n) =>
      if(n > 0){
        println(self)
        println(n)
        sender ! Countdown(n-1)
      } else {
        context.system.terminate()
      }
  }
}
