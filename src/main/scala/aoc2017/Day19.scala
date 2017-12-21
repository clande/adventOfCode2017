package aoc2017

class Day19 {
  def getFileAndDoWork(filepath: String) = {
    val x = scala.io.Source.fromFile(filepath).mkString
    doWork(x)
  }

  def processIntersection(x: Int, y: Int, direction: String, charMap: Array[Array[Char]]): (Int, Int, String) = {
    var (newX, newY) = (x, y)
    var newDirection: String = null
    val directionsToCheck = Seq("down", "up", "left", "right").filter(_.equals(direction))

    directionsToCheck.foreach{ d =>
      val (x2, y2) = d match {
        case "down" => (x, y + 1)
        case "up" => (x, y - 1)
        case "left" => (x - 1, y)
        case "right" => (x + 1, y)
      }
      if(charMap(x2)(y2) != " ") {
        newDirection = d
        newX = x2
        newY = y2
      }
    }

    (newX, newY, newDirection)
  }

  def findNextMapPosition(charMap: Array[Array[Char]], x: Int, y: Int, direction: String) = {
    var (newX, newY) = (x, y)
    var newDirection = direction
    (charMap(x)(y), direction) match {
      case ('|', "down") =>  newY += 1
      case ('|', "up") => newY -= 1
      case ('-', "left") => newX -= 1
      case ('-', "right") => newX += 1
      case ('+', _) => {
        val (x2, y2, d) = processIntersection(newX, newY, newDirection, charMap)
        newX = x2
        newY = y2
        newDirection = d
      }
      case(c, "up") if(c.isLetter || c.isWhitespace) => newY -= 1
      case(c, "down") if(c.isLetter || c.isWhitespace) => newY += 1
      case(c, "right") if(c.isLetter || c.isWhitespace) => newX += 1
      case(c, "left") if(c.isLetter || c.isWhitespace) => newX -= 1
      case(c, d) => throw new RuntimeException(s"Bad current position x: $x, y: $y, char: $c, dir: $direction")
    }

    (newX, newY, newDirection)
  }

  def doWork(input: String): String = {
    val lines = input.split("\n")
    val charMap = lines.map(_.toCharArray)
    val mapLength = charMap(0).length
    var (x, y) = (0,0)
    var direction: String = "down"
    var pathString = ""

    //find entry point
    (0 to mapLength - 1).foreach (i => if (!charMap(0)(i).isWhitespace) y = i)

    while((x,y) != (-1,-1)){
      val (x2, y2, d) = findNextMapPosition(charMap, x, y, direction)
      x = x2
      y = y2
      direction = d
      if (charMap(x)(y).isLetter) pathString += charMap(x)(y)
    }

    pathString
  }
}
