package rosalind
import scala.io.Source

object Point_mutations {
  
  def hammingDist(s:String, t:String):Int = {
    var sum:Int = 0
    (s.toCharArray(), t.toCharArray()).zipped.foreach { (a, b) => if (a != b) sum += 1}
    sum
  }
  
  def interleave(x:Int, l:List[Int]):List[List[Int]] = {
    l match {
      case Nil => List(List(x))
      case (head::tail) =>          
	      val res = (x :: head :: tail) :: (interleave(x, tail).map(head :: _))
	      //println(res)
	      res
	}
  }
	
  def permutations(l:List[Int]):List[List[Int]] = {
    l match {
      case Nil => List(List())
      case (head::tail) =>
        for(p0 <- permutations(tail); p1 <- interleave(head, p0)) yield p1        
	}
  }
  
  def permutations2[T](ls: List[T]): List[List[T]] = ls match {
    case List() => List(List())
    case _ => for(e <- ls; r <- permutations2(ls filterNot(_==e))) yield e::r
  }
  
  def main(args: Array[String]){
    /*val linesIter = Source.fromFile("/home/pedja/Downloads/rosalind_hamm.txt").getLines
    
    val s = linesIter.next //"GAGCCTACTAACGGGAT"
    val t = linesIter.next //"CATCGTAATGACGGCCT"
    println(hammingDist(s, t))*/
    //println(for(i<- List(1,2,3); j<-List('a','b','c') if j != 'b') yield (i,j))
    //println(interleave(1, List(2,3)))
    //println(permutations2(List(1,2,3)))
    val l = 1 to 5
    println(l.permutations.length)
    l.permutations.foreach {a => a.foreach(b => print(b + " ")); println()}
  }

}