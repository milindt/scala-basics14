


def insertPreservingOrder(list: List[Int], num:Int) : List[Int] = {

    list match {
      case Nil => Nil
      case head :: tail if num < head => num :: list
      case head :: tail => insertPreservingOrder(list.tail, num)
    }

}

def sort(list: List[Int]): List[Int] = list match {
  case Nil => Nil
  case head :: tail => insertPreservingOrder(sort(tail), head)
}



val list = List(0, 1, 7, 16, 100)


insertPreservingOrder(list, 13)
sort(List(3,7,4,3,99,44))
