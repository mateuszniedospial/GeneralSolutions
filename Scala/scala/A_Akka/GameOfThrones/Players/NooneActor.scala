package A_Akka.GameOfThrones.Players
import A_Akka.GameOfThrones.Starter
import akka.actor.{Actor, ActorRef, Props}

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
class NooneActor extends Actor{
  override def receive: Receive = {
    case _ =>
  }
}

object NooneActor {
  val actor: ActorRef = Starter.system.actorOf(props, "Noone")
  def props: Props = Props[NooneActor]
}
