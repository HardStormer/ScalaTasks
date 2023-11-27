import scala.language.postfixOps

object Task31 {
  def reverseWords(input: String): String = {
    input.split("\\s+").reverse.mkString(" ")
  }
}
object Task32 {import scala.annotation.tailrec
  def reverseWordsTailRec(input: String): String = {
    @tailrec
    def reverseAcc(words: List[String], acc: String): String = {
      words match {
        case Nil => acc
        case head :: tail => reverseAcc(tail, s"$head $acc")
      }
    }

    val wordsList = input.split("\\s+").toList
    reverseAcc(wordsList, "")
  }
}
object Task33 {
  def calculateChipsWeight(potatoWeight: Double, potatoWaterRatio: Double, chipsWaterRatio: Double): Double = {
  potatoWeight * (1 - potatoWaterRatio) / (1 - chipsWaterRatio)
  }
}