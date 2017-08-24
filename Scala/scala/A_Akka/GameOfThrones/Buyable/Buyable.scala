package A_Akka.GameOfThrones.Buyable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
trait Buyable {
  def amount(): Int
  def price(): Double
  def getType(): String
}
