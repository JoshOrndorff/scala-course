object RatRunner {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  def main(args: Array[String]) = {
    println(x - y - z)
    println(y + y)
    println(x < y)
    println(x max z)
  }
}

class Rational(top: Int, bot: Int){
  require(bot != 0, "Denominator may not be zero.")

  // Secondary constructor (must call primary implicit constructor)
  def this(top: Int) = this(top, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val d = gcd(top, bot)
  def numer = top
  def denom = bot

  def unary_-() = new Rational(-numer, denom)

  def + (other: Rational) = new
    Rational(numer * other.denom + denom * other.numer, denom * other.denom)

  def - (other: Rational) = this + -other

  def < (other: Rational): Boolean = numer * other.denom < other.numer * denom

  def max(other: Rational): Rational = if (this < other) other else this


  override def toString() = numer / d + "/" + denom / d

}
