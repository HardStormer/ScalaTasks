object Task4 {
  def kOrderStatistic(k: Int, nums: List[Int]): Int = {
    def partition(list: List[Int], pivot: Int): (List[Int], List[Int], List[Int]) = {
      list.foldLeft((List[Int](), List[Int](), List[Int]())) {
        case ((less, equal, greater), num) =>
          if (num < pivot) (num :: less, equal, greater)
          else if (num == pivot) (less, num :: equal, greater)
          else (less, equal, num :: greater)
      }
    }

    nums match {
      case Nil => throw new IllegalArgumentException("Empty list")
      case head :: tail =>
        val (less, equal, greater) = partition(tail, head)
        if (less.length == k - 1) head
        else if (less.length >= k) kOrderStatistic(k, less)
        else kOrderStatistic(k - less.length - 1, greater)
    }
  }

  type Point = (Int, Int)
  type Ship = List[Point]
  type Field = Vector[Vector[Boolean]]

  def addShipToField(field: Field, ship: Ship): Field = {
    ship.foldLeft(field) { (accField, point) =>
      val (x, y) = point
      if (x >= 0 && x < 10 && y >= 0 && y < 10)
        accField.updated(x, accField(x).updated(y, true))
      else
        accField
    }
  }




}
