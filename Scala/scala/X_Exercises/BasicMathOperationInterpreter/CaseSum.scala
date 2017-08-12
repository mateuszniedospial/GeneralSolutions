package X_Exercises.BasicMathOperationInterpreter

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
case class CaseSum(fValue: Operation, sValue: Operation) extends Operation {
  override def execute: Double = fValue.execute + sValue.execute
}
