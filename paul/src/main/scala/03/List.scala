
object List {

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  val ex1: List[Double] = Nil
  val ex2: List[Int] = Cons(1, Nil)
  val ex3: List[String] = Cons("a", Cons("b", Nil))

  def sumR(ints: List[Int]): Int =
    ints match {
      case Nil         => 0
      case Cons(x, xs) => x + sumR(xs)
    }
  def productR(ds: List[Double]): Double =
    ds match {
      case Nil => 1.0
      case Cons(x, xs)  => x * productR(xs)
    }

  def apply[A](ls: A*): List[A] =
    if (ls.isEmpty) Nil
    else Cons(ls.head, apply(ls.tail: _*))


  // ex_3.2
  /**
   * >>> List.tail(List(1,2,3))
   * Cons(2,Cons(3,Nil))
   *
   * >>> List.tail(List.Nil)
   * Nil
   */
    def tail[A](ls: List[A]): List[A] =
      ls match {
        case Nil         => Nil
        case Cons(_, xs) => xs
      }
  // ex_3.3
  /**
   * >>> List.setHead(0,List(1,2,3))
   * Cons(0,Cons(2,Cons(3,Nil)))
   *
   * >>> List.setHead(0, List.Nil)
   * Cons(0,Nil)
   */
    def setHead[A](a: A, ls: List[A]): List[A] =
      ls match {
        case Nil         => List(a)
        case Cons(_, xs) => Cons(a, xs)
      }
  // ex_3.4
  /**
   * >>> List.drop(2, List(1,2,3))
   * Cons(3,Nil)
   *
   * >>> List.drop(3, List(1,2,3))
   * Nil
   *
   * >>> List.drop(4, List(1,2,3))
   * Nil
   */
    def drop[A](n: Int, ls: List[A]): List[A] =
      (n, ls) match {
        case (_, Nil)         => Nil
        case (0, _)           => ls
        case (_, Cons(_, xs)) => drop(n-1, xs)
      }
  // ex_3.5
  /**
   * >>> List.dropWhile((x: Int) => x < 3)(List(1,2,3))
   * Cons(3,Nil)
   *
   * >>> List.dropWhile((x: Int) => x < 4)(List(1,2,3))
   * Nil
   *
   */
    def dropWhile[A](f: A => Boolean)(ls: List[A]): List[A] =
      ls match {
        case Cons(x, xs) if f(x) => dropWhile(f)(xs)
        case _                   => ls
      }
  /**
   * >>> List._dropWhile(List(1,2,3))(x => x < 3)
   * Cons(3,Nil)
   *
   */
    def _dropWhile[A](ls: List[A])(f: A => Boolean): List[A] =
      ls match {
        case Cons(x, xs) if f(x) => dropWhile(f)(xs)
        case _                   => ls
      }

  /**
   * >>> List.append(List(1,2), List(3))
   * Cons(1,Cons(2,Cons(3,Nil)))
   */
    def append[A](ls1: List[A], ls2: List[A]): List[A] =
      ls1 match {
        case Nil         => ls2
        case Cons(x, xs) => Cons(x, append(xs, ls2))
      }

  // ex_3.6
  /**
   * >>> List.init(List(1,2,3))
   * Cons(1,Cons(2,Nil))
   */
    def init[A](ls: List[A]): List[A] =
      ls match {
        case Nil          => ls
        case Cons(x, Nil) => Nil
        case Cons(x, xs)  => Cons(x, init(xs))
      }

    def foldRight[A,B](f: (A,B) => B, acc: B)(ls: List[A]): B =
      ls match {
        case Nil         => acc
        case Cons(x, xs) => f(x, foldRight(f, acc)(xs))
      }
    def _foldRight[A,B](ls: List[A])(f: (A,B) => B, acc: B): B =
      ls match {
        case Nil         => acc
        case Cons(x, xs) => f(x, _foldRight(xs)(f, acc))
      }

    def add(x: Int, y: Int): Int =
      x + y
    def mlt(x: Double, y: Double): Double =
      x * y
  /**
   * >>> List.sumF(List(1,2,3))
   * 6
   */
    def sumF(ls: List[Int]): Int =
      foldRight(add, 0)(ls)
  /**
   * >>> List.productF(List(0,1,2))
   * 0.0
   */
    def productF(ls: List[Double]): Double =
      foldRight(mlt, 1.0)(ls)

  // ex_3.9
    def incrementR[A](x: A, y: Int): Int =
      y + 1
  /**
   * >>> List.lengthF(List(1,2,3))
   * 3
   */
    def lengthF[A](ls: List[A]): Int =
      foldRight(incrementR, 0)(ls)

  // ex_3.10
  /**
   * >>> List.foldLeft(List.add, 0)(List(1,2,3))
   * 6
   *
   */
    @annotation.tailrec
    def foldLeft[A,B](f: (A, B) => A, acc: A)(ls: List[B]): A =
      ls match {
        case Nil         => acc
        case Cons(x, xs) => foldLeft(f, f(acc, x))(xs)
      }
    def _foldLeft[A,B](ls: List[B])(f: (A, B) => A, acc: A): A =
      foldLeft(f, acc)(ls)

