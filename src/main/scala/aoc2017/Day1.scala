package aoc2017

import scala.util.control.TailCalls.TailRec

class Day1 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day1/input").mkString
    println(work(x))
  }

  def work(x: String): Int = {
    getTotal(x.toList, 0, x.toList.head.toString.toInt, "")
  }

  def determineValue(str: List[Char], firstVal: Int): Int = {
    val next = str.tail match {
      case Nil => firstVal
      case head :: tail => head.toString.toInt
    }
    val curr = str.head.toString.toInt

    println(s"curr: $curr, next: $next")
    if (curr == next) curr else 0
  }

  def getTotal(str: List[Char], acc: Int, firstVal: Int, track: String): Int = {
    str match{
      case Nil =>
        println(track)
        acc
      case head :: tail =>
        val value = determineValue(str, firstVal)
        println(s"val: $value, acc: $acc")
        getTotal(tail, acc + value, firstVal, s"$track$value")
    }
  }
}
