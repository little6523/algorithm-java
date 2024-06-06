class Solution {
  fun solution(numList: IntArray, n: Int): IntArray = numList.slice(n..numList.lastIndex).toIntArray()
  
  fun solution2(numList: IntArray, n: Int) = numList.drop(n - 1).toIntArray()
}