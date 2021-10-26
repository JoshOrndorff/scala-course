package idealized.scala

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("No head")
  def tail: Nothing = throw new NoSuchElementException("No Tail")
}

object List {
  def apply[T](x: T, y: T): List[T] =
    new Cons[T](x, new Cons[T](y, new Nil[T]))

  def apply[T](x: T): List[T] =
    new Cons[T](x, new Nil[T])

  def apply[T](): List[T] = new Nil[T]
}
