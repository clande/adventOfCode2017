package aoc2017

class Day3 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day3/input").mkString
    println(doWork(x))
  }

  def doWork(s: String): Int = {
    // get dimensions of the graph always keeping 1 at the center 1x1, 3x3, 5x5
    // get coords of one
    // get coords of the value
    // measure the difference
    0
  }
}
