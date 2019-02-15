import scala.annotation.tailrec

val nums = List(1, 2, 3)

/*def map(nums: List[Int], f: Int => Int) = {

  var result = List.empty[Int]
  val iterator = nums.iterator
  while(iterator.hasNext) {
    result = f(iterator.next()) :: result
  }
  result.reverse
}*/

def map[T](nums: List[T], f: T => T) = {

  var result = List.empty[T]
  val iterator = nums.iterator
  while(iterator.hasNext) {
    result = f(iterator.next()) :: result
  }
  result.reverse
}


map(nums, (x:Int) =>x + x)


/*
def reduce(nums: List[Int], f: (Int, Int) => Int) : Int = {

  var result = 0
  val iterator = nums.iterator

  while(iterator.hasNext) {
    result = f.apply(result, iterator.next())
  }
  result
}

reduce(nums, (a , b) => a + b )
*/


def reduceF(nums: List[Int], f: (Int, Int) => Int) : Int = {

  @tailrec
  def reduceFRec(nums: List[Int], f: (Int, Int) => Int, acc: Int) : Int = {
      if (nums.isEmpty) {
        acc
      } else {
        reduceFRec(nums.tail, f, f(acc, nums.head))
      }
  }

  reduceFRec(nums, f, 1)
}

reduceF(nums, (a , b) => a*b)
