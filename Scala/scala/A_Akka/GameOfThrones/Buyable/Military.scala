package A_Akka.GameOfThrones.Buyable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
case class Military(_amount: Int) extends Buyable{
  val _price: Double = 100000
  override def amount(): Int = _amount
  override def price(): Double = _price
  override def getType(): String = "Military"
}
