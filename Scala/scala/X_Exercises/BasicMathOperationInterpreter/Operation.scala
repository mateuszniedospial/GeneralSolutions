package X_Exercises.BasicMathOperationInterpreter

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
trait Operation {
  def execute: Double

  //Using Pattern Matching:
  def eval: Double = this match {
    case CaseNum(value) => value
    case CaseSum(fValue, sValue) => fValue.execute + sValue.execute
    case CaseSub(fValue, sValue) => fValue.execute - sValue.execute
  }
}
