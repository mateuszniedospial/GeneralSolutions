package A_Akka

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.NPCs._
import A_Akka.GameOfThrones.Places._
import A_Akka.GameOfThrones.Players.{Cersei, Daenerys, Jon, Player}

import scala.concurrent.duration.Duration
import scala.io.StdIn

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
package object GameOfThrones {
  /**
    * Player section messages:
    */
  case class Attack(place: Place, amountOfMilitary: Int)
  case class Defend(amountOfMilitary: Int)
  case class DoNotDefend()

  case class GoTo(toWho: Merchant)
  case class Buy(player: Player, buyable: Buyable, fromWho: Merchant)

  case class Alliance(toWho: Player, duration: Duration)
  case class Surrender(toWho: Player)

  /**
    * Merchant section messages:
    */
  case class Sell(what: Buyable, amount: Int, toWhom: Player)

  /**
    * Communication section messages:
    */

  case class IsUnderAttack(place: Place, attackedBy: Player)
  case class ShowAllGoods()

  /**
    * Operating section:
    */
  case class StartTheGame()
  case class GameStarted()
  case class Continue()


  /**
    * Static helper methods:
    */
  def waitFor10(): Unit = Thread.sleep(10000L)
  def readActionFromConsole: String = StdIn.readLine()
  def amountOfMilitary: Int = {
    println("Amount of military: ")
    readActionFromConsole.toInt
  }

  def allPlaces: List[Place] =
    List(DragonIsland, East, KingsLanding, Middle, North, South, West, Winterfell)

  /**
    * Actions:
    */
  def attackActionMatch(player: Player, action: String): Attack = {
    action match {
      case "attack(w)" if !West.belongTo.equals(player) => Attack(West, amountOfMilitary)
      case "attack(e)" if !East.belongTo.equals(player) => Attack(East, amountOfMilitary)
      case "attack(n)" if !North.belongTo.equals(player) => Attack(North, amountOfMilitary)
      case "attack(s)" if !South.belongTo.equals(player) => Attack(South, amountOfMilitary)
      case "attack(m)" if !Middle.belongTo.equals(player) => Attack(Middle, amountOfMilitary)
      case "attack(kl)" if !KingsLanding.belongTo.equals(player) => Attack(KingsLanding, amountOfMilitary)
      case "attack(di)" if !DragonIsland.belongTo.equals(player) => Attack(DragonIsland, amountOfMilitary)
      case "attack(wf)" if !Winterfell.belongTo.equals(player) => Attack(Winterfell, amountOfMilitary)
    }
  }

  def buyActionMatch(player: Player, merchant: Merchant, action: String): Buy = {
    action match {
      case "buy(dd)" if merchant.occupiedBy.equals(player) => Buy(player, DrakeDestroyer(1), merchant)
      case "buy(m)" if merchant.occupiedBy.equals(player) => Buy(player, Military(1), merchant)
      case "buy(eq)" if merchant.occupiedBy.equals(player) => Buy(player, BetterEquipment(1), merchant)
    }
  }

  def goToActionMatch(player: Player, merchant: Merchant, action: String): GoTo = {
    action match {
      case "goto(a)" => GoTo(Alonso)
      case "goto(f)" => GoTo(Frederick)
      case "goto(h)" => GoTo(Hulio)
      case "goto(m)" => GoTo(Melundir)
    }
  }

  def defActionMatch(amountOfMilitary: Int, action: String): Defend = {
    action match {
      case "def" => Defend(amountOfMilitary)
    }
  }

  def doNotDefActionMatch(action: String): DoNotDefend = {
    action match {
      case "ddef" => DoNotDefend()
    }
  }

  def allyActionMatch(duration: Duration, action: String): Alliance = {
    action match {
      case "ally(d)" => Alliance(Daenerys, duration)
      case "ally(c)" => Alliance(Cersei, duration)
      case "ally(j)" => Alliance(Jon, duration)
    }
  }

  def surActionMatch(action: String): Surrender = {
    action match {
      case "sur(d)" => Surrender(Daenerys)
      case "sur(c)" => Surrender(Cersei)
      case "sur(j)" => Surrender(Jon)
    }
  }
}
