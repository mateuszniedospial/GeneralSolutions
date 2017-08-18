package A_Akka.ActorBasedFibonacci

import akka.actor.{Actor, ActorRef, Props}

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  */
class Performer extends Actor{
  override def receive: Receive = {
    case Compute(a) =>
      callTerminator(a, "Terminator")
      for(n <- 0 to a) {
        val worker: ActorRef = context.actorOf(Props[Worker], name = "Worker:"+uniqueNamesGenerator(n))
        worker ! SingleAction(n)
      }
    case ReturnAction(a) =>
      val printer: ActorRef = context.actorOf(Props[Printer], name = "Printer:"+uniqueNamesGenerator(a))
      printer ! PrintAction(a)
    case _ => println("Unknown message received by: " + self.toString())
  }

  def uniqueNamesGenerator(n: Long): Double = n+Math.random()+Math.random()+n/Math.random()
  def callTerminator(a: Int, name: String): ActorRef = {
   context.actorOf(Props(Terminator(a)), name = name)
  }
}
