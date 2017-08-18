package A_Akka.ActorBasedFibonacci

import akka.actor.Actor

/**
  * Created by Mateusz Niedośpiał on 18.08.2017.
  */
case class Terminator(_howManyPrints: Int) extends Actor{
  val howManyPrints: Int = Executor.forNumber
  private var performed: Int = -1

  override def receive: Receive = {
    case Terminate =>
      performed = performed + 1
      if(performed == howManyPrints) context.system.terminate()
  }
}

object Terminator {
  val path: String = Executor.performer.path+"/Terminator"
}
