package A_Akka.ActorBasedFibonacci
import akka.actor.{ActorRef, ActorSystem, Props}

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  */
object Executor {
  val system: ActorSystem = ActorSystem("ActorBasedFibonacciSystem")
  val performer: ActorRef = system.actorOf(Props[Performer], name="GeneralPerformerOfFibonacci")
  val forNumber: Int = 80


  def main(args: Array[String]): Unit = {
    performer ! Compute(forNumber)
  }
}
