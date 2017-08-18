package A_Akka.ActorBasedFibonacci

import akka.actor.{Actor, PoisonPill}

/**
  * Created by Mateusz Niedośpiał on 18.08.2017.
  */
class Worker extends Actor{
  override def receive: Receive = {
    case SingleAction(a) =>
      val result: Long = fibonacci(a)
      printWorkers()
      sender ! ReturnAction(result)
  }

  def fibonacci(a: Long): Long = {
    if(a == 0L){
      0L
    } else if (a == 1L){
      1L
    } else {
      fibonacci(a-1)+fibonacci(a-2)
    }
  }

  def printWorkers(): Unit = {
    println("Worker: " + self.path)
  }
}
