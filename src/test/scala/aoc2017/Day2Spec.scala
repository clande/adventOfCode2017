package aoc2017

import org.scalatest.{FunSpecLike, Matchers}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar


class Day2Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day2

    it("should process the file") {
      x.getFileAndDoWork
    }

    it("should get 18") {
      val s =
        """5 1 9 5
          |7 5 3
          |2 4 6 8""".stripMargin

      x.doWork(s) shouldBe 18
    }

    it("should get 1494") {
      val s =
        """200 1  9 5
          |7  500 3
          |2 4 6  800""".stripMargin

      x.doWork(s) shouldBe (199 + 497 + 798)
    }
  }
  describe("doWorkPart2") {
    val x = new Day2Part2

    it("should process the file") {
      x.getFileAndDoWork
    }

    it("should get 9") {
      val s =
        """5 9 2 8
          |9 4 7 3
          |3 8 6 5""".stripMargin

      x.doWork(s) shouldBe 9
    }
  }
}
