package X_Exercises.ScalaStart

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
object X_Test {

  def main(args: Array[String]): Unit = {
    val document = new DocumentGenerator(10L, "David", "Redfield", "$25000", "Chicago", true)

    println("About the document:")
    println("This is a document of ID = " + document.ID)
    println("The owner is: " + document.getFirstName + " " + document.getLastName)
    println("Currently He/She owns: " + document.getMoney)
    println("And lives in: " + document.getCity)

    if(document.citizen) println("He/She is citizen of the United States.")
    else println("He/She is not a citizen of the United States")

    document.firstName_=("Mark")
    document.lastName_("Whitefield")

    println("==")
    println("Now His/Her name is: " + document.getFirstName + " " + document.getLastName)

    println(".......................................")

    val lionRex = new Lion("Rex", 5, 80, 30.25, "Male")

    println(lionRex.name)

    lionRex.age = 6
    lionRex.weight = 88

    lionRex.doNotFeedForDays(10)
  }

}
