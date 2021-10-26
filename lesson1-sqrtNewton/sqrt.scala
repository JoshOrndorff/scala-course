object sqrt {
  def main(args: Array[String]) = {
    println("square root of 4 is " + sqrt(4))
    println("square root of 10 is " + sqrt(10))
    println("square root of 6 is " + sqrt(6))
  }

  def abs(x:Double):Double = if (x >= 0) x else -x

  def sqrt(x:Double):Double = {

    def sqrtIter(guess:Double):Double =
      if(goodGuess(guess)) guess else sqrtIter(newGuess(guess))

    def goodGuess(guess:Double):Boolean =
      abs(guess * guess - x) < x / 100

    def newGuess(guess:Double):Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }
}
