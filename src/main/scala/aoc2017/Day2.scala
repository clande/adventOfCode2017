package aoc2017

class Day2 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day2/input").mkString
    println(doWork(x))
  }

  def doWork(s: String): Int = {
    val lines = s.split(System.getProperty("line.separator")).toList

    val linesSums = lines map { line =>
      val lineVals = line.split("\\s+").toList.map(_.toInt)
      lineVals.max - lineVals.min
    }

    linesSums.sum
  }
}
