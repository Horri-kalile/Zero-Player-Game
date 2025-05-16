package models.player

enum EquipmentSlot:
  case Weapon, Shield, Head, Body, Jewelry1, Jewelry2, Shoes, Gauntlets

case class Equipment(name: String, slot: EquipmentSlot, statBonus: Attributes)