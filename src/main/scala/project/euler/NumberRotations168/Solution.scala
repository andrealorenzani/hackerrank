package project.euler.NumberRotations168

/**
  * Created by andrea on 16/01/17.
  */
object Solution {
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner (System.in);
    var m = sc.nextInt();
    val max = math.pow(10, m)

    for(num <- 10.toLong to max.toLong) {
      propVerif(num)
    }
  }

  def propVerif(n: Double): Boolean ={
    val tail = (n%10).toString.charAt(0).asDigit
    val right: Double = s"$tail${n/10}".toDouble
    if(right%n==0.toDouble){
      print(s"$n ")
    }
    right%n==0
  }

}
