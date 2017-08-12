package X_Exercises.Generics

/**
  * Created by Mateusz Niedośpiał on 11.08.2017.
  */
case class Cat(_age: Int, _name: String, _weight: Double) extends Animal {

  override def age(): Int = _age

  override def name(): String = _name

  override def weight(): Double = _weight

  override def makeSound(): Unit = println("Meow!")

  override def eat(): Unit = println("The cat named: " + _name + " is eating.")
}
