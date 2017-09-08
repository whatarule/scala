



class TestDoctest
    extends org.scalatest.FunSpec
    with org.scalatest.Matchers
     {

  def sbtDoctestTypeEquals[A](a1: => A)(a2: => A): Unit = ()
  def sbtDoctestReplString(any: Any): String = {
    val s = scala.runtime.ScalaRunTime.replStringOf(any, 1000).init
    if (s.headOption == Some('\n')) s.tail else s
  }

  describe("Test.scala:4: add") {
    it("example at line 5: Test.add(1,2)") {
      sbtDoctestReplString(Test.add(1,2)) should equal("3")
    }
  }
}
