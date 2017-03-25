package interview.skyscanner.jan_2017

import scala.io.StdIn

/**
  *  def OutputMostPopularDestination(count: Int) = {
    var dest = new Array[String](count)
    for(d <- 0 until count) {
      dest(d) = scala.io.StdIn.readLine()
    }
    val results = dest.groupBy(x => x)
                      .map { case (dst, occ) => dst -> occ.length }
                      .toSeq.sortBy(x => x._2)
    print(results.last._1)
  }
  */
class Solution {

  def OutputMostPopularDestination(count: Int) = {
    var dest = new Array[String](count)
    for(d <- 0 until count) {
      dest(d) = scala.io.StdIn.readLine()
    }
    val results = dest.groupBy(x => x)
      .map { case (dst, occ) => dst -> occ.length }
      .toSeq.sortBy(x => x._2)
    print(results.last._1)
  }

  def main(args: Array[String]) {
    var _count:Int = Console.readInt


    OutputMostPopularDestination(_count)

  }
}
