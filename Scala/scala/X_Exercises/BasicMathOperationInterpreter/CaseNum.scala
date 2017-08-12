package X_Exercises.BasicMathOperationInterpreter

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
case class CaseNum(value: Double) extends Operation {
  override def execute: Double = value
}
