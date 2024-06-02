package _2024_06_01;

public class 문자열_앞에_n글자 {
  public static void main(String[] args) {
    String answer = solution("banana", 3);

    System.out.println(answer);
  }
  public static String solution(String myString, int n){
    return myString.substring(0,n);
  }
}


// ================== Kotlin ==================
/**
private fun solution(myString:String, n:Int) = myString.slice(0..n)
private fun solution2(myString:String,n:Int) = myString.take(n)

fun main(){
  val result = solution("ProgrammerS123",11)

  println(result)
}
*/