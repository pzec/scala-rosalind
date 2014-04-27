package rosalind
import scala.io.Source


object rcomplement {
  //val s:String = "AAAACCCGGT"
  val complements = Map('A'->'T', 'C'->'G', 'G'->'C', 'T'->'A')
  val f = Source.fromFile("/home/pedja/Downloads/rosalind_revc.txt")
  val s = f.getLines.next
  def rcomplement(s:String, complements:Map[Char, Char]):List[Char] = (s.reverse.toCharArray map(c => complements(c))).toList
  
  def main(args: Array[String]){
    println(rcomplement(s, complements).mkString)
  }

}

