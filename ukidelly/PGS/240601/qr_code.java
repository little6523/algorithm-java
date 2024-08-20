class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        
        for (int i=0; i<code.length(); i++){
            if (i%q == r){
                answer += code.charAt(i);
            }
        }
        
        return answer;
    }
}

// ============= Kotlin =============
/** 
// 제가 작성한 코드
private fun solution(q:Int, r:Int, code:String):String{
  val sb = StringBuilder()
  for ( (i,c) in code.withIndex() ) {
    if (i%q == r) 
      sb.append(c)
  }
  
  return sb.toString()
}

private fun solution2(q:Int, r:Int, code:String):String {
  return code.indices.filter { it % q == r }.joinToString(""){code[it].toString()}
}

*/