import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] canvas = new int[100][100]; // 도화지
        int coloredPaper = Integer.parseInt(br.readLine()); // 색종이 개수
        int area = 0; // 영역 계산

        for(int i = 0; i < coloredPaper; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    if(canvas[j][k] == 0) {
                        area += 1;
                        canvas[j][k] = 1;
                    }
                }
            }
        }

        System.out.println(area);
        br.close();
    }
}
