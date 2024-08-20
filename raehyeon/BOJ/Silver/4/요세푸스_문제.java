import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // n명의 사람
        int k = Integer.parseInt(st.nextToken()); // k번째 사람

        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        sb.append('<');
        // 리스트가 다 비워질 때까지 반복
        while(!list.isEmpty()) {
            for(int i=0; i<k; i++) {
                if(i == k-1) { // i 가 k-1과 같다면 제거 후 반환된 값을 문자열에 붙인다.
                    if(list.size() == 1) {
                        sb.append(list.remove()); // 마지막으로 제거할 때는 쉼표를 붙이지 않는다.
                    } else {
                        sb.append(list.remove() + ", ");
                    }
                } else { // i 가 k-1과 같지 않다면 제거 후 맨 뒤에 삽입한다.
                    list.add(list.remove());
                }
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}
