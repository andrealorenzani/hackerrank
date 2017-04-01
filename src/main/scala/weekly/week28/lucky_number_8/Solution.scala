
// https://www.hackerrank.com/contests/w28/challenges

/*object Solution {


    def main(args: Array[String]) {
      val sc = new java.util.Scanner (System.in);
      var n = sc.nextInt();
      var number = sc.next();

      print(solve(n, number))
    }

    def solve(n: Int, number: String): Long = {
      def verifyIsLuckyEight(num: Long): Boolean = num % 8 == 0

      val listDigit = number.toCharArray.map(_.asDigit).toList
      val maxRes: Long = 1000000000 + 7 // 10^9 + 7

      def combination(nel: Int, elements: List[Int]): List[(Long, Long)] = {
        if (nel < 1) List.empty
        nel match {
          case 1 => elements.filter(verifyIsLuckyEight(_)).map(x => (1.toLong, x.toLong))
          case 2 =>
            val res = for (pos <- 0 until elements.length - 1;
                           dec = elements(pos) * 10.toLong;
                           pos2 <- pos + 1 until elements.length;
                           elem = dec + elements(pos2)
                           if verifyIsLuckyEight(elem))
              yield (1.toLong, elem)
            res.toList ++ combination(1, elements)

          case x if x > 2 =>
            val res =for (pos <- 0 until elements.length - 2;
                          cent = elements(pos)*100.toLong;
                          pos2 <- pos + 1 until elements.length - 1;
                          dec = elements(pos2)*10;
                          pos3 <- pos2 + 1 until elements.length;
                          elem = cent + dec + elements(pos3);
                          totalElements = pos.toLong;
                          if verifyIsLuckyEight(elem))
              yield {
                ((math.pow(2.toDouble, totalElements) % maxRes).toLong, elem)
              }
            res.toList ++ combination(2, elements)
        }
      }

      var subs = scala.collection.mutable.HashMap.empty[Long, Long]
      combination(n, listDigit).foreach{
        case (occ, x) if subs.contains(x) => subs(x) = subs(x) + occ
        case (occ, x) => subs(x) = occ
      }
      val res: Long = subs.map {
        case (x, occ) => occ
        case _ => 0.toLong
      }.sum

      res % maxRes
    }

}
*/