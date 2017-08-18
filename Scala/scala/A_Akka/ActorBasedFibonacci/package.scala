package A_Akka

import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  */
package object ActorBasedFibonacci {
  case class Compute(a: Int)
  case class SingleAction(a: Int)
  case class PrintAction(a: Long)
  case class ReturnAction(a: Long)
  case class HowMany(a: Int)
  case class Terminate()
}
