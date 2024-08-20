import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int start = 1; // 1부터 n까지의 정수를 오름차순으로 스택에 삽입하기 위한 시작점이 될 변수

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num >= start) { // num이 start보다 크거나 같은 경우
                // 스택에 정수를 오름차순으로 삽입한다.
                while(start<=num) {
                    stack.push(start);
                    sb.append("+").append("\n"); // 정수를 삽입할 때마다 +가 출력된다.
                    start++; // 오름차순으로 정수를 삽입해야 하므로 시작점인 start를 1만큼 증가시킨다.
                }
                stack.pop(); // 둘이 같아진 순간 스택에서 해당 정수를 스택에서 삭제한다.
                sb.append("-").append("\n"); // 정수를 삭제할 때마다 -가 출력된다.
            } else { // num이 start보다 작은 경우
                // 스택 최상단에 있는 정수와 num이 같다면 스택에서 삭제를 한다.
                if(stack.peek() == num) {
                    stack.pop();
                    sb.append("-").append("\n"); // 정수를 삭제할 때마다 -가 출력된다.
                } else { // 다르다면 NO를 출력하고 즉시 반복분을 종료한다.
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
