package X_Exercises.Collections

/**
  * Created by Mateusz Niedośpiał on 28.08.2017.
  */
object Exercises {
  def main(args: Array[String]): Unit = {
    val travel: Traversable[Int] = Traversable(1,2,3)
    val travel2: Traversable[Int] = travel map (_ * 2)
    travel.foreach(a => println(a))
    travel2.foreach(a => println(a))

    println()
    val travel3: Traversable[Int] = travel ++ travel2
    travel3.foreach(a => println(a))

    val travel4: Traversable[Int] = travel ++ travel2.filter(a => a%3 == 0)
    println()
    travel4.foreach(a => println(a))

    println()
    val travel5: List[Int] = travel4.toList
    val newList: List[Int] = List.concat[Int](travel5, travel4)
    println("List.concat[]()")
    newList.foreach(a => println(a))

    println(":+")
    travel5.foreach(a => println(a))
    println()
    val lista: Traversable[Int] = travel4.tail
    val listaa: List[Int] = travel5.tail

    val list: List[Int] = travel5 ::: listaa
    list.foreach(a => println(a))

    val sum: Int = list.sum
    println()
    println(sum)

    val sum2: Int = list.fold[Int](0){
      (a,b) => a+b
    }

    val stringList: List[String] = list.foldLeft[List[String]](List[String]()){
      (a, b) =>
        a :+ "Number " + b.toString
    }

    stringList.foreach(a => println(a))
    println()

    val partited: (List[Int], List[Int]) = list partition (a => a%3 == 0)
    partited._1.foreach(a => println(a))
    println()
    partited._2.foreach(a => println(a))

    val cos: String = stringList.mkString(" ")
    println(cos)

    val iterate: Iterable[Int] = Iterable(1,2,3,4,5,6)

    def masterChefNumber(f: (String, Int) => String, p:String, v:Int): Unit ={
      println(f.apply(p, v))
    }
    val f: (String, Int) => String = (a: String, b: Int) => a+b.toString

    masterChefNumber(f, "Gordon", 1)
  }
}
