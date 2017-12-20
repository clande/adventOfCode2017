package aoc2017

class Day13Pt1 {
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

class Day13 {
  case class Layer(range: Int, depth: Int) {
    val period = if(range > 0) range * 2 - 2 else 0
    val primaryTimes = if(range > 0) (0 to 100000000 by period) else (-1 to 0)
    def isInTopAtTime(picoSecond: Int) = if(range > 0) {
      val b = primaryTimes.contains(picoSecond)
//      println(s"(${this.depth}, ${this.range}) isInTopAtTime($picoSecond): $b")
      b
    } else {
//      println(s"(${this.depth}, ${this.range}) isInTopAtTime($picoSecond): false")
      false

    }
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

  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day13").mkString
    println(doWork(x))
  }

  def canPassFreely(startTime: Int, layers: Seq[Layer]): Boolean = {
    var currTime = startTime
    var sum = 0
    layers.foreach{ l =>
      sum += (if (l.isInTopAtTime(currTime)) 1 else 0)
      currTime += 1
    }

    sum == 0
  }

  def doWork(input: String): Int = {
    var delay = 0
    val lines = input.split("\n")
    val layers: Seq[Layer] = buildLayers(lines)

    while(!canPassFreely(delay, layers)){
//      println(s"delay $delay bad\n")
      delay += 1
    }

    delay
  }
}
