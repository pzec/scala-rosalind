package rosalind
import scala.io.Source

object gc_content {	
  
	def main(args: Array[String]) {
	  val whereami = System.getProperty("user.dir")
	  println(whereami)
	  val lines = Source.fromFile(whereami + "/src/assets/rosalind_gc.txt").getLines	  
	  //lines.zipWithIndex foreach {case(line, idx) => println(idx + " " + line)}
	  var nuc:String = "" 
	  for (line <- lines) {
	    if (line.startsWith(">")) {
	      nuc = ""
	    }
	    nuc += line
	  }
	}
}