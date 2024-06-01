import java.util.Arrays;

public class 부분_문자열_이어_붙여_문자열_만들기 {
  public static void main(String[] args) {

    String answer = solution(new String[]{"progressive", "hamburger", "hammer", "ahocorasick"}, new int[][]{{0, 4}, {1, 2}, {3, 5}, {7, 7}});

    System.out.println(answer);
  }

  public static String solution(String[] myStrings, int[][] parts){
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < myStrings.length; i++) {
      int start = parts[i][0];
      int end = parts[i][1];

      sb.append(myStrings[i].substring(start, end +1));
    }

    return sb.toString();
  }
}


// ================== Kotlin ==================
// import java.lang.StringBuilder
//
// fun main(){
//   val my_strings = arrayOf("progressive", "hamburger", "hammer", "ahocorasick")
//   val parts = arrayOf(intArrayOf(0, 4), intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(7, 7))
//
//   val result = solution(my_strings, parts)
//   println(result)
// }
//
// private fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
//   val sb = StringBuilder()
//
//   for ( (index, part) in parts.withIndex() ) {
//     val start: Int = part[0]
//     val end: Int = part[1]
//
//     val result: String = my_strings[index].substring(start, end + 1)
//     sb.append(result)
//   }
//
//   return sb.toString()
// }
//
// private fun solution2(my_strings: Array<String>, parts: Array<IntArray>): String {
//   return my_strings.indices.joinToString("") {
//     my_strings[it].substring(parts[it][0], parts[it][1])
//   }
// }