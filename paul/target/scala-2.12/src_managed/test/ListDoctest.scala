



class ListDoctest
    extends org.scalatest.FunSpec
    with org.scalatest.Matchers
     {

  def sbtDoctestTypeEquals[A](a1: => A)(a2: => A): Unit = ()
  def sbtDoctestReplString(any: Any): String = {
    val s = scala.runtime.ScalaRunTime.replStringOf(any, 1000).init
    if (s.headOption == Some('\n')) s.tail else s
  }

  describe("List.scala:29: tail") {
    it("example at line 30: List.tail(List(1,2,3))") {
      sbtDoctestReplString(List.tail(List(1,2,3))) should equal("Cons(2,Cons(3,Nil))")
    }

    it("example at line 33: List.tail(List.Nil)") {
      sbtDoctestReplString(List.tail(List.Nil)) should equal("Nil")
    }
  }

  describe("List.scala:42: setHead") {
    it("example at line 43: List.setHead(0,List(1,2,3))") {
      sbtDoctestReplString(List.setHead(0,List(1,2,3))) should equal("Cons(0,Cons(2,Cons(3,Nil)))")
    }

    it("example at line 46: List.setHead(0, List.Nil)") {
      sbtDoctestReplString(List.setHead(0, List.Nil)) should equal("Cons(0,Nil)")
    }
  }

  describe("List.scala:55: drop") {
    it("example at line 56: List.drop(2, List(1,2,3))") {
      sbtDoctestReplString(List.drop(2, List(1,2,3))) should equal("Cons(3,Nil)")
    }

    it("example at line 59: List.drop(3, List(1,2,3))") {
      sbtDoctestReplString(List.drop(3, List(1,2,3))) should equal("Nil")
    }

    it("example at line 62: List.drop(4, List(1,2,3))") {
      sbtDoctestReplString(List.drop(4, List(1,2,3))) should equal("Nil")
    }
  }

  describe("List.scala:72: dropWhile") {
    it("example at line 73: List.dropWhile((x: Int) => x < 3)(List(1,2,3))") {
      sbtDoctestReplString(List.dropWhile((x: Int) => x < 3)(List(1,2,3))) should equal("Cons(3,Nil)")
    }

    it("example at line 76: List.dropWhile((x: Int) => x < 4)(List(1,2,3))") {
      sbtDoctestReplString(List.dropWhile((x: Int) => x < 4)(List(1,2,3))) should equal("Nil")
    }
  }

  describe("List.scala:85: _dropWhile") {
    it("example at line 86: List._dropWhile(List(1,2,3))(x => x < 3)") {
      sbtDoctestReplString(List._dropWhile(List(1,2,3))(x => x < 3)) should equal("Cons(3,Nil)")
    }
  }

  describe("List.scala:96: append") {
    it("example at line 97: List.append(List(1,2), List(3))") {
      sbtDoctestReplString(List.append(List(1,2), List(3))) should equal("Cons(1,Cons(2,Cons(3,Nil)))")
    }
  }

  describe("List.scala:107: init") {
    it("example at line 108: List.init(List(1,2,3))") {
      sbtDoctestReplString(List.init(List(1,2,3))) should equal("Cons(1,Cons(2,Nil))")
    }
  }

  describe("List.scala:133: sumF") {
    it("example at line 134: List.sumF(List(1,2,3))") {
      sbtDoctestReplString(List.sumF(List(1,2,3))) should equal("6")
    }
  }

  describe("List.scala:139: productF") {
    it("example at line 140: List.productF(List(0,1,2))") {
      sbtDoctestReplString(List.productF(List(0,1,2))) should equal("0.0")
    }
  }

  describe("List.scala:149: lengthF") {
    it("example at line 150: List.lengthF(List(1,2,3))") {
      sbtDoctestReplString(List.lengthF(List(1,2,3))) should equal("3")
    }
  }

  describe("List.scala:157: foldLeft") {
    it("example at line 158: List.foldLeft(List.add, 0)(List(1,2,3))") {
      sbtDoctestReplString(List.foldLeft(List.add, 0)(List(1,2,3))) should equal("6")
    }
  }

  describe("List.scala:172: sum") {
    it("example at line 173: List.sum(List(0,1,2))") {
      sbtDoctestReplString(List.sum(List(0,1,2))) should equal("3")
    }
  }

  describe("List.scala:178: product") {
    it("example at line 179: List.product(List(0,1,2))") {
      sbtDoctestReplString(List.product(List(0,1,2))) should equal("0.0")
    }
  }

  describe("List.scala:184: incrementL") {
    it("example at line 185: List.length(List(0,1,2))") {
      sbtDoctestReplString(List.length(List(0,1,2))) should equal("3")
    }
  }

  describe("List.scala:194: cons") {
    it("example at line 195: List.cons(1,List.Nil)") {
      sbtDoctestReplString(List.cons(1,List.Nil)) should equal("Cons(1,Nil)")
    }

    it("example at line 198: List.consL(List.Nil,1)") {
      sbtDoctestReplString(List.consL(List.Nil,1)) should equal("Cons(1,Nil)")
    }
  }

  describe("List.scala:207: fixT") {
    it("example at line 208: List(1,2,\"3\")") {
      sbtDoctestReplString(List(1,2,"3")) should equal("Cons(1,Cons(2,Cons(3,Nil)))")
    }

    it("example at line 211: List.reverse(List(1,2,3))") {
      sbtDoctestReplString(List.reverse(List(1,2,3))) should equal("Cons(3,Cons(2,Cons(1,Nil)))")
    }

    it("example at line 214: List._reverse(List(1,2,3))") {
      sbtDoctestReplString(List._reverse(List(1,2,3))) should equal("Cons(3,Cons(2,Cons(1,Nil)))")
    }
  }

  describe("List.scala:242: add2") {
    import List._

    it("example at line 244: (curry(add)(2) compose curry(add)(3))(2)") {
      sbtDoctestReplString((curry(add)(2) compose curry(add)(3))(2)) should equal("7")
    }

    import List._

    it("example at line 248: (add2(1) compose add2(1))(2)") {
      sbtDoctestReplString((add2(1) compose add2(1))(2)) should equal("4")
    }
  }

  describe("List.scala:257: foldRightL") {
    import List._

    it("example at line 259: foldRightL(add, 0)(List(0,1,2))") {
      sbtDoctestReplString(foldRightL(add, 0)(List(0,1,2))) should equal("3")
    }
  }

  describe("List.scala:268: appendF") {
    it("example at line 269: List.appendF(List(0,1), List(2))") {
      sbtDoctestReplString(List.appendF(List(0,1), List(2))) should equal("Cons(0,Cons(1,Cons(2,Nil)))")
    }
  }

  describe("List.scala:276: joinList") {
    it("example at line 277: List.joinList(List(List(0,1), List(2), List(3,4)))") {
      sbtDoctestReplString(List.joinList(List(List(0,1), List(2), List(3,4)))) should equal("Cons(0,Cons(1,Cons(2,Cons(3,Cons(4,Nil)))))")
    }
  }

  describe("List.scala:284: incrementM") {
    it("example at line 285: List.incrementM(List(0,1,2))") {
      sbtDoctestReplString(List.incrementM(List(0,1,2))) should equal("Cons(1,Cons(2,Cons(3,Nil)))")
    }
  }

  describe("List.scala:292: stringM") {
    it("example at line 293: List.stringM(List(0,1,2))") {
      sbtDoctestReplString(List.stringM(List(0,1,2))) should equal("Cons(0.0,Cons(1.0,Cons(2.0,Nil)))")
    }
  }

  describe("List.scala:300: map") {
    import List._

    it("example at line 302: map(add2(1), List(0,1,2))") {
      sbtDoctestReplString(map(add2(1), List(0,1,2))) should equal("Cons(1,Cons(2,Cons(3,Nil)))")
    }
  }

  describe("List.scala:309: filter") {
    it("example at line 310: List.even(2)") {
      sbtDoctestReplString(List.even(2)) should equal("true")
    }

    it("example at line 313: List.even(1)") {
      sbtDoctestReplString(List.even(1)) should equal("false")
    }

    import List._

    it("example at line 317: filter(even, List(0,1,2))") {
      sbtDoctestReplString(filter(even, List(0,1,2))) should equal("1")
    }
  }
}
