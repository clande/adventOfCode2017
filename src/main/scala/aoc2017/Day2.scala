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

class Day2Part2 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day2/input").mkString
    println(doWork(x))
  }

  def getResultOfDivisibles(lineVals: Array[Int]): Int = {
    val sortedLineVals = lineVals.sorted
    var leftIdx = 0
    var rightIdx = sortedLineVals.length - 1

    while(sortedLineVals(rightIdx) % sortedLineVals(leftIdx) != 0){
      leftIdx += 1
      if(leftIdx == rightIdx) {
        leftIdx = 0
        rightIdx -= 1
        if(leftIdx == rightIdx) throw new RuntimeException("DOH!")
      }
    }

    sortedLineVals(rightIdx) / sortedLineVals(leftIdx)
  }

  def doWork(s: String): Int = {
    val lines = s.split(System.getProperty("line.separator")).toList

    val linesSums = lines map { line =>
      val lineVals = line.split("\\s+").map(_.toInt)
      getResultOfDivisibles(lineVals)
    }

    linesSums.sum
  }
}
