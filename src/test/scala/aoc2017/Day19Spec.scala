package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day19Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day19

//    it("should process the file") {
//      x.getFileAndDoWork
//    }

    it("should get ABCDEF") {
      x.getFileAndDoWork("input/Day19-2") shouldBe "ABCDEF"
    }
  }
}
