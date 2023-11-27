object Task5 {
  class Person(val firstName: String, val lastName: String)

  class Student(firstName: String, lastName: String, val course: Int, val direction: String, val groupNumber: Int)
    extends Person(firstName, lastName) {
    var attendanceScore: Int = 0
    var labWorkScore: Int = 0
    var examScore: Int = 0

    def getTotalScore: Int = attendanceScore + labWorkScore + examScore

    def getGrade: String = {
      val totalScore = getTotalScore
      if (totalScore >= 90) "5"
      else if (totalScore >= 76) "4"
      else if (totalScore >= 60) "3"
      else "Fail"
    }
  }

  class Teacher(firstName: String, lastName: String) extends Person(firstName, lastName)

  class Lecture(val topic: String, val lecturer: Teacher, val group: List[Student]) {
    def markAttendance(): Unit = {
      group.foreach(student => student.attendanceScore += 10)
    }
  }

  class Practical(val topic: String, val lecturer: Teacher, val group: List[Student]) {
    def markLabWork(): Unit = {
      group.foreach(student => student.labWorkScore += 10)
    }
  }

  class Exam(val topic: String, val lecturer: Teacher, val group: List[Student]) {
    def conductExam(): Unit = {
      group.foreach(student => student.examScore += util.Random.nextInt(41))
    }
  }
}
