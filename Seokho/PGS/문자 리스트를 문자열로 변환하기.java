// 1번째 방법 for문
class Solution {
    public String solution(String[] arr) {
        String answer = "";
        for (int i=0; i < arr.length ; i++) {
            answer += arr[i];
        }
        return answer;
    }
}


// 2번째 방법 String.join (속도도 엄청 빠르고 간결한 방법.)
// 대현님의 조언으로 찾아본 방법.
class Solution {
    public String solution(String[] arr) {
        return String.join("", arr);
    }
}
