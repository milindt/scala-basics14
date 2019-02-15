package booking

sealed trait CustomerType {


}
object RegularCustomer extends CustomerType
object RewardCustomer extends CustomerType
