package X_Exercises.ScalaStart

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
class Lion(val name: String, var age: Int, var weight: Int, var speed: Double, var gender: String) {

  def doNotFeedForDays(n: Int):Unit = {
    println("The lion called: " + name)
    println("weight equals: " + weight)
    println("---------------")
    for( a <- 1 to n){
      println("Hasn't eaten for " + a.toString + " days.")
      weight -= 1
      println("The weight of the lion is dropping.")
    }

    println("Weight of the lion has dropped to: " + weight + " kg.")
  }
}
