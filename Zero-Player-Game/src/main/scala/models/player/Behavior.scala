package models.player

import models.player.Player
trait Behavior:
  def modify(player: Player): Unit

// e.g., bonus attack logic
object Aggressive extends Behavior:
  def modify(player: Player): Unit =
    val current = player.attributes
    player.attributes = current.copy(strength = current.strength * 2)

object Defensive extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., damage reduction logic

object FastLeveling extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., exp boost

object DoubleAttack extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., chance to attack twice

object DoubleHP extends Behavior:
  def modify(player: Player): Unit =
    val current = player.attributes
    player.attributes = current.copy(constitution = current.constitution * 2)
    player.hp = player.maxHP

// e.g., higher chance of rare events
object Lucky extends Behavior:
  def modify(player: Player): Unit =
    val current = player.attributes
    player.attributes = current.copy(lucky = current.lucky * 2)

object InvulnerableOnce extends Behavior:
  def modify(player: Player): Unit = ???

object OneShotChance extends Behavior:
  def modify(player: Player): Unit = ??? // e.g., rare instant kill

