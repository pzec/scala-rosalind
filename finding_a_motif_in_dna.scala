package rosalind
import scala.annotation.tailrec

object finding_a_motif_in_dna extends Application {
	val s = "GATATATGCATATACTT"
	val t = "ATAT"
	
	
	def countSubstring(str1:String, str2:String):Int={
	   @tailrec def count(pos:Int, c:Int):Int={
	      val idx=str1 indexOf(str2, pos)
	      if(idx == -1) c else count(idx+1, c+1)
	   }
	   count(0,0)
	}
	
	println(countSubstring(s, t))
}