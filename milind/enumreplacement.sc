
sealed trait Day

object Day {
  object Weekday extends Day
  object Weekend extends Day
}

val d = Day.Weekday




