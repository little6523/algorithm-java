import java.util.*;

class Solution {
    public String solution(String n_str) {

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        // 큐에 값 insert
        for (int i = 0; i < n_str.length(); i++) {
            queue.add(n_str.charAt(i));
        }

        while (true) {
            if (queue.peek() != '0') {
                break;
            }
            queue.remove();
        }

        // 큐가 empty가 될까지 꺼내서 문자열 완성
        while (!queue.isEmpty()) {
            sb.append(queue.remove());
        }

        return sb.toString();
    }
}