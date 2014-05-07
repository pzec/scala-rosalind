package rosalind
import scala.io.Source

object protein_to_mrna extends Application {
  val whereami = System.getProperty("user.dir")
  val codonFile = Source.fromFile(whereami + "/src/assets/rna_codon.txt").getLines
  val codonTable = 5
  val cmap = codonFile.map(_.split(" ").toList).map {case List(a, b) => (a, b)}.toList.groupBy(_._1).map{case (k, v) => (k, v.map(_._2).mkString)}
  val smap = cmap.groupBy(_._2) map { case (k, v) => (k, v.unzip._1)}
  //println(codonFile.map(line => line.split(" ").toList).map {case List(a, b) => (a, b)}.toList.groupBy(_._1).mapValues(_.map(_._2)))
  //println(cmap)
  println(smap)
  val str = "MA"
  val str2 = Source.fromFile(whereami + "/src/assets/rosalind_mrna.txt").getLines.next
  println((str2.split("").tail.toList:::List("Stop")).map {smap(_).toList.length}.foldLeft(1)((a, b) => (a * b)%1000000))
}