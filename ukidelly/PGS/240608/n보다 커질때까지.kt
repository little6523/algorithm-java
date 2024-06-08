class Solution {
  fun solution(numbers: IntArray, n: Int): Int = numbers.reduce { acc, i -> if (acc > n) acc else acc + i }
}