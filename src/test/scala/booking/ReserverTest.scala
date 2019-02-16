package booking

import org.scalatest.{FunSuite, Matchers}

class ReserverTest extends FunSuite with Matchers {


  test("Should be able to initialize Booking") {
    val reserver = Reserver()
    reserver shouldEqual Reserver()
  }

  /*test("Should accept a request for booking") {
    val reserver = new Reserver()
    reserver.book(new BookingRequest {null, null})
  }*/

  test("A BookingRequest should accept duration and CustomerType") {
    val bookingRequest = BookingRequest((3, 5), RegularCustomer)
    bookingRequest.customerType shouldBe a[CustomerType]
  }

  test("Should return a Hotel on booking") {
    val hotel = Reserver().book(BookingRequest((3, 5), RegularCustomer))
    hotel shouldBe a[Hotel]
  }

  test("Lakewood Hotel has 3 rating") {
    val hotel = Lakewood
    hotel.rating shouldEqual 3
  }

  test("Lakewood Hotel has weekday rate of 110$ for regular customer") {
    val hotel = Lakewood
    hotel.weekdayRate(RegularCustomer) shouldEqual 110
  }

  test("Lakewood Hotel has weekday rate of 80$ for reward customer") {
    val hotel = Lakewood
    hotel.weekdayRate(RewardCustomer) shouldEqual 80
  }

  test("Lakewood Hotel has weekend rate of 90$ for regular customer") {
    val hotel = Lakewood
    hotel.weekendRate(RegularCustomer) shouldEqual 90
  }

  test("Lakewood Hotel has weekend rate of 80$ for reward customer") {
    val hotel = Lakewood
    hotel.weekendRate(RewardCustomer) shouldEqual 80
  }

  test("Bridgewood Hotel has 4 rating") {
    val hotel = Bridgewood
    hotel.rating shouldEqual 4
  }

  test("Bridgewood Hotel has weekday rate of 160$ for regular customer") {
    val hotel = Bridgewood
    hotel.weekdayRate(RegularCustomer) shouldEqual 160
  }

  test("Bridgewood Hotel has weekday rate of 110$ for reward customer") {
    val hotel = Bridgewood
    hotel.weekdayRate(RewardCustomer) shouldEqual 110
  }

  test("Bridgewood Hotel has weekend rate of 60$ for regular customer") {
    val hotel = Bridgewood
    hotel.weekendRate(RegularCustomer) shouldEqual 60
  }

  test("Bridgewood Hotel has weekend rate of 50$ for reward customer") {
    val hotel = Bridgewood
    hotel.weekendRate(RewardCustomer) shouldEqual 50
  }

  test("Ridgewood Hotel has 4 rating") {
    val hotel = Ridgewood
    hotel.rating shouldEqual 5
  }

  test("Ridgewood Hotel has weekday rate of 220$ for regular customer") {
    val hotel = Ridgewood
    hotel.weekdayRate(RegularCustomer) shouldEqual 220
  }

  test("Ridgewood Hotel has weekday rate of 100$ for reward customer") {
    val hotel = Ridgewood
    hotel.weekdayRate(RewardCustomer) shouldEqual 100
  }

  test("Ridgewood Hotel has weekend rate of 150$ for regular customer") {
    val hotel = Ridgewood
    hotel.weekendRate(RegularCustomer) shouldEqual 150
  }

  test("Ridgewood Hotel has weekend rate of 50$ for reward customer") {
    val hotel = Ridgewood
    hotel.weekendRate(RewardCustomer) shouldEqual 40
  }

  test("Reserver should be able to identify Weekdays") {
    val days = Reserver().days((1, 5))
    days shouldBe a[List[Day]]
    days.length shouldEqual 5
    days.foreach(d => d shouldEqual WeekDay)
  }

  test("Reserver should be able to identify Weekends") {
    val days = Reserver().days((6, 7))
    days shouldBe a[List[Day]]
    days.foreach(d => d shouldEqual WeekEnd)
  }

  test("Reserver should be able to identify Weekdays and Weekends") {
    val days = Reserver().days((5, 7))
    days shouldBe a[List[Day]]
    val iterator = days.iterator
    iterator.next() shouldEqual WeekDay
    iterator.next() shouldEqual WeekEnd
    iterator.next() shouldEqual WeekEnd
  }

  test("Customer should get hotel with min pricing") {
    val hotel = Reserver().book(BookingRequest((1, 2), RegularCustomer))
    hotel shouldEqual Lakewood
  }

  test("Reward Customer should get Rigdwood for weekends") {
    val hotel = Reserver().book(BookingRequest((6, 7), RewardCustomer))
    hotel shouldEqual Ridgewood
  }

  /*test("Customer should get hotel with highest rating if Bill is same") {
    val bookingRequest = BookingRequest((5, 6), RewardCustomer)

    //Asserting booking prices are same
    Reserver()
      .bookingPriceOf(Lakewood, bookingRequest) shouldEqual Reserver()
      .bookingPriceOf(Bridgewood, bookingRequest)

    //Asserting hotel is return based on ratings
    Reserver().book(bookingRequest) shouldEqual Bridgewood
  }*/

}
