/**
 * 반례 때문에 고생 좀 했네요
 */
class Solution {
  fun solution(strList: Array<String>): Array<String> {

    for ((i, s) in strList.withIndex()) {
      // "l"이 나오기 전까지 앞의 요소들을 선택해서 반환
      if (s == "l") return strList.slice(0..<i).toTypedArray()

      // "r"이 나오기 전까지 뒤의 요소들을 선택해서 반환
      else if (s == "r") return strList.slice((i + 1)..<strList.lastIndex).toTypedArray()
    }

    // "l" 또는 "r"이 없는 경우 빈 배열 반환
    return emptyArray()
  }
}