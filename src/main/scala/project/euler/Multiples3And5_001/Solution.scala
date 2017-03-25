package project.euler.Multiples3And5_001

object Solution {
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner (System.in)
    var T = sc.nextInt()

    val tests = for(num <- 1 to T) yield sc.nextInt()
    val (cache3, cache5) = getCache(tests.max)
    val (sum30, sum50) = (cache3.sum, cache5.sum)

    tests.foreach{ case valmax =>
        val mul3 = sum30 * valmax/30 + valmax/30 * 300 + cache3.filter(_ < valmax%30).sum
        val mul5 = sum50 * valmax/50 + valmax/50 * 500 + cache5.filter(_ < valmax%50).sum
        println(mul3+mul5)
    }
  }

  def getCache(below: Int) = {
    val mult3 = for(base <- 1 to 10) yield base * 3
    val mult5 = for(base <- 1 to 10) yield base * 5
    (mult3.filter(_ % 5 != 0), mult5)
  }

}
