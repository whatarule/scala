

import org.scalacheck.Arbitrary._

class _TestDoctest
    extends org.scalatest.FunSpec
    with org.scalatest.Matchers
    with org.scalatest.prop.Checkers {

  def sbtDoctestTypeEquals[A](a1: => A)(a2: => A): Unit = ()
  def sbtDoctestReplString(any: Any): String = {
    val s = scala.runtime.ScalaRunTime.replStringOf(any, 1000).init
    if (s.headOption == Some('\n')) s.tail else s
  }

  describe("_Test.scala:5: f") {
    it("example at line 10: Test.f(10)") {
      sbtDoctestReplString(Test.f(10)) should equal("20")
    }

    it("example at line 14: Test.f(20)") {
      sbtDoctestReplString(Test.f(20)) should equal("40")
      sbtDoctestTypeEquals(Test.f(20))((Test.f(20)): Int)
    }

    it("property at line 18: (i: Int) => Test.f(i) == (i * 2)") {
      check {
        (i: Int) => Test.f(i) == (i * 2)
      }
    }
  }

  describe("_Test.scala:23: add") {
    it("example at line 28: Test.add(1,2)") {
      sbtDoctestReplString(Test.add(1,2)) should equal("3")
    }
  }
}
