package alorenz.util

class Probability {

  def vect(n: Long): Long = n match {
    case x if x <= 1 => 1
    case x => x * vect(x-1)
  }

  def subset(subsetElements: Int, totalElements: Int): Int = {
    // Based on http://shirleyisnotageek.blogspot.co.uk/2015/08/scala-note-1-pascals-triangle.html
    if  (subsetElements == 0 || subsetElements == totalElements || totalElements == 0)  1
    else
      subset(subsetElements - 1, totalElements - 1) + subset(subsetElements, totalElements - 1)
  }

  // From https://www.mathsisfun.com/activity/subsets.html (it counts also empty subset)
  def totalSubset(totalElements: Double) = math.pow(2.toDouble, totalElements)

  // Total partitions of any dimension
  def partitions(totalElements: Double): Double = (totalElements+1)*(totalElements/2).toFloat

  // Partitions of fixed dimension
  def partitions(totalElements: Double, fixedDim: Double): Double = totalElements - fixedDim + 1

}
