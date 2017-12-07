package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day3Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day3

//    it("should process the file") {
//      x.getFileAndDoWork
//    }

    it("should get 18") {
      x.doWork(10) shouldBe 15
    }

//    it("should get 1494") {
//      val s =
//        """200 1  9 5
//          |7  500 3
//          |2 4 6  800""".stripMargin
//
//      x.doWork(s) shouldBe (199 + 497 + 798)
//    }
  }
}
