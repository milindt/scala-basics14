
sealed trait Optional[T]
case class Defined[T](value: T) extends Optional[T]
case class Undefined[T]() extends Optional[T]
case class CL[T](head: Optional[T], tail: Optional[CL[T]])

val list = CL(Defined[Int](10), Undefined[CL[Int]]())
list



//OR, refer Mushtaqs impl



def length[A](list: )

