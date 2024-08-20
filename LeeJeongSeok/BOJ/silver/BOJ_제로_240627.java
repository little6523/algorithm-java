
/**
 * [요구사항]
 * 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
 * 재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다. 재민이를 도와주자
 *
 * K개의 정수가 입력으로 들어올 때 K개의 정수의 합을 구하는 문제이다.
 * 하지만, 0이 들어오면 가장 최근에 입력되었던 정수는 합산하지 않는다.
 * 이점을 유의해서 풀어야한다.
 *
 * [풀이 및 상태 전이도]
 *
 * K = 4
 * arr = [3, 0, 4, 0]
 *
 * 이 문제는 삽입 삭제가 빈번하게 일어나는 문제이면서 동시에 최근에 입력했던 값을 기준으로 연산을 해야하는 문제이다.
 * 삽입 삭제만 발생할 경우 LinkedList 계열의 자료구조를 사용하면 좋겠지만,
 * 최근에 입력했던 값을 기준으로 연산해야하는 것이 문제의 키포인트이기 때문에
 * 스택을 사용할 예정이다.
 *
 * 초기 세팅
 * K = 4
 * input = [3, 0, 4, 0]
 * stack = []
 *
 * 반복 1회차
 * K = 4
 * input = [3, 0, 4, 0]
 * 현재 원소 = 3
 * stack = [3]
 *
 * 반복 2회차
 * K = 4
 * input = [3, 0, 4, 0]
 * 현재 원소 = 0
 * stack = [] -> 0이기 때문에 제거
 *
 * 반복 3회차
 * K = 4
 * input = [3, 0, 4, 0]
 * 현재 원소 = 4
 * stack = [4]
 *
 * 반복 4회차
 * K = 4
 * input = [3, 0, 4, 0]
 * 현재 원소 = 0
 * stack = [] -> 0이기 때문에 제거
 *
 * 반복 종료
 * sum = 0
 */

import java.util.*;
import java.io.*;

public class Main {

    static int K, sum;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int element = Integer.parseInt(br.readLine());

            if (element != 0) {
                stack.push(element);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}