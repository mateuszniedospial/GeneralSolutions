package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.Player

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
trait Merchant {
  var occupiedBy: Player
  var toSell: Map[Buyable, Int]

  def sell(what: Buyable, amount: Int, toWhom: Player): Buyable = {
    if(toSell(what) >= amount){
      toSell(what) = toSell(what)-amount
      what.getType() match {
        case "Military" => Military(amount)
        case "DrakeDestroyer" => DrakeDestroyer(amount)
        case "BetterEquipment" => BetterEquipment(amount)
      }
    } else if(toSell(what) >= 0 && toSell(what) < amount) {
      println("Cannot sell, current amount is only: " + toSell(what))
      null
    } else {
      println("Cannot sell, the product is no longer available.")
      null
    }
  }

  def printMerchantInfo(): Unit = {
    println("======= " + this.toString + " ====")
    println("==============================")
    println("======= Current Goods ========")
    println("==============================")
    println("= Name ===== Amount | Price ==")
    for((k,v) <- toSell) println("= " + k + "== " + v + " | " + k.price() + "==")
    println("==============================")
  }
}
