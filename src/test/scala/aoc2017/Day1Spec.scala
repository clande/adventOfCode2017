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

  describe("Day1Part2") {
    val d = new Day1Part2

    it("should print the input file") {
      d.getFileAndDoWork
    }
    it("should get 6 for 1212") {
      d.work("1212") shouldBe 6
    }
    it("should get 0 for 1221") {
      d.work("1221") shouldBe 0
    }
    it("should get 4 for 123425") {
      d.work("123425") shouldBe 4
    }
    it("should get 12 for 123123") {
      d.work("123123") shouldBe 12
    }
    it("should get 0 for 1234") {
      d.work("1234") shouldBe 0
    }
    it("should get 4 for 12131415") {
      d.work("12131415") shouldBe 4
    }
  }
}
