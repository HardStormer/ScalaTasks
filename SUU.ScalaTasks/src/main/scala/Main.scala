import Task5.{Exam, Lecture, Practical, Student, Teacher}
import Task6.{AnimalCage, MediumAnimal, SmallAnimal}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.io.StdIn._
import scala.language.postfixOps

object Main {
  def main(args: Array[String]): Unit = {
    var choice = 0

    while (choice != 3) {
      println("Выберите группу заданий:")
      println("1. Задание 1 (Основы)")
      println("2. Задание 2 (операторы)")
      println("3. Задание 3 (функции)")
      println("4. Задание 4 (Коллекции)")
      println("5. Задание 5 (ООП)")
      println("6. Задание 6 Стационар в ветклинике")
      println("7. Задание 7 Создание потоков")
      println("8. Выход")

      choice = readInt()

      choice match {
        case 1 => task1Menu()
        case 2 => stringsAndTextMenu()
        case 3 => task3Menu()
        case 4 => task4Menu()
        case 5 => task5Menu()
        case 6 => task6Menu()
        case 7 => task7Menu()
        case 8 => println("Выход из программы")
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

  private def task3Menu(): Unit = {
    var choice = 0

    while (choice != 4) {
      println("Выберите задание:")
      println("1. Написать функцию, которая модифицирует поданную в качестве аргумента строку, переставив слова в обратном порядке. Например, строку \"How        are you\" превращает в строку \"you are How\".")
      println("2. Реализуйте задание 1 с помощью хвостовой рекурсии")
      println("3. Создайте функцию для подсчета массы чипсов (задание 1).")
      println("4. Выход")

      choice = readInt()

      choice match {
        case 1 =>
          val originalString = "How        are you"
          val modifiedString = Task31.reverseWords(originalString)
          println(modifiedString)

        case 2 =>
          val originalString = "How        are you"
          val modifiedString = Task32.reverseWordsTailRec(originalString)
          println(modifiedString)

        case 3 =>

          // Ручное каррирование
          val curriedChipsWeightManual = (Task33.calculateChipsWeight _).curried

          // Каррирование с использованием метода curried
          val curriedChipsWeight = Task33.calculateChipsWeight _ curried

          // Пример вызова с частичным применением аргументов
          val partialChipsWeightManual = curriedChipsWeightManual(100.0)
          val resultManual = partialChipsWeightManual(0.9)(0.1)
          println(resultManual)

          val partialChipsWeight = curriedChipsWeight(100.0)
          val result = partialChipsWeight(0.9)(0.1)
          println(result)

        case 4 =>
          println("Выход из программы")

        case _ =>
          println("Неверный выбор, попробуйте снова.")
      }
    }
  }

  private def task4Menu(): Unit = {
    var choice = 0

    while (choice != 4) {
      println("Выберите задание:")
      println("1. Напишите рекурсивную функцию для подсчета k-порядковой статистики")
      println("2. Для игры в морской бой реализовать функцию добавление корабля на поле.")
      println("3. Даны три отсортированных по возрастанию списка целых чисел")
      println("4. Выход")

      choice = readInt()

      choice match {
        case 1 =>
          val nums1 = List(3, 8, 1, 12, 23)
          println(Task4.kOrderStatistic(4, nums1)) // Output: 12

          val nums2 = List(4, 7, 6, 5, 12, 9, 5)
          println(Task4.kOrderStatistic(3, nums2)) // Output: 5

          val nums3 = List(4, 7, 6, 5, 12, 9, 5)
          println(Task4.kOrderStatistic(5, nums3)) // Output: 7

        case 2 =>
          val emptyField: Task4.Field = Vector.fill(10)(Vector.fill(10)(false))
          val ship: Task4.Ship = List((1, 1), (1, 2), (1, 3))
          val updatedField = Task4.addShipToField(emptyField, ship)
          println(updatedField)

        case 3 =>
          val list1 = List(1, 2, 3, 4, 5)
          val list2 = List(2, 4, 6, 8, 10)
          val list3 = List(10, 20, 30, 40, 50)

          val result = for {
            x <- list1
            y <- list2
            if x != y && list3.contains(x * y)
          } yield (x, y)

          val sortedResult = result.sorted
          sortedResult.foreach(println)

        case 4 =>
          println("Выход из программы")

        case _ =>
          println("Неверный выбор, попробуйте снова.")
      }
    }
  }

  private def task5Menu(): Unit = {
    val teacher = new Teacher("John", "Doe")
    val students = List(
      new Student("Alice", "Smith", 3, "Computer Science", 101),
      new Student("Bob", "Jones", 3, "Computer Science", 101),
      new Student("Charlie", "Brown", 3, "Computer Science", 101)
    )

    val lecture = new Lecture("Introduction to Scala", teacher, students)
    val practical = new Practical("Scala Programming", teacher, students)
    val exam = new Exam("Final Exam", teacher, students)

    lecture.markAttendance()
    practical.markLabWork()
    exam.conductExam()

    students.foreach(student => println(s"${student.firstName} ${student.lastName} - Total Score: ${student.getTotalScore}, Grade: ${student.getGrade}"))
  }

  private def task6Menu(): Unit = {
    val cat = new MediumAnimal("Cat")
    val dog = new MediumAnimal("Dog")
    val rabbit = new MediumAnimal("Rabbit")

    val hamster = new SmallAnimal("Hamster")
    val rat = new SmallAnimal("Rat")
    val mouse = new SmallAnimal("Mouse")

    val mediumAnimalCage = new AnimalCage[MediumAnimal](List())
    val smallAnimalCage = new AnimalCage[SmallAnimal](List())

    val cage1 = mediumAnimalCage.addAnimal(cat).addAnimal(dog)
    cage1.printOccupants()

    val cage2 = cage1.releaseAnimal(cat)
    cage2.printOccupants()

    val cage3 = smallAnimalCage.addAnimal(hamster).addAnimal(rat)
    cage3.printOccupants()

    val cage4 = cage3.addAnimal(mouse)
    cage4.printOccupants()
  }

  private def task7Menu(): Unit = {
    val random = new scala.util.Random

    // Генерация случайной последовательности из N пар чисел
    val sequenceSize = 1000
    val sequence = Seq.fill(sequenceSize)((random.nextInt(100), random.nextInt(100)))

    // Операции над элементами последовательности
    def operationA(pair: (Int, Int)): Int = pair._1 + pair._2

    def operationB(pair: (Int, Int)): Int = pair._1 * pair._2

    def operationC(pair: (Int, Int)): Int = math.pow(pair._1, pair._2).toInt

    def operationD(pair: (Int, Int)): Int = if (pair._2 != 0) pair._1 / pair._2 else 0

    // Время выполнения операции в одном потоке
    val startTimeSingleThread = System.currentTimeMillis()
    val resultSingleThreadA = sequence.map(operationA)
    val resultSingleThreadB = sequence.map(operationB)
    val resultSingleThreadC = sequence.map(operationC)
    val resultSingleThreadD = sequence.map(operationD)
    val endTimeSingleThread = System.currentTimeMillis()

    println(s"Time for single thread: ${endTimeSingleThread - startTimeSingleThread} ms")

    // Время выполнения операции в двух потоках
    val startTimeTwoThreads = System.currentTimeMillis()
    val resultTwoThreadsA = Future.sequence(sequence.grouped(sequenceSize / 2).map(seq => Future(seq.map(operationA))))
    val resultTwoThreadsB = Future.sequence(sequence.grouped(sequenceSize / 2).map(seq => Future(seq.map(operationB))))
    val resultTwoThreadsC = Future.sequence(sequence.grouped(sequenceSize / 2).map(seq => Future(seq.map(operationC))))
    val resultTwoThreadsD = Future.sequence(sequence.grouped(sequenceSize / 2).map(seq => Future(seq.map(operationD))))

    Await.result(resultTwoThreadsA, Duration.Inf)
    Await.result(resultTwoThreadsB, Duration.Inf)
    Await.result(resultTwoThreadsC, Duration.Inf)
    Await.result(resultTwoThreadsD, Duration.Inf)

    val endTimeTwoThreads = System.currentTimeMillis()

    println(s"Time for two threads: ${endTimeTwoThreads - startTimeTwoThreads} ms")

    // Время выполнения операции в четырех потоках
    val startTimeFourThreads = System.currentTimeMillis()
    val resultFourThreadsA = Future.sequence(sequence.grouped(sequenceSize / 4).map(seq => Future(seq.map(operationA))))
    val resultFourThreadsB = Future.sequence(sequence.grouped(sequenceSize / 4).map(seq => Future(seq.map(operationB))))
    val resultFourThreadsC = Future.sequence(sequence.grouped(sequenceSize / 4).map(seq => Future(seq.map(operationC))))
    val resultFourThreadsD = Future.sequence(sequence.grouped(sequenceSize / 4).map(seq => Future(seq.map(operationD))))

    Await.result(resultFourThreadsA, Duration.Inf)
    Await.result(resultFourThreadsB, Duration.Inf)
    Await.result(resultFourThreadsC, Duration.Inf)
    Await.result(resultFourThreadsD, Duration.Inf)

    val endTimeFourThreads = System.currentTimeMillis()

    println(s"Time for four threads: ${endTimeFourThreads - startTimeFourThreads} ms")

    // Определение точки, начиная с которой использование нескольких потоков выгодно
    val threshold = 1000

    if (sequenceSize >= threshold) {
      println("Using multiple threads is beneficial.")
    } else {
      println("Using multiple threads is not beneficial.")
    }
  }
}