package A_Akka

import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  */
package object TwoActorsCountdown {
  case class Start(n: Int, other: ActorRef)
  case class Countdown(n: Int)
}
