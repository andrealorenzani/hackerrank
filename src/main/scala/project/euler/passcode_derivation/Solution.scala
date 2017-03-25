package project.euler.passcode_derivation

object Solution {
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner (System.in)
    var m = sc.nextInt()
    val tries = for(indx <- 1 to m) yield sc.next
    
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
