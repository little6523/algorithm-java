/**
 * 제가 푼 방식
 */
fun solution(n:Int, k:Int):IntArray = buildList { for ( i in k..n step k) add(i) }.toIntArray()

/**
 * 인상 깊었던 다른 사람의 풀이
 */
fun solution2(n: Int, k: Int): IntArray = IntArray(n / k) { it * k + k }

fun solution3(n: Int, k: Int): IntArray = (1..n).filter{ it % k == 0 }.toIntArray()
