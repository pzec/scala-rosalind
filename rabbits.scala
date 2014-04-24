package scala_one
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
  
  def main(args: Array[String]) {
    val f = Source.fromFile("/home/pedja/Downloads/rosalind_fib.txt")
    val (n,k) = f.getLines.next.split(' ') match {case Array(a:String, b:String) => (a.toInt, b.toInt)}
    println(fibo(5))
    println(fibo2(n, k))
    
  }

}