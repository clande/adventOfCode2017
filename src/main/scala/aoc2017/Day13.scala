package aoc2017

class Day13 {
//  case class ScannerPosition(leaving: Int, arriving: Int)
  case class Layer(range: Int, depth: Int) {
    var currentPosition = 1
    var goingDown = true

    def moveScanner = {
      if (range != 0) {
        (goingDown, currentPosition) match {
          case (true, p) if (p == range) =>
            currentPosition -= 1
            goingDown = false
          case (false, p) if (p == 1) =>
            currentPosition += 1
            goingDown = true
          case (true, p) => currentPosition += 1
          case (false, p) => currentPosition -= 1
        }
      }
    }
//    def getScannerPosition(timeP: Int): ScannerPosition = {
//      if(range != 0) {
//      val wholePasses = (timeP + 1) / range
//      val partialPass = (timeP + 1) % range
//      val goingDown = wholePasses == 0 || (wholePasses % 2 == 0)
//      if(goingDown) {}
//      } else 0
//    }
  }

  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day13").mkString
    println(doWork(x))
  }

  def buildLayers(lines: Array[String]): Seq[Layer] = {
    var layers: Seq[Layer] = Nil
    var currDepth: Int = 0

    lines.map(_.split(": ")).foreach{ s =>
      val (depth, range): (Int, Int) = (s(0).toInt, s(1).toInt)

      while(depth > currDepth) {
        layers = layers :+ Layer(0, 0)
        currDepth += 1
      }
      layers = layers :+ Layer(range, depth)
      currDepth += 1
    }

    layers
  }

  def doWork(input: String): Int = {
    val lines = input.split("\n")
    val layers: Seq[Layer] = buildLayers(lines)

    var layersLeft = layers
    var severity = 0
    var packetDepth = -1
    while(!layersLeft.isEmpty){
      packetDepth += 1
      val currLayer = layersLeft.head
      layersLeft = layersLeft.tail
      if(currLayer.currentPosition == 1) severity += currLayer.depth * currLayer.range
      layers.foreach(_.moveScanner)
    }

    severity
  }
}
