package Programmers;

import java.util.*;

class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;

        // 보조 컨테이너 벨트, 박스 넘버, order 인덱스 초기화
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        int i = 0;

        while (true) {

            // 기사가 원하는 박스가 나올 때 까지 스택에 push
            while (box <= order[i]) {
                stack.push(box++);
            }

            // 스택의 맨 위의 상자가 기사가 원하는 것이면 상자를 건네줌
            while (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                i++;
            }

            // 상자를 모두 건네줬거나 스택에서 더 이상 상자를 건넬 수가 없으면 종료
            // 처음에 기사가 원하는 상자를 건네줄 때 까지 1번부터 스택에 넣었다
            // 즉, 다음으로 기사가 원하는게 스택의 맨 위보다 작다면 스택의 중간 어디쯤에 있는 것이므로 꺼낼 수 없다.
            if (i == order.length || (!stack.isEmpty() && stack.peek() > order[i])) {
                break;
            }
        }

        answer = i;

        return answer;
    }
}
