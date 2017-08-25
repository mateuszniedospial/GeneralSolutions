package A_Akka

import A_Akka.GameOfThrones.Buyable.{BetterEquipment, Buyable, DrakeDestroyer, Military}
import A_Akka.GameOfThrones.NPCs._
import A_Akka.GameOfThrones.Places._
import A_Akka.GameOfThrones.Players._

import scala.io.StdIn

/**
  * Created by Mateusz Niedośpiał on 19.08.2017.
  */
package object GameOfThrones {

  /**
    * Player section messages:
    */

  case class Attack(place: Place, amountOfMilitary: Int, player: Player)
  case class Defend(place: Place, amountOfMilitary: Int)
  case class DoNotDefend(place: Place)

  case class GoTo(toWho: Merchant, who: Player)
  case class Buy(player: Player, buyable: Buyable, amount: Int, fromWho: Merchant)

  case class Alliance(toWho: Player)
  case class Surrender(toWho: Player)

  case class NewAction()
  case class Status(ofWho: Player)

  /**
    * Merchant section messages:
    */
  case class Sold(message: String)
  case class Occupied(who: Merchant, byWho: Player)
  case class NotAllowed(message: String)
  case class PrintInfo(toWho: Player)
  case class ServicesInfo(f: () => Unit)

  /**
    * Places section messages:
    */

  case class Conquered(message: String)
  case class Defeat(message: String)
  case class LostTheBattle(message: String)
  case class HoldThePlace(message: String)

  case class TakeGoldFromPlace(place: Place, player: Player)
  case class TakeMilitaryFromPlace(place: Place, player: Player)

  case class PrintInfoAboutPlace(place: Place)
  case class InfoReply(f: () => Unit)

  /**
    * Communication section messages:
    */

  case class IsUnderAttack(place: Place, attackedBy: Player)
  case class ShowAllGoods(merchant: Merchant)

  case class GoldTaken(message: String)
  case class MilitaryTaken(message: String)

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

  def allPlaces: List[Place] =
    List(DragonIsland, East, KingsLanding, Middle, North, South, West, Winterfell)

  /**
    * Actions:
    */

  def attackActionMatch(player: Player, action: String): Option[Attack] = {
    action match {
      case "attack(w)(50000)" if !West.belongTo.equals(player) => Option(Attack(West, 50000, player))
      case "attack(w)(100000)" if !West.belongTo.equals(player) => Option(Attack(West, 100000, player))
      case "attack(w)(150000)" if !West.belongTo.equals(player) => Option(Attack(West, 150000, player))
      case "attack(w)(200000)" if !West.belongTo.equals(player) => Option(Attack(West, 200000, player))
      case "attack(w)(300000)" if !West.belongTo.equals(player) => Option(Attack(West, 300000, player))
      case "attack(w)(500000)" if !West.belongTo.equals(player) => Option(Attack(West, 500000, player))

      case "attack(e)(50000)"  if !East.belongTo.equals(player) => Option(Attack(East, 50000, player))
      case "attack(e)(100000)" if !East.belongTo.equals(player) => Option(Attack(East, 100000, player))
      case "attack(e)(150000)" if !East.belongTo.equals(player) => Option(Attack(East, 150000, player))
      case "attack(e)(200000)" if !East.belongTo.equals(player) => Option(Attack(East, 200000, player))
      case "attack(e)(300000)" if !East.belongTo.equals(player) => Option(Attack(East, 300000, player))
      case "attack(e)(500000)" if !East.belongTo.equals(player) => Option(Attack(East, 500000, player))

      case "attack(n)(50000)"  if !North.belongTo.equals(player) => Option(Attack(North, 50000, player))
      case "attack(n)(100000)" if !North.belongTo.equals(player) => Option(Attack(North, 100000, player))
      case "attack(n)(150000)" if !North.belongTo.equals(player) => Option(Attack(North, 150000, player))
      case "attack(n)(200000)" if !North.belongTo.equals(player) => Option(Attack(North, 200000, player))
      case "attack(n)(300000)" if !North.belongTo.equals(player) => Option(Attack(North, 300000, player))
      case "attack(n)(500000)" if !North.belongTo.equals(player) => Option(Attack(North, 500000, player))

      case "attack(s)(50000)"  if !South.belongTo.equals(player) => Option(Attack(South, 50000, player))
      case "attack(s)(100000)" if !South.belongTo.equals(player) => Option(Attack(South, 100000, player))
      case "attack(s)(150000)" if !South.belongTo.equals(player) => Option(Attack(South, 150000, player))
      case "attack(s)(200000)" if !South.belongTo.equals(player) => Option(Attack(South, 200000, player))
      case "attack(s)(300000)" if !South.belongTo.equals(player) => Option(Attack(South, 300000, player))
      case "attack(s)(500000)" if !South.belongTo.equals(player) => Option(Attack(South, 500000, player))

      case "attack(m)(50000)"  if !Middle.belongTo.equals(player) => Option(Attack(Middle, 50000, player))
      case "attack(m)(100000)" if !Middle.belongTo.equals(player) => Option(Attack(Middle, 100000, player))
      case "attack(m)(150000)" if !Middle.belongTo.equals(player) => Option(Attack(Middle, 150000, player))
      case "attack(m)(200000)" if !Middle.belongTo.equals(player) => Option(Attack(Middle, 200000, player))
      case "attack(m)(300000)" if !Middle.belongTo.equals(player) => Option(Attack(Middle, 300000, player))
      case "attack(m)(500000)" if !Middle.belongTo.equals(player) => Option(Attack(Middle, 500000, player))

      case "attack(kl)(50000)"  if !KingsLanding.belongTo.equals(player) => Option(Attack(KingsLanding, 50000, player))
      case "attack(kl)(100000)" if !KingsLanding.belongTo.equals(player) => Option(Attack(KingsLanding, 100000, player))
      case "attack(kl)(150000)" if !KingsLanding.belongTo.equals(player) => Option(Attack(KingsLanding, 150000, player))
      case "attack(kl)(200000)" if !KingsLanding.belongTo.equals(player) => Option(Attack(KingsLanding, 200000, player))
      case "attack(kl)(300000)" if !KingsLanding.belongTo.equals(player) => Option(Attack(KingsLanding, 300000, player))
      case "attack(kl)(500000)" if !KingsLanding.belongTo.equals(player) => Option(Attack(KingsLanding, 500000, player))

      case "attack(di)(50000)"  if !DragonIsland.belongTo.equals(player) => Option(Attack(DragonIsland, 50000, player))
      case "attack(di)(100000)" if !DragonIsland.belongTo.equals(player) => Option(Attack(DragonIsland, 100000, player))
      case "attack(di)(150000)" if !DragonIsland.belongTo.equals(player) => Option(Attack(DragonIsland, 150000, player))
      case "attack(di)(200000)" if !DragonIsland.belongTo.equals(player) => Option(Attack(DragonIsland, 200000, player))
      case "attack(di)(300000)" if !DragonIsland.belongTo.equals(player) => Option(Attack(DragonIsland, 300000, player))
      case "attack(di)(500000)" if !DragonIsland.belongTo.equals(player) => Option(Attack(DragonIsland, 500000, player))

      case "attack(wf)(50000)"  if !Winterfell.belongTo.equals(player) => Option(Attack(Winterfell, 50000, player))
      case "attack(wf)(100000)" if !Winterfell.belongTo.equals(player) => Option(Attack(Winterfell, 100000, player))
      case "attack(wf)(150000)" if !Winterfell.belongTo.equals(player) => Option(Attack(Winterfell, 150000, player))
      case "attack(wf)(200000)" if !Winterfell.belongTo.equals(player) => Option(Attack(Winterfell, 200000, player))
      case "attack(wf)(300000)" if !Winterfell.belongTo.equals(player) => Option(Attack(Winterfell, 300000, player))
      case "attack(wf)(500000)" if !Winterfell.belongTo.equals(player) => Option(Attack(Winterfell, 500000, player))

      case _ => None
    }
  }

  def buyActionMatch(player: Player, action: String): Option[Buy] = {
    action match {
      case "buy(dd)A" if Alonso.occupiedBy.equals(player) => Option(Buy(player, DrakeDestroyer(), 1, Alonso))
      case "buy(m)A" if Alonso.occupiedBy.equals(player) => Option(Buy(player, Military(), 1,  Alonso))
      case "buy(eq)A" if Alonso.occupiedBy.equals(player) => Option(Buy(player, BetterEquipment(), 1,  Alonso))
      case "buy(dd)F" if Frederick.occupiedBy.equals(player) => Option(Buy(player, DrakeDestroyer(), 1, Frederick))
      case "buy(m)F" if Frederick.occupiedBy.equals(player) => Option(Buy(player, Military(), 1, Frederick))
      case "buy(eq)F" if Frederick.occupiedBy.equals(player) => Option(Buy(player, BetterEquipment(), 1, Frederick))
      case "buy(dd)H" if Hulio.occupiedBy.equals(player) => Option(Buy(player, DrakeDestroyer(), 1, Hulio))
      case "buy(m)H" if Hulio.occupiedBy.equals(player) => Option(Buy(player, Military(), 1, Hulio))
      case "buy(eq)H" if Hulio.occupiedBy.equals(player) => Option(Buy(player, BetterEquipment(), 1, Hulio))
      case "buy(dd)M" if Melundir.occupiedBy.equals(player) => Option(Buy(player, DrakeDestroyer(), 1, Melundir))
      case "buy(m)M" if Melundir.occupiedBy.equals(player) => Option(Buy(player, Military(), 1, Melundir))
      case "buy(eq)M" if Melundir.occupiedBy.equals(player) => Option(Buy(player, BetterEquipment(), 1, Melundir))

      case _ => None
    }
  }

  def showGoodsActionMatch(player: Player, action: String): Option[ShowAllGoods] = {
    action match {
      case "show(a)" => Option(ShowAllGoods(Alonso))
      case "show(f)" => Option(ShowAllGoods(Frederick))
      case "show(h)" => Option(ShowAllGoods(Hulio))
      case "show(m)" => Option(ShowAllGoods(Melundir))

      case _ => None
    }
  }

  def placeInfoActionMatch(player: Player, action: String): Option[PrintInfoAboutPlace] = {
    action match {
      case "infoP(di)" => Option(PrintInfoAboutPlace(DragonIsland))
      case "infoP(e)" => Option(PrintInfoAboutPlace(East))
      case "infoP(kl)" => Option(PrintInfoAboutPlace(KingsLanding))
      case "infoP(m)" => Option(PrintInfoAboutPlace(Middle))
      case "infoP(n)" => Option(PrintInfoAboutPlace(North))
      case "infoP(s)" => Option(PrintInfoAboutPlace(South))
      case "infoP(w)" => Option(PrintInfoAboutPlace(West))
      case "infoP(wf)" => Option(PrintInfoAboutPlace(Winterfell))

      case _ => None
    }
  }

  def goToActionMatch(player: Player, action: String): Option[GoTo] = {
    action match {
      case "goto(a)" => Option(GoTo(Alonso, player))
      case "goto(f)" => Option(GoTo(Frederick, player))
      case "goto(h)" => Option(GoTo(Hulio, player))
      case "goto(m)" => Option(GoTo(Melundir, player))

      case _ => None
    }
  }

  def defActionMatch(player: Player, action: String): Option[Defend] = {
    action match {
      case "def(di)(50000)" => Option(Defend(DragonIsland, 50000))
      case "def(di)(100000)" => Option(Defend(DragonIsland, 100000))
      case "def(di)(150000)" => Option(Defend(DragonIsland, 150000))
      case "def(di)(200000)" => Option(Defend(DragonIsland, 200000))
      case "def(di)(300000)" => Option(Defend(DragonIsland, 300000))
      case "def(di)(500000)" => Option(Defend(DragonIsland, 500000))

      case "def(e)(50000)" => Option(Defend(East, 50000))
      case "def(e)(100000)" => Option(Defend(East, 100000))
      case "def(e)(150000)" => Option(Defend(East, 150000))
      case "def(e)(200000)" => Option(Defend(East, 200000))
      case "def(e)(300000)" => Option(Defend(East, 300000))
      case "def(e)(500000)" => Option(Defend(East, 500000))

      case "def(kl)(50000)" => Option(Defend(KingsLanding, 50000))
      case "def(kl)(100000)" => Option(Defend(KingsLanding, 100000))
      case "def(kl)(150000)" => Option(Defend(KingsLanding, 150000))
      case "def(kl)(200000)" => Option(Defend(KingsLanding, 200000))
      case "def(kl)(300000)" => Option(Defend(KingsLanding, 300000))
      case "def(kl)(500000)" => Option(Defend(KingsLanding, 500000))

      case "def(m)(50000)" => Option(Defend(Middle, 50000))
      case "def(m)(100000)" => Option(Defend(Middle, 100000))
      case "def(m)(150000)" => Option(Defend(Middle, 150000))
      case "def(m)(200000)" => Option(Defend(Middle, 200000))
      case "def(m)(300000)" => Option(Defend(Middle, 300000))
      case "def(m)(500000)" => Option(Defend(Middle, 500000))

      case "def(n)(50000)" => Option(Defend(North, 50000))
      case "def(n)(100000)" => Option(Defend(North, 100000))
      case "def(n)(150000)" => Option(Defend(North, 150000))
      case "def(n)(200000)" => Option(Defend(North, 200000))
      case "def(n)(300000)" => Option(Defend(North, 300000))
      case "def(n)(500000)" => Option(Defend(North, 500000))

      case "def(s)(50000)" => Option(Defend(South, 50000))
      case "def(s)(100000)" => Option(Defend(South, 100000))
      case "def(s)(150000)" => Option(Defend(South, 150000))
      case "def(s)(200000)" => Option(Defend(South, 200000))
      case "def(s)(300000)" => Option(Defend(South, 300000))
      case "def(s)(500000)" => Option(Defend(South, 500000))

      case "def(w)(50000)" => Option(Defend(West, 50000))
      case "def(w)(100000)" => Option(Defend(West, 100000))
      case "def(w)(150000)" => Option(Defend(West, 150000))
      case "def(w)(200000)" => Option(Defend(West, 200000))
      case "def(w)(300000)" => Option(Defend(West, 300000))
      case "def(w)(500000)" => Option(Defend(West, 500000))

      case "def(wf)(50000)" => Option(Defend(Winterfell, 50000))
      case "def(wf)(100000)" => Option(Defend(Winterfell, 100000))
      case "def(wf)(150000)" => Option(Defend(Winterfell, 150000))
      case "def(wf)(200000)" => Option(Defend(Winterfell, 200000))
      case "def(wf)(300000)" => Option(Defend(Winterfell, 300000))
      case "def(wf)(500000)" => Option(Defend(Winterfell, 500000))

      case _ => None
    }
  }

  def doNotDefActionMatch(player: Player, action: String): Option[DoNotDefend] = {
    action match {
      case "ddef(di)" => Option(DoNotDefend(DragonIsland))
      case "ddef(e)" => Option(DoNotDefend(East))
      case "ddef(kl)" => Option(DoNotDefend(KingsLanding))
      case "ddef(m)" => Option(DoNotDefend(Middle))
      case "ddef(n)" => Option(DoNotDefend(North))
      case "ddef(s)" => Option(DoNotDefend(South))
      case "ddef(w)" => Option(DoNotDefend(West))
      case "ddef(wf)" => Option(DoNotDefend(Winterfell))

      case _ => None
    }
  }

  def allyActionMatch(player: Player, action: String): Option[Alliance] = {
    action match {
      case "ally(d)" => Option(Alliance(Daenerys))
      case "ally(c)" => Option(Alliance(Cersei))
      case "ally(j)" => Option(Alliance(Jon))

      case _ => None
    }
  }

  def surActionMatch(player: Player, action: String): Option[Surrender] = {
    action match {
      case "sur(d)" => Option(Surrender(Daenerys))
      case "sur(c)" => Option(Surrender(Cersei))
      case "sur(j)" => Option(Surrender(Jon))

      case _ => None
    }
  }

  def statusActionMatch(player: Player, action: String): Option[Status] = {
    action match {
      case "status" => Option(Status(player))
      case _ => None
    }
  }
}
