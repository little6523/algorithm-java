class Solution {
    public int solution(String myString, String isPrefix) {
        return myString.startsWith(isPrefix) ? 1 : 0;
    }
}

// ================== Kotlin ==================
/**
class Solution {
    fun solution(myString: String, isPrefix: String): Int = if (myString.startsWith(isPrefix)) 1 else 0
}
*/