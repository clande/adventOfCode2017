package aoc2017

class DayX {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/DayX/input").mkString.toInt
    println(doWork(x))
  }

  def doWork(target: Int): Int = {
    0
  }
}
