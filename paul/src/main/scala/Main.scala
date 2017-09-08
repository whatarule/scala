
object Main {

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b) => f(a, b)
  def curry[A,B,C](f: (A,B) => C): A => B => C =
    (a) => (b) => f(a, b)
  def uncurry[A,B,C](f: A => B => C): (A,B) => C =
    (a, b) => f(a)(b)
  def compose[A,B,C](f: A => B, g: C => A): C => B =
    (x) => f(g(x))

  def main(args: Array[String]): Unit =
    { println(
          "main"
        )
    }
}