  // ex_3.11
  /**
   * >>> List.sum(List(0,1,2))
   * 3
   */
    def sum(ls: List[Int]): Int =
      foldLeft(add, 0)(ls)
  /**
   * >>> List.product(List(0,1,2))
   * 0.0
   */
    def product(ls: List[Double]): Double =
      foldLeft(mlt, 1.0)(ls)
  /**
   * >>> List.length(List(0,1,2))
   * 3
   */
    def incrementL[A](x: Int, y: A): Int =
      x + 1
    def length[A](ls: List[A]): Int =
      foldLeft(incrementL, 0)(ls)

  // ex_
  /**
   * >>> List.cons(1,List.Nil)
   * Cons(1,Nil)
   *
   * >>> List.consL(List.Nil,1)
   * Cons(1,Nil)
   */
    def cons[A](x: A, xs: List[A]): List[A] =
      Cons(x, xs)
    def consL[A](xs: List[A], x: A): List[A] =
      Cons(x, xs)
    def flip[A,B,C](f: (A, B) => C): (B, A) => C =
      (y: B, x: A) => f(x, y)
  /**
   * >>> List(1,2,"3")
   * Cons(1,Cons(2,Cons(3,Nil)))
   *
   * >>> List.reverse(List(1,2,3))
   * Cons(3,Cons(2,Cons(1,Nil)))
   *
   * >>> List._reverse(List(1,2,3))
   * Cons(3,Cons(2,Cons(1,Nil)))
   */
    def fixT[A](x: A)(y: A): A = y
    def reverse[A](ls: List[A]): List[A] =
      _foldLeft(ls)(flip(cons), Nil)
    def _reverse[A](ls: List[A]): List[A] =
      {
        @annotation.tailrec
        def foldLeft[A,B](ls: List[B])(f: (A, B) => A, acc: A): A =
          ls match {
            case Nil         => acc
            case Cons(x, xs) => foldLeft(xs)(f, f(acc, x))
          }
        foldLeft(ls)(consL, Nil: List[A])
      }


    def identity[A](x: A): A = x
    def partial1_2[A,B,C](f: (A,B) => C, a: A): B => C =
      (b) => f(a, b)
    def curry[A,B,C](f: (A,B) => C): A => B => C =
      (a) => (b) => f(a, b)
    def uncurry[A,B,C](f: A => B => C): (A,B) => C =
      (a, b) => f(a)(b)
    def compose[A,B,C](f: A => B, g: C => A): C => B =
      (x) => f(g(x))

  /**
   * >>> import List._
   * >>> (curry(add)(2) compose curry(add)(3))(2)
   * 7
   *
   * >>> import List._
   * >>> (add2(1) compose add2(1))(2)
   * 4
   */
    val add2 = (x: Int) => (y: Int) =>
      x + y
    def add3(x: Int, y: Int)(z: Int): Int =
      x + y + z

  // ex_3.13
  /**
   * >>> import List._
   * >>> foldRightL(add, 0)(List(0,1,2))
   * 3
   */
    def foldRightL[A,B](f: (A, B) => A, acc: A)(ls: List[B]): A =
      foldLeft(f, acc)(reverse(ls))
    def _foldRightL[A,B](ls: List[B])(f: (A, B) => A, acc: A): A =
      foldLeft(f, acc)(reverse(ls))

  // ex_3.14
  /**
   * >>> List.appendF(List(0,1), List(2))
   * Cons(0,Cons(1,Cons(2,Nil)))
   */
    def appendF[A](ls1: List[A], ls2: List[A]): List[A] =
      _foldRightL(ls1)(consL, ls2)

  // ex_3.15
  /**
   * >>> List.joinList(List(List(0,1), List(2), List(3,4)))
   * Cons(0,Cons(1,Cons(2,Cons(3,Cons(4,Nil)))))
   */
    def joinList[A](ls: List[List[A]]): List[A] =
      _foldRight(ls)(appendF, Nil)

  // ex_3.16
  /**
   * >>> List.incrementM(List(0,1,2))
   * Cons(1,Cons(2,Cons(3,Nil)))
   */
    def incrementM(ls: List[Int]): List[Int] =
      _foldRight(ls)((x, xs: List[Int]) => cons(x + 1, xs), Nil)

  // ex_3.17
  /**
   * >>> List.stringM(List(0,1,2))
   * Cons(0.0,Cons(1.0,Cons(2.0,Nil)))
   */
    def stringM(ls: List[Double]): List[String] =
      _foldRight(ls)((x, xs: List[String]) => cons(x.toString, xs), Nil)

  // ex_3.18
  /**
   * >>> import List._
   * >>> map(add2(1), List(0,1,2))
   * Cons(1,Cons(2,Cons(3,Nil)))
   */
    def map[A,B](f: A => B, ls: List[A]): List[B] =
      _foldRight(ls)((x, xs: List[B]) => cons(f(x), xs), Nil)

  // ex_3.19
  /**
   * >>> List.even(2)
   * true
   *
   * >>> List.even(1)
   * false
   *
   * >>> import List._
   * >>> filter(even, List(0,1,2))
   * Cons(0,Cons(2,Nil))
   */
    def filter[A](f: A => Boolean, ls: List[A]): List[A] =
    { def consF[A](f: A => Boolean, x: A, xs: List[A]): List[A] =
        if (f(x)) cons(x, xs)
        else xs
      _foldRight(ls)((x, xs: List[A]) => consF(f, x, xs), Nil)
    }
    def even(i: Int): Boolean =
      i % 2 == 0


  /*

   */

  // ex_
  /**
   * >>> import List._
   */

  }

