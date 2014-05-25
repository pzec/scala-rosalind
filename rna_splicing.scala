package rosalind
import scala.io.Source

object rna_splicing extends App {
	def groupReads(xs:List[String], s:String):List[(String, String)] = xs match {
	  case read_id::xst if read_id.startsWith(s) => val (read_lines, rest) = xst.span(!_.startsWith(">"))
	    								(read_id,read_lines.mkString(""))::groupReads(rest, s)	  
	  case Nil => Nil
	  case x::xst => groupReads(xst, s)
	}
	def spliceGene(gene: String, introns: List[(String, String)]):String = introns match {
	  case Nil => println("spliced last: " + gene.length); gene 
	  case _ => println("splice: " + gene.length + " " + introns(0) + " " + introns(0)._2.length);spliceGene(gene.replaceAll(introns(0)._2, ""), introns.drop(1))	  
	}
	val whereami = System.getProperty("user.dir")
	println(whereami)
	//val lines = Source.fromFile(whereami + "/src/assets/gc_test.txt").getLines.toList	  
	val lines = Source.fromFile(whereami + "/src/assets/rosalind_splc.txt").getLines.toList
	//rosalind_splc
	val codonFile = Source.fromFile(whereami + "/src/assets/rna_codon.txt").getLines.toList
	val codons = codonFile.map(l => l.split(" ").toList).map{ case a::b::Nil => (a,b)}
	  									.groupBy(_._1)
	  									.map{case (k,v) => (k, v.map(_._2).mkString)}
	val groupList = groupReads(lines, ">")
	val gene = groupList(0)._2
	//non functional code style, gene must be var
	//groupList.drop(1).foreach(intron => {gene = gene.replaceAll(intron._2, "")})
	groupList.drop(1).foreach(intron => {println(gene.split(intron._2).toList.length)})
	println(groupList)
	println(gene)
	val x = spliceGene(gene, groupList.drop(1))
	
	val str = x
		.replaceAll("T", "U")
	println(str)
	println(str.length)
	
	str.grouped(3).foreach(a => { if (codons(a) != "Stop") print(codons(a))})
}