class Solution {
  fun solution(numList: IntArray): Int = numList.indexOfFirst { i -> i < 0 }
}