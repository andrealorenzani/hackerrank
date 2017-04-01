package interview.amazon.march_2017

object Solution {
  // Returns 1 if {} and [] are balanced
  def isBalanced(str: String): Int = {
    val res = str.foldLeft("") { (x, y) =>
      if ("{}[]".contains(y)) x + y else x
    }
    if (res.length % 2 != 0) 0
    else {
      if (balance(res)) 1 else 0
    }
  }

  def balance(str: String): Boolean = {
    val pos = if (str.charAt(0) == '{') str.indexOf("}") else str.indexOf("]")
    if (pos == -1) false
    else {
      val other = if (pos < str.length - 1) balance(str.substring(pos + 1)) else true
      other && balance(str.substring(1, pos - 1))
    }
  }
}

object Solution2{
  // Returns the maximum number of pairs in numbers array for which (a,b) => |a - b| = k
  /*def countPairs(numbers: Array[Int], k: Int): Int = {
    val sortNum = numbers.toList.sorted
    val head = 0
    val tail = sortNum.length
    val res = findPair(sortNum.head, sortNum.tail, k)
  }

  def findPair(value: Int, other: List[Int], k: Int): List[(Int, Int)] = {
    val lio = other.lastIndexOf(value + k)
    if(lio > -1) List((value, value+k)) ++ findPair(other.head, other.dropRight(lio), k)

  }*/
}
