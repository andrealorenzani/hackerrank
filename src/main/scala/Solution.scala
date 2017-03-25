object Solution {

  def main(args: Array[String]) = {
    /*val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var c = sc.nextInt();
    var m = sc.nextInt();
    var p = new Array[Int](n);
    for(p_i <- 0 to n-1) {
      p(p_i) = sc.nextInt();
    }*/
    val sc = new java.util.Scanner (System.in);
    var m = sc.nextInt();

    print(solve(m))
  }

  def solve(m: Int) = {
    val range = 11 to (math.pow(10, m)-1).toInt
    val finalSum = range.filter(filterUseless).filter(verifyProperty).sum
    finalSum % 100000
  }

  def filterUseless(value: Int): Boolean = {
    value.toString.charAt(0).asDigit <= (value % 10)
  }


    def tmp(args: Array[String]) {
      val sc = new java.util.Scanner (System.in);
      var n = sc.nextInt();
      var a = Array.ofDim[Int](n,n);
      for(a_i <- 0 to n-1) {
        for(a_j <- 0 to n-1){
          a(a_i)(a_j) = sc.nextInt();
        }
      }
      val straight = for(d <- 0 until n) yield a(d)(d)
      val reverse = for(d <- 0 until n) yield a(n-d-1)(d)
      println(math.abs(straight.sum - reverse.sum))
    }


  def verifyProperty(value: Int): Boolean = {
    val lastDig = value % 10
    val rest = (value / 10)
    val rightRot = s"$lastDig$rest".toInt
    (rightRot % value) == 0
  }

  // {  }
}
