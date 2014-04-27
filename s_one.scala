package rosalind
import scala.BigInt

class A(apar:Int){
  var a:Int = apar
}

object B{
  val x=5
}

object s_one {
  
  def fact(x: BigInt):BigInt = {
    if (x==0) 1 else x*fact(x-1)
  }
  
  def main(args: Array[String]){
    println(fact(30))    
    val c = new A(3)
    val d = B
  }

}