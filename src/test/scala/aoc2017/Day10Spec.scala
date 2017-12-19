package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day10Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day10

    it("should process the file") {
      x.getFileAndDoWork
    }

    it("1,2,3 should get 3efbe78a8d82f29979031a4aa0b16a9d") {
      x.doWorkPt2(256, "1,2,3") shouldBe "3efbe78a8d82f29979031a4aa0b16a9d"
    }

    it("'' should get a2582a3a0e66e6e86e3812dcb672a272") {
      x.doWorkPt2(256, "") shouldBe "a2582a3a0e66e6e86e3812dcb672a272"
    }

    it("'AoC 2017' should get 33efeb34ea91902bb2f59c9920caa6cd") {
      x.doWorkPt2(256, "AoC 2017") shouldBe "33efeb34ea91902bb2f59c9920caa6cd"
    }

    it("'1,2,4' should get 63960835bcdc130f0b66d7ff4f6a5a8e") {
      x.doWorkPt2(256, "1,2,4") shouldBe "63960835bcdc130f0b66d7ff4f6a5a8e"
    }

    it("xOrSlice"){
      val intArr = "65 ^ 27 ^ 9 ^ 1 ^ 4 ^ 3 ^ 40 ^ 50 ^ 91 ^ 7 ^ 6 ^ 0 ^ 2 ^ 5 ^ 68 ^ 22".replace(" ^ "," ").split(" ").map(_.toInt)
      x.xorSlice(intArr) shouldBe 64
    }
  }
}
