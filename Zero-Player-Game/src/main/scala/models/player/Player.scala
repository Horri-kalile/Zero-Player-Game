package models.player

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.HashMap

class Player(val name: String,
             val identity: Identity,
             var level: Int,
             private var exp: Int,
             var hp: Int,
             var mp: Int,
             var attributes: Attributes,
             val behaviors: Behavior
            ) extends Entity:

  private val inventory: ListBuffer[Item] = ListBuffer.empty
  private var equipment: HashMap[EquipmentSlot, Option[Equipment]] = HashMap.from(EquipmentSlot.values.map(slot => slot -> None))
  val skills: List[Skill] = List.empty

  /*TODO algoritmo di calcolo*/
  def maxHP: Int = attributes.constitution * 10

  def maxMP: Int = attributes.intelligence * 5

  def currentHP: Int = hp

  def currentMP: Int = mp

  def gainExp(amount: Int): Unit =
    exp += amount
    if exp >= level * 100 then levelUp()

  /*TODO aggiornare stats*/
  private def levelUp(): Unit =
    level += 1
    exp = 0
    hp = maxHP
    mp = maxMP

  /*TODO calcolo danno*/
  override def receiveDamage(amount: Int): Int =
    val finalDamage = ???
    hp = 0
    finalDamage

  override def receiveHealing(amount: Int): Unit =
    hp = math.min(maxHP, hp + amount)

  def useSkill(skill: Skill): Boolean =
    if mp >= skill.manaCost then
      mp -= skill.manaCost
      true
    else false

  def equip(item: Equipment): Unit =
    equipment = equipment.updated(item.slot, Some(item))
    recalculateAttributes()

  def unequipped(slot: EquipmentSlot): Unit =
    equipment = equipment.updated(slot, None)
    recalculateAttributes()

  private def recalculateAttributes(): Unit =
    val bonus = equipment.values.flatten.foldLeft(attributes)(_ + _.statBonus)
    attributes = attributes + bonus


  def useItem(itemName: String): Boolean =
    inventory.find(_.name == itemName).foreach { item =>
      item.applyTo(this)
      inventory -= item
    }
    true