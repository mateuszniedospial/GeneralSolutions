package A_Akka

import akka.actor.ActorRef

/**
  * Created by Mateusz Niedośpiał on 16.08.2017.
  *
  * !!!!!!!!!!!!!!!! NOTE !!!!!!!!!!!!!!!!!
  * Edit: 26.08.17
  *
  * Unfortunately according to Scala Best Practices prepared by
  * experienced scala developers it is not preferable approach:
  * @see 2.18 : https://github.com/alexandru/scala-best-practices
  *
  * As mentioned in the chapter 2.18 only implicit classes can
  * be a rare exception of that rule.
  *
  * This kind of mistakes are the result of lack of experience in
  * coding using scala language. Please note that entire project
  * serves as a learning platform and therefore such mistakes
  * can and probably will occur during the phase of exploring
  * scala language, dedicated tools and different/new approaches.
  *
  * Almost all of the code written under Scala module is and probably will be
  * for a long time not very good in terms of functional programming and
  * all the best practises of how to use scala language. Nevertheless
  * the situation should improve with the time and gathered knowledge.
  */
package object TwoActorsCountdown {
  case class Start(n: Int, other: ActorRef)
  case class Countdown(n: Int)
}
