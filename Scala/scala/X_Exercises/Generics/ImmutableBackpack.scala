package X_Exercises.Generics

/**
  * Created by Mateusz Niedośpiał on 11.08.2017.
  */
final case class ImmutableBackpack[A](_listOfItems: List[A], _preciseSize: Int) {

  //Example additional constructor:
  def this(_listOfItems: List[A]){
    this(_listOfItems, 20)
    if(_listOfItems.length-1 != 20) println("The backpack is not full.")
  }

  def getData(): List[A] = _listOfItems

  def size(): Int = _listOfItems.length-1

  def isFull: Boolean = _listOfItems(this.size()) != null

  //Due to immutability this action actually return a new backpack with extended list of elements:
  def add(backpack: ImmutableBackpack[A], item: A):ImmutableBackpack[A] = {
    val extendedList: List[A] = backpack._listOfItems:+item
    ImmutableBackpack(extendedList, extendedList.length)
  }

  def printAll():Unit = for(a <- _listOfItems.indices) println(_listOfItems(a).toString)
}
