package A_Akka.ActorBasedFibonacci

import akka.actor.{Actor, PoisonPill}

/**
  * Created by Mateusz Niedośpiał on 18.08.2017.
  */
class Worker extends Actor{
  override def receive: Receive = {
    case SingleAction(a) =>
      val result: Long = additiveFibonacci(a, 0L, 1L)
      printWorkers()
      sender ! ReturnAction(result)
  }

  def fibonacci(a: Long): Long = {
    if(a < 2){
      a
    } else {
      fibonacci(a-1)+fibonacci(a-2)
    }
  }

  /**
    * Much faster version of recursive Fibonacci, which
    * is probably reconstructed during compilation to
    * simple iterate for - loop version.
    * E.g example of call: additiveFibonacci(5L, 0L, 1L)
    * results in:
    * additiveFibonacci(6,0,1)
    * additiveFibonacci(5, 1, 1)
    * additiveFibonacci(4, 1, 2)
    * additiveFibonacci(3, 2, 3)
    * additiveFibonacci(2, 3, 5)
    * additiveFibonacci(1, 5, 8) = 8
    * Where 8 is the final result of the calculation.
   */
  def additiveFibonacci(a: Long, t0: Long, t1: Long): Long = {
    if (a == 0) t0
    else if (a == 1) t1
    else additiveFibonacci(a-1, t1, t0+t1)
  }

  def printWorkers(): Unit = {
    println("Worker: " + self.path)
  }
}
