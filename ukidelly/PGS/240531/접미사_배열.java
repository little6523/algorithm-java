package _2024_05_31;

import java.util.Arrays;

public class 접미사_배열 {
  public static void main(String[] args) {
    String myString = "banana";
    String[] answer = solution(myString);

    System.out.println(Arrays.toString(answer));
  }

  public static String[] solution(String myString){
    String[] answer = new String[myString.length()];

    for (int i = 0; i <myString.length(); i++) {
      answer[i] = myString.substring(i);
    }

    Arrays.sort(answer);

    return answer;
  }
}


// ================== Kotlin ==================
// private fun solution(myString: String): Array<String> {
//   val answer = mutableListOf<String>()
//
//   for ( idx in myString.indices ){
//     answer.add(myString.substring(idx))
//   }
//
//   return answer.sorted().toTypedArray()
// }
//
// private fun solution2(myString: String) = myString.indices.map(myString::substring).sorted()
//
// fun main(){
//   val answer: Array<String> = solution("banana")
//   answer.forEach { println(it) }
// }
