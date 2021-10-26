

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat) : Nat = {
    if (that.isZero) this
    else this.successor +that.predecessor
  }


  def - (that: Nat): Nat = {
    // Don't have to worry about negatives. If we get there, predecessor will do the throwing.
    if (that.isZero) this
    else this.predecessor - that.predecessor
  }
}

object zero extends Nat{
  def isZero = true
  def predecessor = throw new Exception()
}

class Succ(val n: Nat) extends Nat {
  def isZero = false
  def predecessor = n
}
