class Solution {
    public String solution(String myString, int m, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i=c-1; i< myString.length(); i+=m) {
            sb.append(myString.charAt(i));
        }
        
        return sb.toString();
    }
}

/**

* 제가 푼 방법
private fun solution(myString: String, m:Int, c:Int):String {
  val resultList = mutableListOf<String>()

  for (i in myString.indices step m){
    resultList.add(myString.substring(i,i+m))
  }

  return resultList.map { it[c-1] }.joinToString ("")
}

private fun solution2(myString:String, m:Int, c:Int):String{
  return myString.chunked(m).map { it[c-1] }.joinToString ("")
}

 */