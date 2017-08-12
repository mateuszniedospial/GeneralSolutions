package X_Exercises.Generics

/**
  * Created by Mateusz Niedośpiał on 11.08.2017.
  */
trait Animal {

  def age(): Int
  def name(): String
  def weight(): Double

  def makeSound(): Unit
  def eat(): Unit

}
