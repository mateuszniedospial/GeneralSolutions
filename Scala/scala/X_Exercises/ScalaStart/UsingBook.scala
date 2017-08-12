package X_Exercises.ScalaStart

/**
  * Created by Mateusz Niedośpiał on 12.08.2017.
  */
object UsingBook {

  def main(args: Array[String]): Unit = {
    val books: List[Book] =
      List(
        Book(),
        Book("Game of Thrones", List("Jon Snow", "Daenerys Targaryen", "Franko Pollo")),
        Book("GG WP Tutorial"),
        Book("Dota2 For Pros")
      )

    val specificBooks = for(a <- books; b <- a.authors if b.contains("Frank")) yield a.name
    specificBooks.foreach(a => println(a))
  }
}
