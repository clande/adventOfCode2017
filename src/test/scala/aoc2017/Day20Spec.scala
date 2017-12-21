package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day20Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day20

//    it("should process the file") {
//      x.getFileAndDoWork
//    }

    it("should get 18") {
      x.doWork(10) shouldBe 15
    }
  }
}
