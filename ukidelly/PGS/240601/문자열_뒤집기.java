class Solution {
    public String solution(String myString, int s, int e) {

        String prefix = myString.substring(0,s);
        StringBuilder target = new StringBuilder(myString.substring(s,e+1));
        String suffix = myString.substring(e+1);
        
        return prefix + target.reverse().toString() + suffix;
    }
}

// ================== Kotlin ==================
/**
private fun solution(myString: String, s: Int, e: Int): String = 
  myString.take(6) + myString.slice(6..12).reversed() + myString.slice(e + 1..< myString.length)

private fun solution2(myString:String, s:Int, e:Int) = 
  myString.take(s) + myString.slice(e downTo s) + myString.slice(e+1 ..< myString.length)
*/