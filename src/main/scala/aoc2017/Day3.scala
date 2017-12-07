//package aoc2017
//
//class Day3 {
//  def getFileAndDoWork = {
//    val x = scala.io.Source.fromFile("input/Day3/input").mkString.toInt
//    println(doWork(x))
//  }
//
//  def isCorrectSize(size: Int, num: Int): Boolean = Math.pow(size, 2) > num
//
//  def doWork(target: Int): Int = {
//    // get dimensions of the graph always keeping 1 at the center 1x1, 3x3, 5x5
//    val gridSize = Iterator.from(3, 2).find(Math.pow(_, 2) >= target).get
//    val maxNum = Math.pow(gridSize, 2).toInt
//
//    val center = (gridSize / 2) + (gridSize % 2)
//
//    // get coords of the value
//    var x = maxNum //TODO: use tail recursion?
//    var y = maxNum
//    for (i <- (maxNum to target).reverse) {
//      (x, y) match {
//        case (a, b) if ((a == maxNum) && (b == maxNum)) => x = a - 1
//        case (a, b) if ((a >= maxNum - gridSize) && (b == maxNum)) => x = a - 1
//        case (a, b) if ((a == maxNum) && (b == maxNum - gridSize)) => y = b - 1
//      }
//    }
////    val (x, y) = walkBackOne(gridSize, gridSize)
//
//    // measure the difference
//  }
//}
