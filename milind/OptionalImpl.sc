
trait Optional[T]

case class Defined[T](value: T) extends Optional[T]
case class Undefined[T]() extends Optional[T]


case class Hotel[T](name: String, rating: Optional[T])

val hotels = List(
  new Hotel[Int](name = "abc", new Defined[Int](10)),
  new Hotel[Int](name = "xyz", new Undefined[Int])
)

hotels

def rating(x: Hotel[Int]) : Int = {
  x match {
    case Defined(value) => value
    case Undefined() => 0
  }
}

def averageRating(hotels: List[Hotel[Int]]) : Int = {
    hotels.map(x => {
      rating(x)
    }).toSeq.sum / hotels.length
}


averageRating(hotels)

