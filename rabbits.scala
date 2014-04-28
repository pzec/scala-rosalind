package rosalind
import scala.io.Source

object rabbits {
  // x3 = x2 + 3*x1
  def fibo(x:BigInt):BigInt = x match {
    case y: BigInt if y == 0 => BigInt(1)
    case y: BigInt if y == 1 => BigInt(1)
    case _ => fibo(x-1) + 3*fibo(x-2)
  }
  
  def fibo2(x:BigInt, k:Int):BigInt = {
    var dyna = List[BigInt]()
    dyna = dyna ::: List(BigInt(1))
    dyna = dyna ::: List(BigInt(1))
    for (i:BigInt <- BigInt(3) to x+1){
      dyna = dyna ::: List(dyna(i.toInt-2) + k*dyna(i.toInt-3))
    }
    
    dyna(x.toInt-1)
  }
  
  //mortal fibonacci rabbits
  //x-th generation if every rabbit lives k generations, and every rabbit makes another rabbit each month 
  def fibo3(x:BigInt, k:Int):BigInt = {
    var dyna = List[BigInt]()
    var newborn = List[BigInt]()
    var oldtimers = List[BigInt]()
    //first month
    dyna = dyna ::: List(BigInt(1))
    newborn = newborn ::: List(BigInt(1))
    oldtimers = oldtimers ::: List(BigInt(0))
    //second month
    dyna = dyna ::: List(BigInt(1))
    newborn = newborn ::: List(BigInt(0))
    oldtimers = oldtimers ::: List(BigInt(0))
    //println((BigInt(3) to k-1).toList)
    for (i:BigInt <- BigInt(3) to k-1){
      oldtimers = oldtimers ::: List(BigInt(0))
      dyna = dyna ::: List((dyna(i.toInt-2) - newborn(i.toInt-2))* 2 + newborn(i.toInt-2))
      newborn = newborn ::: List(dyna(i.toInt-2)-newborn(i.toInt-2))
    }
    
    for (i:BigInt <- BigInt(k) to x+1){
      //val y:BigInt = if (i.toInt-k > 0) (newborn(i.toInt-k)) else 0
      
      newborn = newborn ::: List(dyna(i.toInt-2)-newborn(i.toInt-2))
      oldtimers = oldtimers ::: List(newborn(i.toInt-k))
      dyna = dyna ::: List(2*(dyna(i.toInt-2) - oldtimers(i.toInt-2) - newborn(i.toInt-2)) + newborn(i.toInt-2) + oldtimers(i.toInt-2)) 
      
      //println(i + " " + dyna(i.toInt-2) + " " + newborn(i.toInt-2) + " " + oldtimers(i.toInt-2))
    }
    
//    println(dyna)
//    println(newborn)
//    println(oldtimers)
    dyna(x.toInt-1)
  }
  
  def main(args: Array[String]) {
    //val f = Source.fromFile("C:/Users/pedja/Downloads/rosalind_fibd.txt")
    val f = Source.fromFile("/home/pedja/Downloads/rosalind_fibd.txt")
    val (n,k) = f.getLines.next.split(' ') match {case Array(a:String, b:String) => (a.toInt, b.toInt)}
    //println(fibo(5))
    println(fibo3(n, k))
//    println(fibo3(7, 4))
//    println(fibo3(6, 3))
//    println(fibo3(7, 5))
//    println(fibo3(12, 3))
    
  }

}