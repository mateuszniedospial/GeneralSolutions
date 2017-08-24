package A_Akka.GameOfThrones.NPCs

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.Players.Player
import akka.actor.ActorRef

import scala.collection.mutable

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
trait Merchant {
  var occupiedBy: Player
  var toSell: mutable.HashMap[Buyable, Int]

  def returnSelf(): ActorRef

  def sell(what: Buyable, amount: Int, toWhom: Player): String = {
    if(toWhom.gold >= what.price()){
      if(toSell(what) >= amount){
      toSell(what) = toSell(what)-amount
      what.getType() match {
        case "Military" =>
          toWhom.gold = toWhom.gold - Military(amount).price()
          toWhom.military = toWhom.military + Military(amount).amount()
          "Successfully bought: " + what.getType() + " x 1"
        case "DrakeDestroyer" =>
          toWhom.gold = toWhom.gold - DrakeDestroyer(amount).price()
          toWhom.drakeDestroyer = toWhom.drakeDestroyer + DrakeDestroyer(amount).amount()
          "Successfully bought: " + what.getType() + " x 1"
        case "BetterEquipment" =>
          toWhom.gold = toWhom.gold - BetterEquipment(amount).price()
          toWhom.betterEquippedMilitary = true
          "Successfully bought: " + what.getType() + " x 1"
      }
      } else if(toSell(what) >= 0 && toSell(what) < amount) {
      "Cannot sell, current amount is only: " + toSell(what)
      } else {
      "Cannot sell, the product is no longer available."
      }
    } else {
      "You don't have enough money"
    }
  }

  def hasItem(buyable: Buyable): Boolean = {
    if(toSell(buyable) > 0) true
    else false
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
