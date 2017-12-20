package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day13Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day13

    it("should process the file") {
      println(x.getFileAndDoWork)
    }

    it("should get 24") {
      val input = """0: 3
                    |1: 2
                    |4: 4
                    |6: 4""".stripMargin
      x.doWork(input) shouldBe 10
    }
  }
}
