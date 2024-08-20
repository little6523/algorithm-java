class Solution {
  fun solution(names: Array<String>): Array<String> {
    return names.slice(0..names.lastIndex step 5).toTypedArray()
  }

  fun solution2(names: Array<String>): Array<String> {
    return names.toList().chunked(5) { it.first() }.toTypedArray()
  }
}