package rosalind
import scala.io.Source

object gc_content {	
  
  
	def groupReads(xs:List[String], s:String):List[(String, String)] = xs match {
	  case read_id::xst if read_id.startsWith(s) => val (read_lines, rest) = xst.span(!_.startsWith(">"))
	    								(read_id,read_lines.mkString(""))::groupReads(rest, s)	  
	  case Nil => Nil
	  case x::xst => groupReads(xst, s)
	}
  
	def main(args: Array[String]) {
	  val whereami = System.getProperty("user.dir")
	  println(whereami)
	  //val lines = Source.fromFile(whereami + "/src/assets/gc_test.txt").getLines.toList	  
	  val lines = Source.fromFile("/home/pedja/Downloads/rosalind_gc.txt").getLines.toList
	  //lines.zipWithIndex foreach {case(line, idx) => println(idx + " " + line)}
	  var nuc:String = ""
	  
	    
	  val l2 = lines.filter {line => line.startsWith(">")}.toList
	  println(lines.partition {_.startsWith(">")})
	  println(l2.takeWhile {_.startsWith(">")}.toList)
	  l2 foreach (println(_))
	  val reads = groupReads(lines, ">")
	  println(reads)
//	  for (line <- lines) {
//	    if (line.startsWith(">")) {
//	      if (nuc.length() > 0)
//	        println(nuc)
//	      nuc = ""
//	      
//	    } else {
//	    	nuc += line
//	    }
//	  }
//	  println(nuc)
	  def calc_gc_cont(s:String):Float = {
	    val gc = s.toCharArray().toList.filter(c=>c=='C'||c=='G').length
	    val all = s.length
	    gc.toFloat/all.toFloat*100
	  }
	  
	  def find_highest_gc(reads: List[(String, String)]):(String, Float) = {	    
	    reads.map(t => (t._1, calc_gc_cont(t._2))).maxBy(_._2)
	  }
	  
	  val (rid, rstr) = find_highest_gc(reads)
	  println(reads.map(t => (t._1, calc_gc_cont(t._2))))
	  println(rid)
	  println(rstr)
	  
	}
}