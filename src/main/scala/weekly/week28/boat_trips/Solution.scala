package weekly.week28.boat_trips

/***
  * our submission will run against only preliminary test cases. Full test cases will run at the end of the day.
Alice owns a company that transports tour groups between two islands. She has  trips booked, and each trip has  passengers. Alice has  boats for transporting people, and each boat's maximum capacity is  passengers.

Given the number of passengers going on each trip, determine whether or not Alice can perform all  trips using no more than  boats per individual trip. If this is possible, print Yes; otherwise, print No.

Input Format

The first line contains three space-separated integers describing the respective values of  (number of trips), (boat capacity), and  (total number of boats).
The second line contains  space-separated integers describing the values of .

Constraints

Output Format

Print Yes if Alice can perform all  booked trips using no more than  boats per trip; otherwise, print No.

Sample Input 0

5 2 2
1 2 1 4 3
Sample Output 0

Yes
Explanation 0

Alice has  boats and a maximum capacity of  passengers per boat. This means she can transport at most  passengers at a time.

There are  tour groups, and the largest tour group contains  passengers. Because Alice will be able to transport each group using  boats per group, we print Yes.

Sample Input 1

5 1 2
1 2 1 4 1
Sample Output 1

No
Explanation 1

Alice has  boats and a maximum capacity of  passenger per boat. This means she can transport at most  passengers at a time.

There are  tour groups, and the largest tour group contains  passengers. Because Alice does not have enough boats to transport a group of four passengers, we print No.
  */


object Solution {

  def main(args: Array[String]) = {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var c = sc.nextInt();
    var m = sc.nextInt();
    var p = new Array[Int](n);
    for(p_i <- 0 to n-1) {
      p(p_i) = sc.nextInt();
    }

    print(solve(n, c, m, p))
  }

  def solve(n: Int, c: Int, m: Int, paxes: Array[Int]) = {
    val maxPaxes = c*m
    maxPaxes match {
      case x if x >= paxes.max => "Yes"
      case _ => "No"
    }
  }
}
