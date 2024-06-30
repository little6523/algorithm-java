import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=n; i++) {
            int topHeight = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않은 경우
            while(!stack.isEmpty()) {
                // 스택 최상단에 위치한 탑의 높이보다 입력한 탑의 높이가 더 큰 경우
                if(topHeight < stack.peek()[1]) {
                    String s = String.valueOf(stack.peek()[0]);
                    sb.append(s).append(" ");
                    break;
                }
                // 입력한 탑의 높이보다 스택 최상단에 위치한 탑의 높이가 더 큰 경우
                stack.pop();
            }

            // 스택이 비어있는 경우
            if(stack.isEmpty()){
                sb.append("0").append(" ");
            }

            // 스택에 탑의 번호와 높이를 저장한다.
            stack.push(new int[]{i, topHeight});
        }

        System.out.println(sb);
        br.close();
    }
}

/* 출력 초과 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=n; i++) {
            int topHeight = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                sb.append("0").append(" ");
            } else {
                if(topHeight > stack.peek()[1]){
                    stack.pop();
                    if(stack.isEmpty()){
                        sb.append("0").append(" ");
                    } else {
                        String s = String.valueOf(stack.peek()[0]);
                        sb.append(s).append(" ");
                    }
                } else {
                    String s = String.valueOf(stack.peek()[0]);
                    sb.append(s).append(" ");
                }
            }

            stack.push(new int[]{i, topHeight});
        }

        System.out.println(sb);
        br.close();
    }
}
*/
