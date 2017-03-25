import scala.util.Random

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val number = sc.next()
    print(solve(n, number))
  }
  def solve(n: Int, number: String): Long = {
    val listDigit = number.toCharArray.map(_.asDigit).toList
    val maxRes: Long = 1000000000 + 7 // 10^9 + 7
    val mod35 = math.pow(2.toDouble, 35.toDouble)%maxRes

    val mapOf0xx = scala.collection.immutable.Map(0->Set(0,4,8), 2->Set(3,7), 4->Set(2,6), 6->Set(1,5,9), 8->Set(0,4,8))
    val mapOf1xx = scala.collection.immutable.Map(
      0->Set(2,6,0), 2->Set(1,5,9), 4->Set(0,4,8), 6->Set(3,7), 8->Set(2,6))

    def subsets(elements: Long): Long = {
      val nof35s: Double = elements/35
      val resto: Double = elements%35
      var acc = 1.toDouble
      for (acci <- 1.toLong until nof35s.toLong)
      {
        acc = (acc * mod35)%maxRes

      }
      acc = acc * math.pow(2.toDouble, resto)
      (acc % maxRes).toLong
    }

    def combination(nel: Int, elements: List[Int]): Double = {
      var res: Double = 0
      if (nel < 1) 0
      for(pos <- elements.length-1 to 0;
          units = elements(pos)
          if units % 2 == 0){
        if(units == 8) res = (res + 1)%maxRes
        if(pos==0) res
        else {
          val tailEl = elements.dropRight(elements.length-pos)
          for(pos2 <- pos - 1 to 0)
        }
      }
      /*nel match {
        case 1 => elements.count(_==8) % maxRes
        case 2 =>
          for (pos <- 0 until elements.length - 1;
               dec = elements(pos) ;
               tbf <- unit100(dec)) {
            //println(s"$res: ${dec}X searching for $tbf in $units")
            res += elements.drop(pos+1).count(_ == tbf)
            res = res % maxRes
          }
          //println(s"2 has $res")
          (res + combination(1, elements)) % maxRes

        case x if x > 2 =>
          var res = 0.toLong
          for (pos <- 0 until elements.length - 2;
               iscent = elements(pos) % 2 == 1;
               pos2 <- pos + 1 until elements.length - 1;
               dec = elements(pos2);
               tbf <- if(iscent) unit200(dec) else unit100(dec)) {
            //println(s"$res: ${elements(pos)}${dec}X searching for $tbf in $units")
            res += elements.drop(pos2+1).count(_==tbf)*subsets(pos)
            res = res % maxRes
          }
          //println(s"3 has $res")
          (res + combination(2, elements)) % maxRes
      }*/
    }

    (combination(n, listDigit) % maxRes).toLong
  }
}
