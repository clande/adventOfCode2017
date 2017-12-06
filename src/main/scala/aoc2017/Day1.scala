package aoc2017

import scala.util.control.TailCalls.TailRec

class Day1 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day1/input").mkString
    println(x)
    work(x)
  }

  def work(x: String): Int = {
    getTotal(x.toList, 0, x.toList)
  }

  def determineValue(str: List[Char], originalString: List[Char]): Int = {
    val nextVal = str.tail match {
      case Nil => originalString.head.toString.toInt
      case head :: tail => head.toString.toInt
    }

    val prevVal = str.head.toString.toInt
    if (prevVal == nextVal) {
      println(s"NON-0 prev: $prevVal, next: $nextVal")
      nextVal
    } else {
      println(s"0 prev: $prevVal, next: $nextVal")
      0
    }
  }

  def getTotal(str: List[Char], acc: Int, originalString: List[Char]): Int = {
    str match{
      case Nil =>
        println(s"NIL - str: $str, acc: $acc")
        acc
      case _ =>
        val value = determineValue(str, originalString)
        println(s"NOTNIL - str: $str, acc: $acc, value: $value")
        getTotal(str.tail, acc + value, originalString)
    }
  }
}
