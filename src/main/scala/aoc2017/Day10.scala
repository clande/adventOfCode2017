package aoc2017

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Day10 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day10/input").mkString
    println(doWorkPt1(256, x))
  }

  def getSlice(buf: Array[Int], length: Int, currPos: Int): mutable.ArrayBuffer[Int] = {
    val slice = new mutable.ArrayBuffer[Int](length)
    (0 to length - 1).foreach { sliceIdx =>
      slice += buf(getCircularIndex(currPos + sliceIdx, buf.length - 1))
    }

    slice
  }

  private def getCircularIndex(requestedIdx: Int, maxIdx: Int) = {
    if (requestedIdx > maxIdx) {
      val mod = (requestedIdx % maxIdx)
      if (mod == 0) maxIdx else mod - 1
    } else {
      requestedIdx
    }
  }

  def update(buf: Array[Int], currPos: Int, slice: ArrayBuffer[Int]): Unit = {
    (0 to slice.length - 1).foreach{ sliceIdx =>
      buf(getCircularIndex(currPos + sliceIdx, buf.length - 1)) = slice(sliceIdx)
    }
  }

  def xorSlice(nums: Array[Int]): Int = {
    var result = 0
    nums.foreach(i => result ^= i)
    result
  }

  def doWorkPt1(listSize: Int, lengths: String): Int = {
    val sparseHash = (0 to listSize - 1).toArray
    var skipSize = 0
    var currPos = 0

    lengths.split(",").map(_.toInt).foreach { length =>
      var slice = getSlice(sparseHash, length, currPos)
      slice = slice.reverse
      update(sparseHash, currPos, slice)
      currPos = getCircularIndex(currPos + length + skipSize, sparseHash.length - 1)
      skipSize += 1
    }

    sparseHash(0) * sparseHash(1)
  }

  def doWorkPt2(listSize: Int, lengths: String): String = {
    val sparseHash = (0 to listSize - 1).toArray
    var skipSize = 0
    var currPos = 0

    val asciiLengths = lengths.toCharArray.map(_.toInt)
    val saltedLengths = asciiLengths.toList ::: "17,31,73,47,23".split(",").map(_.toInt).toList

    (1 to 64).foreach { _ =>
      saltedLengths.foreach { length =>
        var slice = getSlice(sparseHash, length, currPos)
        slice = slice.reverse
        update(sparseHash, currPos, slice)
        currPos = getCircularIndex(currPos + length + skipSize, sparseHash.length - 1)
        skipSize += 1
      }
    }

    val max = sparseHash.max

    val denseHash = new mutable.ArrayBuffer[Int](16)
    currPos = 0
    (1 to 16).foreach { denseHashIdx =>
      var xorResult = 0
      (1 to 16).foreach { _ =>
        xorResult ^= sparseHash(currPos)
        currPos += 1
      }
      val sparseSlice = sparseHash.toList.slice(currPos - 16, currPos).toArray
      val xor = xorSlice(sparseSlice)

      denseHash += xorResult
    }

    val hexedHash = denseHash.map(i => f"$i%02X").mkString
    hexedHash
  }
}