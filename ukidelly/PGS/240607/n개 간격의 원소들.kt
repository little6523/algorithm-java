class Solution {
  fun solution(numList: IntArray, n: Int): IntArray =
    numList.slice(0..numList.lastIndex step n).toIntArray()
}