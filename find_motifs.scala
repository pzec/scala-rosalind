package rosalind
import scala.io.Source

object find_motifs extends Application {
		
	val whereami = System.getProperty("user.dir")
	val file = Source.fromFile(whereami + "/src/assets/rosalind_subs.txt").getLines.toList
	val s = file(0) //"GATATATGCATATACTT"
	val t = file(1) //"ATAT"
	val res = (0 until s.length).filter(s.startsWith(t, _)).toList.map(_ + 1)
	for (i <- res) print(i + " ")
}