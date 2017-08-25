package A_Akka.GameOfThrones.Buyable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
case class BetterEquipment() extends Buyable{
  val _price: Double = 200000
  override def price(): Double = _price
  override def getType(): String = "BetterEquipment"
}
