package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day7Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day7

//    it("should process the file") {
//      x.getFileAndDoWork
//    }

    it("should get thnk") {
      val input = """pbga (66)
                    |xhth (57)
                    |ebii (61)
                    |havc (66)
                    |ktlj (57)
                    |fwft (72) -> ktlj, cntj, xhth
                    |qoyq (66)
                    |padx (45) -> pbga, havc, qoyq
                    |tknk (41) -> ugml, padx, fwft
                    |jptl (61)
                    |ugml (68) -> gyxo, ebii, jptl
                    |gyxo (61)
                    |cntj (57)""".stripMargin
      x.doWork(input) shouldBe "tnhk"
    }
  }
}
