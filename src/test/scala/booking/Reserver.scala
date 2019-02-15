package booking

case class Reserver() {

  def dayNumToDay(numOfDay: Int): Day = {

    numOfDay match {
      case 1 => WeekDay
      case 2 => WeekDay
      case 3 => WeekDay
      case 4 => WeekDay
      case 5 => WeekDay
      case 6 => WeekEnd
      case 7 => WeekEnd
      case _ =>
        throw new NotImplementedError()
    }
  }

  def days(t: (Int, Int)): List[Day] = {
    List.range(t._1, t._2 + 1).map(dayNumToDay)
  }

  def bookingPriceOf(hotel: Hotel, request: BookingRequest): Int = {
      days(request.daysOfWeek)
        .map(d => d match {
          case WeekDay => hotel.weekdayRate(request.customerType)
          case WeekEnd => hotel.weekendRate(request.customerType)
        }).sum
  }

  def book(request: BookingRequest with Object): Hotel = {
    return HOTELS.all
      .sortWith((a, b) =>
        bookingPriceOf(a, request) < bookingPriceOf(b, request))
      .take(1)
      .head
  }

}
