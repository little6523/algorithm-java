package _2024_05_31;

public class 접미사인지_확인하기 {
  public static void main(String[] args) {
    int answer = solution("banana", "ana");

    System.out.println(answer);
  }

  public static int solution(String myString, String isSuffix){
    return myString.endsWith(isSuffix) ? 1 : 0;
  }
}

// ================== Kotlin ==================
// private fun solution(myString: String, isSuffix: String) = if (myString.endsWith(isSuffix)) 1 else 0