package models.player

//TODO add other
enum Race:
  case Human, Elf, Dwarf, Orc

//TODO add other
enum ClassType:
  case Warrior, Mage, Rogue, Cleric

case class Identity(name: String, race: Race, classType: ClassType)