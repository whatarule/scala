

object Polymorphic {

// ex_2.2
  def isSorted[A](xs: List[A], f: (A,A) => Boolean): Boolean =
    xs == xs.sortWith(f)

  def lt(i: Int, j: Int): Boolean =
    i < j
  def gt(i: Int, j: Int): Boolean =
    i > j


  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b) => f(a, b)

// ex_2.3
  def curry[A,B,C](f: (A,B) => C): A => B => C =
    (a) => (b) => f(a, b)
  def uncurry[A,B,C](f: A => B => C): (A,B) => C =
    (a, b) => f(a)(b)

// ex_2.4
  def compose[A,B,C](f: A => B, g: C => A): C => B =
    (x) => f(g(x))


  def add(x: Int, y: Int): Int =
    x + y
  def mlt(x: Int, y: Int): Int =
    x * y

      //  isSorted(List(1,2,3), (i: Int, j: Int) => i < j)
      //  curry(add)(1)(2)
      //  uncurry(curry(add))(1, 2)
      //  compose(curry(add)(1), curry(mlt)(2))(1)
}

