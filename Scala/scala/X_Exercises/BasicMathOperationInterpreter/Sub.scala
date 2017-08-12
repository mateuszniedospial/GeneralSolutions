package X_Exercises.BasicMathOperationInterpreter

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
class Sub(val fValue: Operation, val sValue: Operation) extends Operation {
  override def execute: Double = fValue.execute-sValue.execute
}
