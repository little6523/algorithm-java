// for 만 아는 자린이인가.... for만 떠오른다
class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        for (int i = 0; i < k; i++) {
            answer += my_string;
        }
        return answer;
    }
}

// 다른분이 푼 방법 String.repeat(num) 와우... 속도도 빠르고 너무 쉽고 간결하다.
class Solution {
    public String solution(String my_string, int k) {
        return my_string.repeat(k);
    }
}
