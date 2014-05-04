package rosalind
import scala.io.Source


object protein_translation {

	def main(args: Array[String]) {
	  val whereami = System.getProperty("user.dir")
	  println(whereami)
	  val lines = Source.fromFile(whereami + "/src/assets/rna_codon.txt").getLines.toList
	  val str = Source.fromFile(whereami + "/src/assets/rosalind_prot.txt").getLines.next
	  val x = List("a" -> "b", "c" -> "d", "a" -> "f")
	  //var codons = Map[String, String]()
	  //lines.map(l => l.split(" ").toList).foreach(li =>  li match { case List(a, b) => codons += (b->a) })
	  val codons = lines.map(l => l.split(" ").toList).map{ case a::b::Nil => (a,b)}
	  									.groupBy(_._1).map{case (k,v) => (k, v.map(_._2).mkString)}
	  println(codons)
	  //val str = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"
	  str.grouped(3).foreach(a => { if (codons(a) != "Stop") print(codons(a))})
	}
}