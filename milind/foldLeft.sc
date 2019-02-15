import scala.annotation.tailrec

/*def reduceF[O, I](nums: List[I],f: (O, I) => O) : O = {

  @tailrec
  def reduceFRec(nums: List[I], f: (O, I) => O, acc: O) : O = {
    if (nums.isEmpty) {
      acc
    } else {
      reduceFRec(nums.tail, f, f(acc, nums.head))
    }
  }

  reduceFRec(nums, f, )
}*/


def foldLeft[A, B](list: List[B], acc: A)(f:(A, B) => A):A = {

  @tailrec
  def reduceRec(list: List[B], acc: A) : A = {
    if (list.isEmpty) {
      acc
    } else {
      reduceRec(list.tail, f(acc, list.head))
    }
  }
  reduceRec(list, acc)
}

val list = List(1 , 2, 3, 4)
foldLeft(list,0)((a, b)=>a + b)
foldLeft(list,"")((a, b)=>a + b)
/*val reverse = foldLeft(list,List.empty)((a, b)=> b :: a)*/
//foldLeft(list,List.empty)((a, b:)=> b :: a)

/*def map[A, B](list: List[A])(f: A => B) : List[B] = {
  val value = foldLeft(list, List.empty[B])((acc, b) => f(b) :: acc)
  reverse()
}*/

map(list)( x => x * x)

/*{

  @tailrec
  def reduceFRec(nums: List[I], f: (O, I) => O, acc: O) : O = {
    if (nums.isEmpty) {
      acc
    } else {
      reduceFRec(nums.tail, f, f(acc, nums.head))
    }
  }

  foldFor(acc)
}*/
