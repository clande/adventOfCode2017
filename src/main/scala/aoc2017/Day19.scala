package aoc2017

class Day19 {
  def getFileAndDoWork(filepath: String) = {
    val x = scala.io.Source.fromFile(filepath).mkString
    doWork(x)
  }

  def findNextMapPosition(charMap: Array[Array[Char]], x: Int, y: Int, direction: String) = {
    var (newX, newY) = (x, y)
    var newDirection = direction
    (charMap(x)(y), direction) match {
      case ('|', "down") =>  newY += 1
      case ('|', "up") => newY -= 1
      case ('+', "down") => (newX, newY, newDirection) = processIntersection(newX, newY, newDirection, charMap)
      case('+', "up" ) => 1
      case('+', "left") => 1
      case ('+', "right") => 1
      case(c, "up") if(c.isLetter) => newY -= 1
      case(c, "down") if(c.isLetter) => newY += 1
      case(c, "right") if(c.isLetter) => newX += 1
      case(c, "left") if(c.isLetter) => newX -= 1
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
    (0 to mapLength - 1).foreach (i => if (charMap(0)(i) != " ") y = i)

    while((x,y) != (-1,-1)){
      (x,y, direction) = findNextMapPosition(charMap, x, y, direction)
      if (charMap(x)(y).isLetter) pathString += charMap(x)(y)
    }

    pathString
  }
}
