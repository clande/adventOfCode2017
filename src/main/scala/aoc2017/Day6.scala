package aoc2017

class Day6 {
  def getFileAndDoWork = {
    val x = scala.io.Source.fromFile("input/Day6/input").mkString
    println(doWork(x))
  }

  def reallocateAndCheckForInfiniteLoop(allocationHistory: List[String]): (List[String], Boolean) = {
    val currAllocation = allocationHistory.head.split("\\s+").map(_.toInt)
    val largestBankVal = currAllocation.max

    var largestBankIdx = currAllocation.indexOf(largestBankVal)
    currAllocation(largestBankIdx) = 0
    var currBankIdx = incrementBankIndex(largestBankIdx, currAllocation.size - 1)
    1 to (largestBankVal) foreach { _ =>
      currAllocation(currBankIdx) += 1
      currBankIdx = incrementBankIndex(currBankIdx, currAllocation.size - 1)
    }

    val newAllocationString = currAllocation.mkString(" ")
    (newAllocationString :: allocationHistory, allocationHistory.contains(newAllocationString))
  }

  def incrementBankIndex(currBankIdx: Int, maxSize: Int): Int = currBankIdx match {
    case cbi if cbi == maxSize => 0
    case _ => currBankIdx + 1
  }

  def doWork(banksString: String): (Int, Int) = {
    var banks = banksString.split("\\s+").toList
    var dupeDetected = false
    var reallocateCount = 0
    var allocationHistory = List(banks.mkString(" "))

    while(!dupeDetected){
      val (newAllocationHistory, newDupeDetected) = reallocateAndCheckForInfiniteLoop(allocationHistory)
      allocationHistory = newAllocationHistory
      dupeDetected = newDupeDetected
      reallocateCount += 1
    }
    (reallocateCount, allocationHistory.lastIndexOf(allocationHistory.head))
  }
}
