package X_Exercises.ScalaStart

import scala.util.Random

/**
  * Created by Mateusz Niedośpiał on 12.08.2017.
  */
case class Book private (id: Long, name: String, authors: List[String]) {
  def this(name: String, authors: List[String]) {
    this(Random.nextLong(), name, authors)
  }
}

//Companion object:
object Book {
  def apply(name: String, authors: List[String]) = new Book(name, authors)
  def apply(name: String) = new Book(name, List("Jon Snow", "Martin Odersky", "Frank Underwood"))
  def apply() = new Book(Random.nextLong(), "Default Title", List("Daenerys Targaryan", "Robb Stark", "Jamie Lannister"))
}
