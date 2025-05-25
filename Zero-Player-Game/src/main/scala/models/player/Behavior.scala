package models.player

import models.player.Player

enum BehaviorType:
  case Aggressive, Defensive, FastLeveling, DoubleAttack, DoubleHp, Lucky, InvulnerableOnce, OneShotChange

trait Behavior:
  def modify(player: Player): Unit

// e.g., bonus attack logic
class Aggressive extends Behavior:
  def modify(player: Player): Unit =
    val current = player.attributes
    player.attributes = current.copy(strength = current.strength * 2)

class Defensive extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., damage reduction logic

class FastLeveling extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., exp boost

class DoubleAttack extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., chance to attack twice

class DoubleHP extends Behavior:
  def modify(player: Player): Unit =
    val current = player.attributes
    player.attributes = current.copy(constitution = current.constitution * 2)
    player.hp = player.maxHP

// e.g., higher chance of rare events
class Lucky extends Behavior:
  def modify(player: Player): Unit =
    val current = player.attributes
    player.attributes = current.copy(lucky = current.lucky * 2)

class InvulnerableOnce extends Behavior:
  def modify(player: Player): Unit = ???

class OneShotChance extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., rare instant kill

