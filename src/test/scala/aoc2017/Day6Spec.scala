package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day6Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day6

    it("should process the file") {
      x.getFileAndDoWork
    }

    it("should get 5") {
      x.doWork("0 2 7 0") shouldBe (5, 4)
    }
  }
}
