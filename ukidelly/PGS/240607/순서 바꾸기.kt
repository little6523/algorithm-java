class Solution {
  fun solution(numList: IntArray, n: Int): IntArray {
    val (front, end) = numList.filterIndexed { index, _ -> index < n } to numList.filterIndexed { index, _ -> index >= n }

    return (end + front).toIntArray()
  }
}