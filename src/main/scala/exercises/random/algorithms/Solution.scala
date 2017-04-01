package exercises.random.algorithms

import scala.collection.immutable.{HashMap, TreeMap, TreeSet}

object Solution1 {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.next();
    val uppercases = for(letter <- 'A' to 'Z') yield letter

    println(s.split(uppercases.to[Array]).size)
  }
}

object Solution99 {

  object Solution {

    def main(args: Array[String]) {
      /*val sc = new java.util.Scanner (System.in)
      val (n, k) = (sc.nextInt(), sc.nextInt())
      val rawtree = for(i <- 1 until n) yield (sc.nextInt(), sc.nextInt())
      val lefttree = rawtree.groupBy(x => x._1).map{ case (x, y) => x -> y.map(_._2).toList}
      val tree = rawtree.groupBy(x => x._2).map{ case (x, y) => x -> (lefttree(x) ++ y.map(_._2).toList).toSet}

      def sviluppo(base: Double): Double = {
        (2 to 10).map(x => x).foldLeft(1d)((res, v) => res + (exp(base, v)/fact(v)))
      }
      def exp(v: Double, n: Int) = (2 to n).map(x=>x).foldLeft(v)((x, y)=>x*v)
      def fact(n: Int) = (2 to n).map(x=>x).product

      for(x <- tree.keySet){
        getAllReachableNodes(x, k, tree).size
      }*/
    }

    /*def getAllReachableNodes(node: Int, deep: Int, tree: Map[Int, Set[Int]]): Set[Int] ={

    }*/
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var time = sc.next();
    val newTime = (time.substring(8), time.substring(0,8)) match {
      case ("AM", time) =>
        (time.substring(0, 2).toInt%12).toString+":"+time.substring(2)
      case ("PM", tbc) =>
        ((time.substring(0, 2).toInt+12)%24).toString+":"+time.substring(2)
    }
  }
}

/*object Solution {

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
}*/

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

object Solution6 {

  case class RangedVal(from: Int, to: Int, value: Long)

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val N = sc.nextInt()
    val M = sc.nextInt()

    val values = (for(indx <- 1 to M) yield {
      val rv = RangedVal(sc.nextInt(), sc.nextInt(), sc.nextInt())
      List((rv.from, rv.value), (rv.to+1, rv.value))
    }).flatten.groupBy(_._1).map(x => (x._1, x._2.map(_._2).sum))

    val tm = TreeMap[Int, Long](values.toArray:_*)

    val result = tm.foldLeft((0l, 0l)){ (res, value)=>
      if(value._2 > 0l) {
        val newAcc = res._2 + value._2
        val newMax = Math.max(res._1, newAcc)
        (newMax, newAcc)
      } else {
        val newAcc = res._2 + value._2
        (res._1, newAcc)
      }
    }

