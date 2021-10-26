object intsets extends App {
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, Empty, new NonEmpty(7, new NonEmpty(6, Empty, Empty), Empty))
  println(t2)
  println(t3)
  println(t2 union t3)
}

abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet): IntSet = other
  override def toString(): String = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x // Infix notation same as contains(left, x)
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet =
    (other union left union right) incl elem

  override def toString(): String =
    "{" + left + ", " + elem + ", " + right + "}"
}
