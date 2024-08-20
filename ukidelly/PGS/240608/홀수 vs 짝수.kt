import kotlin.math.max

class Solution {
  fun solution(numList: IntArray): Int {

    val evenSum = numList.filterIndexed { index, _ -> index % 2 == 1 }.sum()
    val oddSum = numList.filterIndexed { index, _ -> index % 2 == 0 }.sum()

    return max(evenSum, oddSum)
  }
}