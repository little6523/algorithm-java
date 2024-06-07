/**
 * 제 풀이
 */
class Solution {
  fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    intervals.forEach { (start, end) -> answer += arr.slice(start..end) }

    return answer
  }
}

/**
 * 인상 깊었던 풀이
 */
class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        return intervals.flatMap { (left, right) -> arr.slice(left..right) }.toIntArray()
    }
}