package exercises.random.algorithms

import scala.collection.immutable.HashMap

object Solution1 {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.next();
    val uppercases = for(letter <- 'A' to 'Z') yield letter

    println(s.split(uppercases.to[Array]).size)
  }
}


object Solution {

  def verifyProp(str: String): Boolean = {
    if(str.length < 2) false
    val (a, b) = (str.charAt(0), str.charAt(1))
    str.scan(scala.collection.immutable.HashMap[Char, String])()
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var len = sc.nextInt();
    var s = sc.next();
  }
}

object Solution2 {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    var max: Long = sc.nextLong()
    var min: Long = max
    var minSum: Long = 0
    var maxSum: Long = 0
    val nums = for(i <- 1 to 4) yield {
      val current = sc.nextLong()
      if(current < min) {
        maxSum += min
        min = current
      }
      else maxSum += current
      if(current > max) {
        minSum += max
        max = current
      }
      else minSum += current
    }
    println(s"$minSum $maxSum")
  }
}

object Solution3 {

    def main(args: Array[String]) {
      val sc = new java.util.Scanner (System.in);
      val N = sc.nextInt();
      val nqueries = sc.nextInt()

      val lst= for(indx <- 0 to N - 1) yield List[Int]()
      var lastAns = 0
      var seqList = lst.toArray
      for(arr_i <- 0 until nqueries){
        val query = sc.nextInt()
        val x = sc.nextInt()
        val y = sc.nextInt()

        query match {
          case 1 =>
            val seq = (x ^ lastAns) % N
            seqList(seq) = seqList(seq) :+ y
          case 2 =>
            val seq = (x ^ lastAns) % N
            lastAns = seqList(seq)(y % seqList(seq).size)
            println(lastAns)
        }
      }
    }

}

object Solution4 {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    val d = sc.nextInt()

    val lst = (for(indx <- 1 to n) yield { sc.nextInt() }).toList
    val res = lst.slice(d, lst.size) ++ lst.slice(0, d)
    print(res.mkString(" "))
  }
}


object Solution5 {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val strings = (for(idx <-1 to n) yield sc.nextLine()).toList
    val d = sc.nextInt()
    for(idx <- 1 to d) {
      val query = sc.nextLine()
      println(strings.count(x => x.equals(query)))
    }
  }
}

// {  }