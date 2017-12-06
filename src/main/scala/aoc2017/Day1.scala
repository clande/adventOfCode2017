package aoc2017

import scala.util.control.TailCalls.TailRec

class Day1 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day1/input").mkString
//    println(work(x))
    work(x)
  }

  def work(x: String): Int = {
    getTotal(x.toList, 0, -1,  x.toList.head.toString.toInt, "")
  }

  def determineValue(prevVal: Int, str: List[Char], firstVal: Int): Int = {
    val (nextVal, isLastChar) = str.tail match {
      case Nil => (firstVal, true)
      case head :: tail => (head.toString.toInt, false)
    }
    val currentVal = str.head.toString.toInt

    println(s"prev: $prevVal, curr: $currentVal, next: $nextVal, isLasr: $isLastChar")
    (prevVal, currentVal, nextVal, isLastChar) match {
      case (p, c, n, true) if((p == c) && (c == n)) => c + c
      case (_, c, n, true) if(c == n) => c
      case (p, c, _, _) if(p == c) => c
      case (_,_,_,_) => 0
    }
  }

  def getTotal(str: List[Char], acc: Int, prev: Int, firstVal: Int, track: String): Int = {
    str match{
      case Nil =>
        println(track)
        acc
      case head :: tail =>
        val value = determineValue(prev, str, firstVal)
        println(s"val: $value, acc: $acc")
        getTotal(tail, acc + value, head.toString.toInt, firstVal, s"$track$value")
    }
  }
}
