package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day8Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day8

    it("should process the file") {
      x.getFileAndDoWork
    }

    it("should get 1") {
      val input = """b inc 5 if a > 1
                    |a inc 1 if b < 5
                    |c dec -10 if a >= 1
                    |c inc -20 if c == 10""".stripMargin
      x.doWork(input) shouldBe 1
    }
  }
}
