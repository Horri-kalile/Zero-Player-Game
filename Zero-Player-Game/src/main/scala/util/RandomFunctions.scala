package util
import scala.util.Random

object RandomFunctions:

  def randomName(): String =
    val names = List("Zorg", "Blarg", "Kree", "Muglu", "Snarf", "Glim")
    Random.shuffle(names).head

  def randomChoice[T](list: List[T]): T =
    list(Random.nextInt(list.length))