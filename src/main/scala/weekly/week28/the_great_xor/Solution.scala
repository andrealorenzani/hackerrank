package weekly.week28.the_great_xor

/**
  * Your submission will run against only preliminary test cases. Full test cases will run at the end of the day.
Given a long integer, , count the number of values of  satisfying the following conditions:

where  and  are long integers and  is the bitwise XOR operator.

You are given  queries, and each query is in the form of a long integer denoting . For each query, print the total number of values of  satisfying the conditions above on a new line.

Input Format

The first line contains an integer, , denoting the number of queries.
Each of the  subsequent lines contains a long integer describing the value of  for a query.

Constraints

Subtasks

For  of the maximum score:

Output Format

For each query, print the number of values of  satisfying the given conditions on a new line.

Sample Input 0

2
2
10
Sample Output 0

1
5
Explanation 0

We perform the following  queries:

For  the only value of  satisfying  is . This also satisfies our other condition, as and . Because we have one valid  and there are no more values to check, we print  on a new line.
For , the following values of  satisfy our conditions:






Because there are five valid values of , we print  on a new line.
  */
object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    var q = sc.nextInt()
    var a0 = 0;
    while(a0 < q){
      var x = sc.nextLong()
      println(solve(x))
      a0+=1
    }
  }

  def solve(x: Long): Long = {
    val posLeadingBit = 63 - java.lang.Long.numberOfLeadingZeros(x)
    val basicVals = for{
      pos <- 0 to posLeadingBit
      isOne = (x >> pos) & 1
      if isOne != 1
    } yield {
      1.toLong << pos
    }
    //println(s"$x >> $basicVals")
    /*val r = basicVals.size
    val res = for (
      k <- 1 to r
    ) yield {
      fact(r) / (fact(k) * fact(r-k))
    }*/
    basicVals.sum
  }

  def fact(n:Int):Int = if(n==0) 1 else n * fact(n-1)
}
