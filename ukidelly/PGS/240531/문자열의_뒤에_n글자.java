
public class 문자열의_뒤에_n글자
{
  public static void main(String[] args) {

  }

  public static String solution(String myString, int n){
    return myString.substring( myString.length() - n );
  }
}


// ================== Kotlin ==================
// private fun solution(myString:String, n:Int) = myString.substring( myString.length - n)
// private fun solution2(myString:String, n:Int) = myString.takeLast(n)
//
// fun main(){
//   println(solution("ProgrammerS123", 11))
//   println(solution2("ProgrammerS123", 11))
// }