

trait Tree[T]
case class Node[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]
case class Leaf[T]() extends Tree[T]
case class Empty[T]() extends Tree[T]




///ADT
// uses sealed data types
//Algebriac Data Types,
// Used with pattern mathing


// Enums are similar