package X_Exercises.Generics

import scala.reflect.ClassTag

/**
  * Created by Mateusz Niedośpiał on 11.08.2017.
  */
case class Dog(_age: Int, _name: String, _weigth: Double) extends Animal{
  override def age(): Int = _age

  override def name(): String = _name

  override def weight(): Double = _weigth

  override def makeSound(): Unit = println("Barrk!")

  override def eat(): Unit = println("The dog named: " + _name + " is eating.")

  def callOthers[B](any: B): Animal = {
    any match {
      case cat: Cat => cat
      case animal: Animal => animal
      case _ => throw new UnsupportedOperationException("Not supported.")
    }
  }
}
