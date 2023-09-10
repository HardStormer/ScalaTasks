import scala.io.StdIn._

object Main {
  def main(args: Array[String]): Unit = {
    var choice = 0

    while (choice != 3) {
      println("Выберите группу заданий:")
      println("1. Задание 1 (Основы)")
      println("2. Задание 2 (операторы)")
      println("3. Выход")

      choice = readInt()

      choice match {
        case 1 => task1Menu()
        case 2 => stringsAndTextMenu()
        case 3 => println("Выход из программы")
        case _ => println("Неверный выбор, попробуйте снова.")
      }
    }
  }

  private def task1Menu(): Unit = {
    var choice = 0
    while (choice != 5) {
      println("Выберите задание:")
      println("1. Вычисление произведения трех чисел")
      println("2. Вывод приветствия с использованием имени из Config")
      println("3. Расчет веса чипсов")
      println("4. Вернуться в предыдущее меню")
      println("5. Выход")

      choice = readInt()

      choice match {
        case 1 => Task1.task1()
        case 2 => Task1.task2()
        case 3 => Task1.task3()
        case 4 => return
        case 5 => println("Выход из программы")
        case _ => println("Неверный выбор, попробуйте снова.")
      }
    }
  }

  private def stringsAndTextMenu(): Unit = {
    var choice = 0

    while (choice != 4) {
      println("Выберите задание:")
      println("1. Подсчет числа единиц в битовой записи целого числа")
      println("2. Вывод лесенки")
      println("3. Проверка строки на snake-case стиль")
      println("4. Выход")

      choice = readInt()

      choice match {
        case 1 =>
          println("Введите целое число:")
          val num = readInt()
          val onesCount = Task2.countOnesInBinary(num)
          println(s"Число единиц в битовой записи: $onesCount")

        case 2 =>
          println("Введите натуральное число n:")
          val n = readInt()
          Task2.printStaircase(n)

        case 3 =>
          println("Введите строку для проверки:")
          val input = readLine()
          val isSnake = Task2.isSnakeCase(input)
          println(s"Является ли строка snake-case: $isSnake")

        case 4 =>
          println("Выход из программы")

        case _ =>
          println("Неверный выбор, попробуйте снова.")
      }
    }
  }
}