    print(result._1)
    /*val sortedAdd = lst.toList.sortWith{ case (RangedVal(x1, x2, _), RangedVal(y1, y2, _)) =>
      if(x1 < y1) true
      else if(y1 < x1) false
      else if(x2 <= y2) true else false
    }

    val allRanges = fragment(0l, sortedAdd)
    */
  }

  /*def fragment(max: Long, adds: List[RangedVal]): Long = {
    adds match {
      case List() => max
      case List(x) => Math.max(max, x.value)
      case _ => {
        val startRV = adds.head
        val (stFrom, stTo) = (startRV.from, startRV.to)
        val allInterested = adds.takeWhile( x => x.from <= startRV.to)
        val notInterested = adds.dropWhile( x => x.from <= startRV.to)
        if(allInterested.map(_.value).sum < max) {
          fragment(max, allInterested.tail.filter(x => x.to > stTo)
                                     .map(x => RangedVal(stTo, x.to, x.value)) ++ notInterested)
        }
        else {
          val (from, notFrom) = allInterested.partition(x => x.from == stFrom)
          val minFrom = if (notFrom.isEmpty) stTo else notFrom.map(_.from).min - 1
          val to = Math.min(from.map(_.to).min, minFrom)
          val nextFrag = RangedVal(startRV.from, to, from.map(_.value).sum)
          val newAdds = from.filterNot(x => x.to == to)
            .map(x => RangedVal(to + 1, x.to, x.value)) ++ notFrom ++ notInterested
          //println(s"New fragment (${nextFrag.from}, ${nextFrag.to}) with ${nextFrag.value}")
          fragment(Math.max(max, nextFrag.value), newAdds)
        }
      }
    }
  }

  def fragment4(max: Long, adds: List[RangedVal]): Long = {
    adds match {
      case List() => max
      case List(x) => Math.max(max, x.value)
      case _ => {
        val startRV = adds.head
        val (stFrom, stTo) = (startRV.from, startRV.to)
        val allInterested = adds.takeWhile( x => x.from <= startRV.to)
        val notInterested = adds.dropWhile( x => x.from <= startRV.to)
        if(allInterested.map(_.value).sum < max) {
          fragment(max, allInterested.tail.filter(x => x.to > stTo)
            .map(x => RangedVal(stTo, x.to, x.value)) ++ notInterested)
        }
        else {
          val (from, notFrom) = allInterested.partition(x => x.from == stFrom)
          val minFrom = if (notFrom.isEmpty) stTo else notFrom.map(_.from).min - 1
          val to = Math.min(from.map(_.to).min, minFrom)
          val nextFrag = RangedVal(startRV.from, to, from.map(_.value).sum)
          val newAdds = from.filterNot(x => x.to == to)
            .map(x => RangedVal(to + 1, x.to, x.value)) ++ notFrom ++ notInterested
          //println(s"New fragment (${nextFrag.from}, ${nextFrag.to}) with ${nextFrag.value}")
          fragment(Math.max(max, nextFrag.value), newAdds)
        }
      }
    }
  }

  def fragment3(adds: List[RangedVal]): List[Long] = {
    adds match {
      case List() => List()
      case List(x) => List(x.value)
      case _ => {
        val startRV = adds.head
        val (stFrom, stTo) = (startRV.from, startRV.to)
        val allInterested = adds.takeWhile( x => x.from <= startRV.to)
        val notInterested = adds.dropWhile( x => x.from <= startRV.to)
        val (from, notFrom)= allInterested.partition(x => x.from == stFrom)
        val minFrom = if(notFrom.isEmpty) stTo else notFrom.map(_.from).min-1
        val to = Math.min(from.map(_.to).min, minFrom)
        val nextFrag = RangedVal(startRV.from, to, from.map(_.value).sum)
        val newAdds = from.filterNot(x => x.to == to)
          .map(x => RangedVal(to+1, x.to, x.value)) ++ notFrom ++ notInterested
        //println(s"New fragment (${nextFrag.from}, ${nextFrag.to}) with ${nextFrag.value}")
        List(nextFrag.value) ++ fragment(newAdds)
      }
    }
  }

  def fragment2(adds: List[RangedVal]): List[Long] = {
    adds match {
      case List() => List()
      case List(x) => List(x.value)
      case _ => {
        val startRV = adds.head
        val (allInterested, notInterested) = adds.partition( x => x.from <= startRV.to)
        val (from, notFrom)= allInterested.partition(x => x.from == startRV.from)
        val maxTo = from.map(_.to).min
        val minFrom = if(notFrom.isEmpty) maxTo else notFrom.map(_.from).min-1
        val to = Math.min(maxTo, minFrom)
        val nextFrag = RangedVal(startRV.from, to, from.map(_.value).sum)
        val newAdds = allInterested.filterNot(x => x.to == to)
          .map(x => RangedVal(to, x.to, x.value)) ++ notInterested
        //    println(s"New fragment (${nextFrag.from}, ${nextFrag.to}) with ${nextFrag.value}")
        List(nextFrag.value) ++ fragment(newAdds)
      }
    }
  }

  def extractFromMerge(adds: List[RangedVal]): Long = {
    adds match{
      case List() => 0l
      case List(RangedVal(_, _, value)) => value
      case _ => {
        val startRV = adds.head
        val (allInterested, notInterested) = adds.partition( x => x.from <= startRV.to)
        val max = allInterested.map(_.value).sum
        val newInterested = (for(merged <- allInterested.tail) yield {
          if(merged.to <= startRV.to) List()
          else List(RangedVal(startRV.to+1, merged.to, merged.value))
        }).flatten
        val other = extractFromMerge(newInterested ++ notInterested)
        //    println(s"${startRV.from}->${startRV.to}: max=$max other=$other")
        if(max>other) max else other
      }
    }
  }*/
}

// {  }