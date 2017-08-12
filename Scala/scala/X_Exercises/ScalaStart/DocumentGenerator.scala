package X_Exercises.ScalaStart

/**
  * Created by Mateusz Niedośpiał on 09.08.2017.
  */
class DocumentGenerator(id: Long, firstName: String, lastName: String, money: String, city: String, isCitizen: Boolean) {

  private var _ID: Long = id
  private var _firstName: String = firstName
  private var _lastName: String = lastName
  private var _money: String = money
  private var _city: String = city
  private var _isCitizen: Boolean = isCitizen

  def ID: Long = _ID
  def getFirstName: String = _firstName
  def getLastName: String = _lastName
  def getMoney: String = _money
  def getCity: String = _city
  def citizen: Boolean = _isCitizen

  def ID_(id: Long): Unit = _ID = id
  def firstName_= (name: String) { _firstName = name }
  def lastName_(name: String): Unit = _lastName = name
  def money_(amount: String): Unit = _money = amount
  def citizenship_(trueOrFalse: Boolean): Unit = _isCitizen = trueOrFalse

}
