package booking

trait Hotel {

  def weekdayRate(customerType: CustomerType):Int
  def weekendRate(customerType: CustomerType) :Int
}

case object Bridgewood extends Hotel {
  def weekendRate(customerType: CustomerType) :Int = {
    if(customerType==RegularCustomer)
      60
    else if (customerType == RewardCustomer)
      50
    else throw new NotImplementedError()
  }

  def weekdayRate(customerType: CustomerType):Int = {
    if (customerType == RegularCustomer)
      160
    else if (customerType == RewardCustomer)
      110
    else throw new NotImplementedError()
  }


  val rating = 4

}

case object Lakewood extends Hotel {
  def weekendRate(customerType: CustomerType): Int= {
    if(customerType == RegularCustomer)
      90
    else if(customerType == RewardCustomer)
      80
    else throw new NotImplementedError()
  }

  def weekdayRate(customerType: CustomerType): Int = {
    if (customerType == RegularCustomer)
      110
    else if (customerType == RewardCustomer)
      80
    else throw new NotImplementedError()
  }

  val rating = 3
}

case object Ridgewood extends Hotel {
  def weekendRate(customerType: CustomerType): Int = {
    if(customerType == RegularCustomer)
      150
    else if(customerType == RewardCustomer)
      40
    else throw new NotImplementedError()
  }

  def weekdayRate(customerType: CustomerType) : Int = {
    if(customerType==RegularCustomer)
      220
    else if (customerType == RewardCustomer)
      100
    else throw new NotImplementedError()
  }

  val rating = 5

}

  object HOTELS {
     val all = List(Lakewood, Bridgewood, Ridgewood)
  }