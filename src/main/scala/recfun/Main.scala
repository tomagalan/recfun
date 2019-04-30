package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("\nRight parenthesis")
    println("True : " + balance("(if (zero? x) max (/ 1 x))".toList))
    println("True : " + balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println("False : " + balance(":-)".toList))
    println("False : " + balance("())(".toList))
    println("\nCounting change")
    println("5 : " + countChange(5, List(1,2,3)))
    println("3 : " + countChange(4, List(1,2)))
    println("1 : " + countChange(7, List(1)))
    println("1 : " + countChange(0, List(1,2)))
    println("0 : " + countChange(4, List()))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if(c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def check(charsLeft: List[Char], count: Int): Boolean =
        if(count < 0) false
        else if(charsLeft.isEmpty) true
        else if(charsLeft.head == '(') check(charsLeft.tail, count+1)
        else if(charsLeft.head == ')') check(charsLeft.tail, count-1)
        else check(charsLeft.tail, count)

      check(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int =
      if(money == 0) 1
      else if(money > 0 && coins.nonEmpty) countChange(money-coins.head, coins) + countChange(money, coins.tail)
      else 0
  }
