package interview.skyscanner.jan_2017

/**
  * Created by andrea on 10/01/17.
  */
class Solution2 {

  def OutputCommonManager(count: Int) = {
    val firstEmpl = scala.io.StdIn.readLine()
    val scdEmpl = scala.io.StdIn.readLine()
    val listDependIter = Iterator.continually(scala.io.StdIn.readLine()).takeWhile(_ != null)
    val depend = listDependIter.toList.map{ singleDep =>
      val dep = singleDep.split(" ")
      dep(0) -> dep(1)
    }

    depend.toMap.

  }


  def main(args: Array[String]) {
    var _count:Int = Console.readInt


    OutputCommonManager(_count)

  }
}

}
