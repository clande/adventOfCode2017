package aoc2017

import org.scalatest.{FunSpecLike, Matchers}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar

class Day1Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("Day1") {
    val d = new Day1

    it("should print the input file") {
      d.getFileAndDoWork
    }
    it("should get 3 for 1122") {
      d.work("1122") shouldBe 3
    }
    it("should get 4 for 1111") {
      d.work("1111") shouldBe 4
    }
    it("should get 5 for 211112") {
      d.work("211112") shouldBe 5
    }
    it("should get 3 for 23111123") {
      d.work("23111123") shouldBe 3
    }
    it("should get 0 for 1234") {
      d.work("1234") shouldBe 0
    }
    it("should get 9 for 91212129") {
      d.work("91212129") shouldBe 9
    }
  }
}
