package Elice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {
    static List<Integer> result = new ArrayList<>(); // 결과
    static int[] arr; // 숫자들을 분리해서 담아 놓는 배열
    static boolean[] visited; // 어떤 숫자를 방문했는지 확인하는 배열
    static int[] output; // 숫자 조합 하나를 찾았을 때 임시로 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        // 각 자리의 숫자 분리
        arr = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            arr[i] = (int) n.charAt(i) - '0';
        }

        // 방문 배열, 임시로 조합을 저장하는 배열 초기화
        visited = new boolean[arr.length];
        output = new int[arr.length];

        // 순열 수행
        permutation(arr, 0);

        // 결과의 값들이 순서대로가 아닌 뒤죽박죽 섞여있으므로 정렬 수행
        Collections.sort(result);

        // 원래의 수보다 커지면 바로 해당 값을 출력하고 종료
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) > Integer.parseInt(n)) {
                System.out.println(result.get(i));
                break;
            }
        }
    }

    // 순열 메소드
    static void permutation(int[] arr, int depth) {
        
        // 임시 배열에 숫자를 모두 채우면 n자리의 숫자로 다시 변환해서 결과에 저장
        if (depth == arr.length) {
            result.add(arrayToNumber(output));
            return;
        }

        // 자리수만큼 반복문 수행
        for (int i = 0; i < arr.length; i++) {
            
            // 만약 임시 배열에 넣지 않은 숫자면
            if (!visited[i]) {
                
                // 방문 처리 후 임시 배열에 숫자 삽입
                visited[i] = true;
                output[depth] = arr[i];
                
                // 임시 배열에 숫자를 채우고, 다음 숫자를 다시 채우기 위해 재귀 수행
                permutation(arr, depth + 1);
                
                // 하나의 조합을 만들었다면, 직전에 방문했던 숫자를 미방문으로 변경
                visited[i] = false;
            }
        }
    }

    // 임시 배열의 숫자를 n자리의 숫자로 변환해주는 메소드
    static int arrayToNumber(int[] arr) {

        int result = 0;
        int tenSquare = 1;

        for (int i = arr.length - 1 ; i > -1 ; i--) {
            result += arr[i] * tenSquare;
            tenSquare *= 10;
        }

        return result;
    }
}
