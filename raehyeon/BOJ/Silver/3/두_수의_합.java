import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;

        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= x) {
                for(int j=i+1; j<arr.length; j++) {
                    int num = x - arr[i];
                    if(arr[j] == num) {
                        count++;
                        break;
                    }
                }
            } else {
                break;
            }
        }

        System.out.println(count);
        br.close();
    }
}
