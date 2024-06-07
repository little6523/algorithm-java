// 충격과 공포의 나의 풀이법
// 대현님이 보고 놀라셨다....

class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        String str1 = Integer.toString(a) + Integer.toString(b);
        String str2 = Integer.toString(b) + Integer.toString(a);

        int ab = Integer.parseInt(str1);
        int ba = Integer.parseInt(str2);

        if(ab > ba){
            answer = ab;
        } else if(ab < ba){
            answer = ba;
        } else {
            answer = ab;
        }

        return answer;
    }
}


// 초간단 다른분의 풀이법.... Math.max라.... 처음들어본다 그거만 문제가 아니라
// 타입 변환도 잘 모른다
// 이걸 보면 왜 놀랐는지 알겠다....ㅋㅋㅋㅋㅋㅋㅋ

class Solution {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt(a + "" + b), Integer.parseInt(b + "" + a));
    }
}
