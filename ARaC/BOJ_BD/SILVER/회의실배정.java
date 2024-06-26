import java.io.*;
import javax.security.sasl.SaslClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arrays = new int[n][2];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            arrays[i][0] = Integer.parseInt(st.nextToken());
            arrays[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();
//두번째 원소로 오름차순하기
        Arrays.sort(arrays, (num1, num2) -> {
            return num1[1] != num2[1] ? num1[1] - num2[1] : num1[0] - num2[0];
        });

        int count = 0;
        int prev_end_time = 0;

        for(int i = 0;i<n; i++){
            if(prev_end_time <= arrays[i][0]){
                prev_end_time = arrays[i][1];
                count++;
            }
        }
        System.out.println(count);
    }

}
/*
def solution(lst) :
    #두번째 원소로 오름차순하기
    lst.sort(key=lambda x:(x[1],x[0]))
    point = lst[0][1]
    cnt = 1
  #인덱스 1부터 순회
    for start, end in lst[1:] :
        if start >= point :
            point = end
            cnt += 1

    return cnt
if __name__ == "__main__" :
    n = int(input())
    lst = []
    while n > 0 :
        a,b = map(int, input().split())
        lst.append((a,b))
        n -= 1
    print(solution(lst))

 */
