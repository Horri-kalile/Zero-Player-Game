package models.player

import scala.annotation.targetName

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
