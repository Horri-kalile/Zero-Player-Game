package models.monster

import util.RandomFunctions._

object MonsterFactory:

  val originZones = OriginZone.values.toList
  val behaviors = List(Aggressive, Defensive, DoubleHP, Berserker, OneShot, Explosive, Regenerating)
  val monsterTypes = MonsterType.values.toList

  def generaMostro(playerLevel: Int): Monster =
    val name = s"Mostro_${randomName()}"
    val origin = randomChoice(originZones)
    val level = scala.util.Random.between(1, playerLevel + 1)
    val attributes = MonsterAttributes(
      hp = 50 + level * 10,
      attack = 10 + level * 2,
      defense = 5 + level,
      strength = 5 + level
    )
    val behavior = randomChoice(behaviors)
    val monsterType = randomChoice(monsterTypes)
    Monster(name, attributes, origin, level, behavior, monsterType)

