package aoc2017

class Day20 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/DayX").mkString.toInt
    println(doWork(x))
  }

  def doWork(target: Int): Int = {
    0
  }
}
