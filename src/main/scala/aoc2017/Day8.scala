package aoc2017

import scala.collection.mutable

class Day8 {
  val registers = mutable.Map[String, Int]()

  def evalCondition(register: String, comparator: String, value: Int): Boolean = {
    val currRegValue = getRegValue(register)
    println(s"$register = $currRegValue")
    comparator match {
      case ">" => currRegValue > value
      case ">=" => currRegValue >= value
      case "<" => currRegValue < value
      case "<=" => currRegValue <= value
      case "==" => currRegValue == value
      case "!=" => currRegValue != value
    }
  }

  private def getRegValue(register: String): Int = {
    if (!registers.contains(register)) registers(register) = 0

    registers(register)
  }

  def performCommand(register: String, operator: String, value: Int): Unit = {
    val currRegValue = getRegValue(register)
    registers(register) = operator match {
      case inc => currRegValue + value
      case dec => currRegValue - value
    }

    println(s"ACTION: $register($currRegValue) $operator'd to ${registers(register)}")
  }

  def processCommand(command: String): Unit = {
    val tokens = command.split(" ")
    if (tokens.length != 7) throw new RuntimeException(s"Command '$command' is invalid")

    if (evalCondition(tokens(4), tokens(5), tokens(6).toInt)) performCommand(tokens(0), tokens(1), tokens(2).toInt)
  }

  def doWork(input: String): Int = {
    val commands = input.split("\n").toList

//    println(commands.sortBy(_.toString).mkString("\n"))

    commands map { c =>
      println(s"\n$c")
      processCommand(c)
    }

    registers.maxBy(_._2)._2
  }

  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day8/input").mkString
    println(doWork(x))
  }
}
