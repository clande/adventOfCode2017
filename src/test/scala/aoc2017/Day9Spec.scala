package aoc2017

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpecLike, Matchers}

class Day9Spec extends FunSpecLike
  with MockitoSugar
  with Matchers
  with ScalaFutures {
  describe("doWork") {
    val x = new Day9

    it("should process the file") {
      x.getFileAndDoWork
    }

    it("{} is 1,1") {
      x.doWork("{}") shouldBe (1,1,0)
    }
    it("{{{}}} is 3,5") {
      x.doWork("{{{}}}") shouldBe (3,6,0)
    }
    it("{{},{}} is 3,5") {
      x.doWork("{{},{}}") shouldBe (3,5,0)
    }
    it("{{{},{},{{}}}} is 6,16") {
      x.doWork("{{{},{},{{}}}}") shouldBe (6,16,0)
    }
    it("{<{},{},{{}}>} is 1,1") {
      x.doWork("{<{},{},{{}}>}") shouldBe (1,1,10)
    }
    it("{<a>,<a>,<a>,<a>} is 1,1") {
      x.doWork("{<a>,<a>,<a>,<a>}") shouldBe (1,1,4)
    }
    it("{{<a>},{<a>},{<a>},{<a>}} is 5,9") {
      x.doWork("{{<a>},{<a>},{<a>},{<a>}}") shouldBe (5,9,4)
    }
    it("{{<!>},{<!>},{<!>},{<a>}} is 2,3") {
      x.doWork("{{<!>},{<!>},{<!>},{<a>}}") shouldBe (2,3,13)
    }
    it("{{<ab>},{<ab>},{<ab>},{<ab>}} is 5,9") {
      x.doWork("{{<ab>},{<ab>},{<ab>},{<ab>}}") shouldBe (5,9,8)
    }
    it("{{<!!>},{<!!>},{<!!>},{<!!>}} is 5,9") {
      x.doWork("{{<!!>},{<!!>},{<!!>},{<!!>}}") shouldBe (5,9,0)
    }
    it("{{<a!>},{<a!>},{<a!>},{<ab>}} is 2,3") {
      x.doWork("{{<a!>},{<a!>},{<a!>},{<ab>}}") shouldBe (2,3,17)
    }
    it("<> is 0,0,0") {
      x.doWork("<>") shouldBe (0,0,0)
    }
    it("<random characters> is 0,0,17") {
      x.doWork("<random characters>") shouldBe (0,0,17)
    }
    it("<<<<> is 0,0,3") {
      x.doWork("<<<<>") shouldBe (0,0,3)
    }
    it("<{!>}> is 0,0,2") {
      x.doWork("<{!>}>") shouldBe (0,0,2)
    }
    it("<!!> is 0,0,0") {
      x.doWork("<!!>") shouldBe (0,0,0)
    }
    it("<!!!>> is 0,0,0") {
      x.doWork("<!!!>>") shouldBe (0,0,0)
    }
    it("<{o\"i!a,<{i<a> is 0,0,10") {
      x.doWork("<{o\"i!a,<{i<a>") shouldBe (0,0,10)
    }
  }
}
