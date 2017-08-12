package X_Exercises.ScalaStart

/**
  * Created by Mateusz Niedośpiał on 18.06.2017.
  */
class SimpleClass(private val firstInt:Int,
                  private val secondInt:Int) {

  def this(first:Int){
    this(first, 0)
  }

  def this(second:String){
    this(0, second.toInt)
  }

  def whyMe(why:String): String = {
    if(why.equals("because")){
      println(firstInt)
      why
    } else {
      println(secondInt)
      why+"not"
    }
  }

  def returnSecond(): Int = secondInt

  def factorial(input:Int):Int = {
    if(input-1 == 1){
     return input
    }
    input*factorial(input-1)
  }
}
