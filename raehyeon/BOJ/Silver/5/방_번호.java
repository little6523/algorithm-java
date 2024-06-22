import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] arr = new int[9];
        int count = 0;

        for(int i=0; i<num.length(); i++) {
            int n = Character.getNumericValue(num.charAt(i));
            if(n == 6 || n == 9) {
                count++;
                if(count % 2 == 1) {
                    arr[6]++;
                }
            } else {
                arr[n]++;
            }
        }

        Arrays.sort(arr);
        System.out.println(arr[8]);
    }
}
