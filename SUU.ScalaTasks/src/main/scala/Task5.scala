object Task5 {
  class Person(val firstName: String, val lastName: String)

  class Student(firstName: String, lastName: String, val course: Int, val direction: String, val groupNumber: Int)
    extends Person(firstName, lastName) {
    private var attendanceScore: Int = 0
    private var labWorkScore: Int = 0
    private var examScore: Int = 0

    def addAttendanceScore: Unit ={
      if(attendanceScore < 10){
        attendanceScore += 1
      }
    }

    def addLabWorkScore: Unit = {
      if (labWorkScore < 10) {
        labWorkScore += 1
      }
    }

    def setExamScore(score: Int){
      if (examScore <= 40) {
        examScore = score
      }
    }

    def getTotalScore: Int = attendanceScore + labWorkScore + examScore

    def getGrade: String = {
      val totalScore = getTotalScore
      if (totalScore >= 90) "5"
      else if (totalScore >= 76) "4"
      else if (totalScore >= 60) "3"
      else "Не прошел"
    }
  }

  class Teacher(firstName: String, lastName: String) extends Person(firstName, lastName)

  class Lecture(val topic: String, val lecturer: Teacher, val group: List[Student]) {
    def markAttendance(): Unit = {
      group.foreach(student => student.addAttendanceScore)
    }
  }

  class Practical(val topic: String, val lecturer: Teacher, val group: List[Student]) {
    def markLabWork(): Unit = {
      group.foreach(student => student.addLabWorkScore)
    }
  }

  class Exam(val topic: String, val lecturer: Teacher, val group: List[Student]) {
    def conductExam(): Unit = {
      group.foreach(student => student.setExamScore(util.Random.nextInt(41)))
    }
  }
}
