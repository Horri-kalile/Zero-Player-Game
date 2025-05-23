package models.event

import models.player.{Equipment, Item, Player}

import scala.util.Random

enum EventType:
  case fight, mission, training, restore, sell, buy, special

trait GameEvent:
  def action(player: Player): Unit

class FightEvent extends GameEvent:
  override def action(player: Player): Unit = ???

class MissionEvent extends GameEvent:
  override def action(player: Player): Unit = ???

class TrainingEvent extends GameEvent:
  override def action(player: Player): Unit =
    val exp = Random.between(player.exp * 0.25, player.exp * 0.5).toInt
    player.gainExp(exp)
    println(s"Training completed: +$exp EXP")

class RestoreEvent extends GameEvent:
  override def action(player: Player): Unit =
    player.hp = player.maxHP
    player.mp = player.maxMP
    println("You rested and recovered fully.")

class SellEvent extends GameEvent:
  override def action(player: Player): Unit = ???

class BuyEvent extends GameEvent:
  override def action(player: Player): Unit = ???

class SpecialEvent extends GameEvent:
  override def action(player: Player): Unit =
    Random.nextInt(6) match
      case 0 => player.gainExp(100); println("You helped someone. +100 XP")
      case 1 => player.level = math.max(1, player.level - 1); println("You were cursed! Level down.")
      case 2 => player.levelUp(); println("Blessed by gods! Level up.")
      case 3 =>
        val eq = ??? //TODO random equipment
      //println(s"You found rare loot: ${eq.name}")
      //player.equip(eq)
      case 4 => player.receiveDamage(player.hp); println("Ambush! You died.")
      case 5 =>
        player.stealFromInventory() match
          case Some(item) => println(s"A thief stole your ${item.name}")
          case None => println("The thief found nothing to steal.")

  class SpecialEvent extends GameEvent:
    override def action(player: Player): Unit =
      Random.nextInt(8) match
        case 0 => // Level up/down by random levels
          val change = Random.between(1, 4)
          if Random.nextBoolean() then
            for _ <- 1 to change do player.levelUp()
            println(s"Blessing! You leveled up $change times.")
          else
            player.level = math.max(1, player.level - change)
            println(s"Curse! You lost $change levels.")

        case 1 => // Fight strong monster - good
          val eq = ??? //TODO Equipment.random()
          println("You defeated a powerful monster!")
        /*println(s"You looted a rare item: ${eq.name}")
        player.equip(eq)*/

        case 2 => // Fight strong monster - bad
          println("You were defeated by a powerful monster. Game over!")
          player.receiveDamage(player.hp)

        case 3 => // Discover dungeon - good
          val eq = ??? //TODO Equipment.random()
          println("You discovered a hidden dungeon and found rare equipment!")
        //player.equip(eq)

        case 4 => // Discover dungeon - bad
          player.hp = math.max(1, player.hp / 2)
          player.mp = math.max(0, player.mp / 2)
          println("You were injured in a dungeon trap! HP and MP halved.")

        case 5 => // People ask for help - good TODO calculate exp
          val gain = Random.between(50, 150)
          player.gainExp(gain)
          println(s"You helped villagers and gained $gain EXP.")

        case 6 => // People ask for help - bad
          println("It was a trap! You were killed. Game over!")
          player.receiveDamage(player.hp) //TODO handle game over

        case 7 => // Thief - steal inventory if any
          player.stealFromInventory() match
            case Some(item) => println(s"A thief stole your ${item.name}")
            case None => println("The thief found nothing to steal.")

object EventFactory:
  def executeEvent(eventType: EventType, player: Player): Unit =
    val event: GameEvent = eventType match
      case EventType.fight => new FightEvent()
      case EventType.mission => new MissionEvent()
      case EventType.training => new TrainingEvent()
      case EventType.restore => new RestoreEvent()
      case EventType.sell => new SellEvent()
      case EventType.buy => new BuyEvent()
      case EventType.special => new SpecialEvent()
    event.action(player)
