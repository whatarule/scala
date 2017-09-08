
object Factorial {
    def factorial(n: Int): Int =
      { @annotation.tailrec
        def go(n: Int, acc: Int): Int =
          if (n <= 0) acc
          else go(n-1, n*acc)
        go(n, 1)
      }
    def _factorial(n: Int): Int =
      { if (n < 2) n
        else n * _factorial(n-1)
      }

    private def formatResult(name: String, n: Int, f: Int => Int): String =
      { val msg = "The %s of %d is %d"
        msg.format(name, n, f(n))
      }

  // ex_2.1
    def fib(n: Int): Int =
      if (n < 2) n
      else fib(n-2) + fib (n-1)


        //  _factorial(3)
        //  fib(5)
        //  formatResult("factorial", 7, factorial)
  }



