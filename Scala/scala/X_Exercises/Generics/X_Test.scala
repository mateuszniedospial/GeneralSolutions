package X_Exercises.Generics

/**
  * Created by Mateusz Niedośpiał on 11.08.2017.
  */
object X_Test {

  def main(args: Array[String]): Unit = {
    val list: List[String] = List("abc", "cba")
    val list2: List[String] = List("gha", "gumlala")
    val table: Array[Int] = Array(1,2,3)
    val newtable: Array[Int] = table:+1

    for(a <- newtable.indices) println(newtable(a).toString)

    val imBP: ImmutableBackpack[String] = ImmutableBackpack(list, list.length)
    imBP.printAll()
    val imBP2: ImmutableBackpack[String] = ImmutableBackpack(list2, list.length)
    val imBP3 = imBP.add(imBP2, "puf")

    imBP3.printAll()

    val mika: Dog = Dog(6, "Mika", 14.25)
    val cyprus: Cat = Cat(4, "Cyprus", 3.45)
    val fluffy: Cat = Cat(5, "Fluffy", 4)

    mika.makeSound()
    val who: Animal = mika.callOthers[Animal](cyprus)
    val who2: Animal = mika.callOthers[Cat](cyprus)
    who.makeSound()
    println("====")
    who2.makeSound()

    println(".........................................")

    val animalList: List[Animal] = List(mika, cyprus, fluffy)

    val names: List[String] = for(a <- animalList if a.weight() <= 4) yield a.name()

    names.foreach(n => println(n))
  }

}
