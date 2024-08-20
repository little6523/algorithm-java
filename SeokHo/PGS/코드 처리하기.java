
// 나는 갱생의 여지가 있는 사람이었다....
// 모르는 코드가 나오면 꼭 확인하자.
// 같은 실수를 왜 계속 반복하는가
class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;

        for (int i = 0; i < code.length(); i++){
            if (code.charAt(i) == '1') {
                if (mode == 0){
                    mode = 1;
                }else {
                    mode = 0;
                }
                continue;
            }
            if (mode == 0 && i % 2 == 0) {
                answer.append(code.charAt(i));
            }
            if (mode == 1 && i % 2 == 1) {
                answer.append(code.charAt(i));
            }
        }

        if (answer.toString().isEmpty()) {
            answer.append("EMPTY");
        }

        return answer.toString();
    }
}


// 다른 사람들 한 문제풀이 중에서 마음에 드는 것
// %나머지를 mode로 하다니 지니어스
// 삼항 연산자도 아주 깔끔스. 아주 좋았다잉 
class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }

            if (i % 2 == mode) {
                answer.append(current);
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}


