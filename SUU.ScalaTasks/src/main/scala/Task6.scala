object Task6 {
  trait Animal {
    def name: String
  }

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
      println(s"Cage occupants: ${occupants.map(_.name).mkString(", ")}")
    }
  }

}
