import java.util.ArrayList;
import java.util.Arrays;

public class 배열_만들기 {

  public static void main(String[] args) {
    String[] intStrs = {"0123456789","9876543210","9999999999999"};

    int k = 50000;
    int s = 5;
    int l = 5;

    int[] answer = solution(intStrs, k, s, l);
    System.out.println(Arrays.toString(answer));
  }


  public static int[] solution(String[] intStrs, int k, int s, int l) {
    ArrayList<Integer> result = new ArrayList<>();

    for (String intStr : intStrs) {
      String substring = intStr.substring(s, s + l);
      int newStr = Integer.parseInt(substring);

      if (newStr < k) {
        continue;
      }

      result.add(newStr);
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}

// ================== Kotlin ==================
// fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
//   var answer: IntArray = intArrayOf()
//
//   for ( i in intStrs ) {
//     val newArr: Int = i.substring(s,s+l).toInt()
//
//     if (newArr > k) {
//       answer += newArr
//     }
//   }
//
//   return answer
// }