package X_Exercises.ScalaStart

/**
  * Created by Mateusz Niedośpiał on 08.08.2017.
  */
object BasicFeatures {

  def main(args: Array[String]): Unit = {

    var iteration: Int = 0

    def binarySearch(startIndex : Int, endIndex: Int, sortedList : List[Int], toFind : Int): Int = {
      var end: Int = endIndex
      var start: Int = startIndex
      while (end != start+1) {
        iteration = iteration + 1
        var middle: Int = (end-start)/2
        if (sortedList(start+middle) == toFind) return sortedList(start+middle)
        else if (sortedList(start+middle) > toFind) end = start+middle
        else {
          start = start+middle
        }
      }
      throw new UnsupportedOperationException("The number has not been found in the list.")
    }

    val sorted:List[Int] = List(1,3,5,8,10,14,18,20,22,24,28,33,36,40)
    println("Found: "+binarySearch(0, sorted.length, sorted, 33).toString)
    println("On iteration: "+iteration)

    def sumInts(a: Int, b: Int): Int = {
      println("a = " + a.toString)
      println("b = " + b.toString)
      if(a > b) 0 else a + sumInts(a+1, b)
    }

    sumInts(5,8)

    /*
     Scala allows to declare a higher-order functions as follows:
     */

    def higherFun(func: (Int, Int) => Int, a: Int, b:Int): Int ={
      func(a,b)
    }

    def function(a: Int, b: Int): Int = {
      println(a+b)
      a+b
    }

    //Calling the higher-order function:
    higherFun(function, 5, 6)


    /*
    There is no need to declare method function in the above example. Instead
    we can use anonymous function:
     */

    higherFun((a: Int, b: Int) => a+b, 5,6)

    /*
    A function in scala can also return another function:
     */

    def higherOrderFunction(func: (Int, Int) => Int) = {
      def sum(a: Int, b: Int): Int = {
        println(func(a,b))
        func(a,b)
      }
      sum(6,6)
    }

    higherOrderFunction((a: Int, b: Int) => a+b)
  }

}
