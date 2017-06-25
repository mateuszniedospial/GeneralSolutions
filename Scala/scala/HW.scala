/**
  * Created by Mateusz Niedośpiał on 18.06.2017.
  */
object HW {

  def main(args: Array[String]): Unit = {
    val obiektJava:Nowa = new Nowa("String", "String", 5, 5)
    val obiekt: HelloWorld = new HelloWorld(5, 20)
    val answer:String = obiekt.whyMe("b")

    println(obiektJava.getFirstField)
    println(obiektJava.getFirstNumber + obiektJava.getSecondNumberPr)
    println("Sumuje z obiektu javy i scali:")

    println(obiektJava.getFirstNumber + obiekt.returnSecond())

    println("Tu juz sama scala:")
    println(answer)

    println("============================")
    println("Factorial:")
    println(obiekt.factorial(5).toString)
  }

}
