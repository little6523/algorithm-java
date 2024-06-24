import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(main.solution(n));
        br.close();

    }
    public int solution(int n) {
        int[] arr = new int[10];
        int max = 0;

        while(n>0){
            int tmp = n%10;

            if(tmp==6||tmp==9){
                if(arr[6]<arr[9]) arr[6]++;
                else arr[9]++;
            }
            else arr[tmp]++;
            n/=10;
        }

        for(int i : arr){
            max = Math.max(max,i);
        }

        return max;
    }
}
