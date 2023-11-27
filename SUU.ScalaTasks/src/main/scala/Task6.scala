object Task6 {
  trait Animal {
    def name: String
  }

  class Hospital(val name: String, val list: List[AnimalCage[Animal]])
  class MediumAnimal(val name: String) extends Animal

  class SmallAnimal(val name: String) extends Animal

  class AnimalCage[+A <: Animal](val occupants: List[A]) {
    def addAnimal[B >: A <: Animal](animal: B): AnimalCage[B] = {
      if (occupants.length < 1) new AnimalCage[B](animal :: occupants)
      else this
    }

    def releaseAnimal[B >: A <: Animal](animal: B): AnimalCage[B] = {
      new AnimalCage[B](occupants.filterNot(_ == animal))
    }

    def printOccupants(): Unit = {
      println(s"В клетке: ${occupants.map(_.name).mkString(", ")}")
    }
  }

}
