package X_Exercises.BasicMathOperationInterpreter

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
object X_Test {

  def main(args: Array[String]): Unit = {

    //Regular
    val op = new Sum(new Num(8), new Sub(new Num(12), new Sum(new Num(3), new Num(4))))
    val result: Double = op.execute
    println(result.toString)

    //CaseClasses
    val caseOp = CaseSum(CaseNum(8), CaseSub(CaseNum(12), CaseSum(CaseNum(3), CaseNum(4))))
    val caseResult: Double = caseOp.execute
    println(caseResult.toString)

    //PatternMatching
    val caseResultPM: Double = caseOp.eval
    println(caseResultPM.toString)

  }

}
