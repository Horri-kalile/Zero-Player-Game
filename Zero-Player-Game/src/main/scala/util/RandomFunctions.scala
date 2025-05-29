package util

import models.player.Player
import models.event.{EventFactory, EventType}
import scala.util.Random

object RandomFunctions:

  def triggerRandomEvent(player: Player): Unit =
    val randomEventType = Random.shuffle(EventType.values.toList).head
    EventFactory.executeEvent(randomEventType, player)

