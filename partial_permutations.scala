package rosalind

object partial_permutations extends Application {
	val n = 95
	val k = 9
	val mod = 1000000
	// n!/(n-k)! = (k+1)*(k+2)*...*n
	val kplus1ton = (1 to n).toList.drop(n-k)
	println(kplus1ton)
	println(kplus1ton.reduceLeft((a, b) => (a * b)%mod))
	//println(kplus1ton.reduceLeft((a, b) => (a * b))%mod)
}