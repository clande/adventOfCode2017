package aoc2017

import scala.collection.mutable

case class Node(name: String, var weight: Int, var children: List[Node], var parent: Node, var childrenWeight: Int)

class Day7 {
  val nodes = mutable.HashMap[String, Node]()
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day7/input").mkString
    println(doWork(x))
  }

  def processEntry(entry: String): Node = {
    val tokens = entry.replace(",", "").split(" ")

    var children = tokens.length match {
      case l if (l <= 2) => Nil
      case _ => tokens.slice(3, tokens.length).map(processEntry(_)).toList
    }

    val name = tokens(0)
    val weight = if (tokens.length == 1) 0 else tokens(1).stripPrefix("(").stripSuffix(")").toInt
    var newNode = Node(name, weight, children, null, children.)

    val node = if(nodes.contains(newNode.name)) {
      val preExistingNode = nodes(name)
      if (newNode.children != Nil) preExistingNode.children = newNode.children
      if (newNode.weight != 0) preExistingNode.weight = newNode.weight
      preExistingNode
    } else {
      nodes += (newNode.name -> newNode)
      newNode
    }

    if(node.children != Nil) node.children map(_.parent = node)

    node
  }

  def doWork(input: String): String = {
    val entries = input.split("\n")

    entries.foreach(processEntry(_))

    var currNode = nodes(nodes.keys.head)
    while (null != currNode.parent) currNode = currNode.parent
    currNode.name
  }
}
