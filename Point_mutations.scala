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
	      (x :: head :: tail) :: interleave(x, tail).map(head :: _)
	}
  }
	
  def permutations(l:List[Int]):List[List[Int]] = {
    l match {
      case Nil => List(List())
      case (head::tail) =>
        for(p0 <- permutations(tail); p1 <- interleave(head, p0)) yield p1
	}
  }
  
  def main(args: Array[String]){
    val linesIter = Source.fromFile("/home/pedja/Downloads/rosalind_hamm.txt").getLines
    
    val s = linesIter.next //"GAGCCTACTAACGGGAT"
    val t = linesIter.next //"CATCGTAATGACGGCCT"
    println(hammingDist(s, t))
    println(permutations(List(1,2,3)))
  }

}