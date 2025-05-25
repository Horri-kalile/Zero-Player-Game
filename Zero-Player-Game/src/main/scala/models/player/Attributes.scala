package models.player

import scala.annotation.targetName
import scala.util.Random

// === Attributes ===
/*strength -> more dmg, constitution -> more defence, dexterity -> probability to dodge attack, intelligence -> mana, wisdom -> how many hp restore after a fight, lucky -> probability for a special event/drop rate, */
case class Attributes(strength: Int, constitution: Int, dexterity: Int, intelligence: Int, wisdom: Int, lucky: Int):

  def add(other: Attributes): Attributes = this + other

  def +(other: Attributes): Attributes = Attributes(
    strength + other.strength,
    constitution + other.constitution,
    dexterity + other.dexterity,
    intelligence + other.intelligence,
    wisdom + other.wisdom,
    lucky + other.lucky
  )

object Attributes:
  def random(): Attributes =
    Attributes(
      strength = Random.between(5, 16),
      constitution = Random.between(5, 16),
      dexterity = Random.between(5, 16),
      intelligence = Random.between(5, 16),
      wisdom = Random.between(5, 16),
      lucky = Random.between(5, 16)
    )
