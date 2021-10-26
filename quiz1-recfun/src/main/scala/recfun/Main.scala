package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (r == 0 || c == 0 || r == c) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balLoop(open: Int, chars: List[Char]): Boolean = {
        if (open < 0) false else {
          if (chars.isEmpty) true else
            balLoop(open + change(chars.head), chars.tail)
        }
      }

      def change(char: Char): Int =
        if (char == '(') 1 else {
          if (char == ')') -1 else 0
        }

      balLoop(0, chars)
    }

  /**
   * Exercise 3
   */
   // Assume each coin is at least double the next smallest coin
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (coins.isEmpty || money < 0) 0
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
