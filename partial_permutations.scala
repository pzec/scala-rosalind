package rosalind

object partial_permutations extends Application {
	val n = 21
	val k = 7
	// n!/(n-k)! = (k+1)*(k+2)*...*n
	val kplus1ton = (1 to n).toList.drop(k)
	println(kplus1ton)
	println(kplus1ton.reduceLeft((a, b) => (a * b)%1000000))
}