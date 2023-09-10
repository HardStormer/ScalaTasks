import scala.io.StdIn._

object Task1 {
  def task1(): Unit = {
    println("Введите три числа:")
    val num1 = readDouble()
    val num2 = readDouble()
    val num3 = readDouble()

    val product = num1 * num2 * num3
    println(s"Произведение: $product")
  }

  def task2(): Unit = {
    println("Приветствие:")
    val name = "Anna"
    greeting(name)
  }

  def task3(): Unit = {
    println("Введите вес картофеля, долю воды в картофеле и долю воды в чипсах:")
    val potatoWeight = readDouble()
    val potatoWaterRatio = readDouble()
    val chipsWaterRatio = readDouble()

    val chipsWeight = calculateChipsWeight(potatoWeight, potatoWaterRatio, chipsWaterRatio)
    println(f"Вес чипсов: $chipsWeight%.2f")
  }

  private def calculateChipsWeight(potatoWeight: Double, potatoWaterRatio: Double, chipsWaterRatio: Double): Double = {
    val chipsWeight = potatoWeight * (1 - potatoWaterRatio) / (1 - chipsWaterRatio)
    chipsWeight
  }

  private def greeting(name: String): Unit = {
    println(Config.name + name)
  }
}
