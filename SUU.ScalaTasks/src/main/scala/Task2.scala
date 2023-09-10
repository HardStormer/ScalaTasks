object Task2 {
  def countOnesInBinary(number: Int): Int = {
    number.toBinaryString.count(_ == '1')
  }

  def printStaircase(n: Int): Unit = {
    for (i <- 1 to n) {
      for (j <- 1 to i) {
        print(s"$j ")
      }
      println()
    }
  }

  def isSnakeCase(input: String): Boolean = {
    val snakeCasePattern = "^[a-z]+(_[a-z]+)*$".r

    snakeCasePattern.findFirstMatchIn(input) match {
      case Some(_) => true
      case None => false
    }
  }
}
