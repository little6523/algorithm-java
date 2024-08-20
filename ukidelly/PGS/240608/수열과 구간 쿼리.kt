class Solution {
  fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {

    queries.forEach { (start, end) ->
      (start..end).forEach {
        arr[it]++
      }
    }
    return arr
  }
}