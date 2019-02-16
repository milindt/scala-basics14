

case class Person(name: String, age: Int)


//constructor  or Person.apply
val person = Person("Milind", 30)

//decomposing/ unboxing or Person.unapply
val Person(na, age) = person


//Hence this is working

person match {
  case Person(a, b) => print("Hi $a", a)
}


// Homework,
// add unupply method to an object and
// make is return Option[(String, String)]