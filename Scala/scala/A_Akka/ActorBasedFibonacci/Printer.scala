package A_Akka.ActorBasedFibonacci


import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorRef, Props}
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Mateusz Niedośpiał on 18.08.2017.
  */
class Printer extends Actor{
  override def receive: Receive = {
    case PrintAction(a: Long) =>
      println(a)
      implicit val timeout: Timeout = Duration(25, TimeUnit.SECONDS)
      val future: Future[ActorRef] = context.actorSelection(Terminator.path).resolveOne()
      future onComplete {
        case Success(actor: ActorRef) => actor ! Terminate
        case Failure(exception: Exception) => exception.printStackTrace()
      }
  }
}
