package aoc2017

class Day1 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day1/input").mkString
    println(work(x))
  }

  def work(x: String): Int = {
    getTotal(x.toList, 0, x.toList.head.toString.toInt)
  }

  def determineValue(str: List[Char], firstVal: Int): Int = {
    val next = str.tail match {
      case Nil => firstVal
      case head :: tail => head.toString.toInt
    }
    val curr = str.head.toString.toInt

    if (curr == next) curr else 0
  }

  def getTotal(str: List[Char], acc: Int, firstVal: Int): Int = {
    str match{
      case Nil =>
        acc
      case head :: tail =>
        val value = determineValue(str, firstVal)
        getTotal(tail, acc + value, firstVal)
    }
  }
}

class Day1Part2 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day1/input").mkString
    println(work(x))
  }

  def work(x: String): Int = {
    val captchaArray = x.toList.map(_.toString.toInt).toArray
    var total = 0
    for (i <- 0 to captchaArray.length - 1) {
      total += determineValue(captchaArray, i)
    }

    total
  }

  def determineValue(captchaArray: Array[Int], currIdx: Int): Int = {
    val offset = (captchaArray.length / 2)
    val next = if ((captchaArray.length - 1) < (currIdx + offset)) {
      val idx = currIdx + offset - captchaArray.length
      captchaArray(idx)
    } else captchaArray(currIdx + offset)
    val curr = captchaArray(currIdx)

    if (curr == next) curr else 0
  }
}
