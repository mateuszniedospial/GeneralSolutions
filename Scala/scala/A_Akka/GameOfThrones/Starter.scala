package A_Akka.GameOfThrones

import akka.actor.{ActorRef, ActorSystem, Props}

/**
  * Created by Mateusz Niedośpiał on 21.08.2017.
  */
object Starter {
  val system: ActorSystem = ActorSystem("GameOfThrones")
  val game: ActorRef = system.actorOf(Props[Game], name="Game")

  def main(args: Array[String]): Unit = {
    game ! StartTheGame()
  }
}
