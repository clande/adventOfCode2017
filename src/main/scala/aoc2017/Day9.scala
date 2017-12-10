package aoc2017

class Day9 {
  case class Group(score: Int, var children: List[Group], parent: Group) {
    def count: Int = {
      children match {
        case Nil => 1
        case c => c.map(_.count).sum + 1
      }
    }

    def calcScore: Int = {
      children match {
        case Nil =>
          score
        case children =>
          children.map(_.calcScore).sum + score
      }
    }
  }

  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day9/input").mkString
    println(doWork(x))
  }

  def doWork(stream: String): (Int, Int, Int) = {
    var currGroup: Group = null
    var garbageMode = false
    var cancelMode = false
    var garbageCount = 0

    stream.toList.foreach{c =>
      (c, garbageMode, cancelMode) match {
        case (_, _, true) =>
          cancelMode = false
        case ('!', _, false) =>
          cancelMode = true
        case ('>', _, false) =>
          garbageMode = false
        case (_, true, false) =>
          garbageCount += 1
        case ('<', _, false) =>
          garbageMode = true
        case (',', _, false) =>
          Unit
        case ('{', false, false) =>
          if (null == currGroup) currGroup = Group(1, Nil, null)
          else {
            val newGroup = Group(currGroup.score + 1, Nil, currGroup)
            currGroup.children = newGroup :: currGroup.children
            currGroup = newGroup
          }
        case ('}', false, false) =>
          if (null != currGroup.parent) currGroup = currGroup.parent
        case (c, g, i) => throw new RuntimeException(s"char: $c, garbageMode: $g, ignoreNext: $i")
      }
    }

    if (null != currGroup) (currGroup.count, currGroup.calcScore, garbageCount)
    else (0,0,garbageCount)
  }
}
