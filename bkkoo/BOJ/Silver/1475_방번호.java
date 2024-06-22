import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();
        int[] intarr = new int[9];
        int answer = 0;

        for (char c : inputs)
        {
            int temp = c- '0';//Integer.parseInt(str);
            if(temp != 9 && temp != 6)
            {
                answer = Math.max(answer, ++intarr[temp]);
            }
            else
            {
                answer = Math.max(answer, (int)Math.ceil(++intarr[6] / (float)2));
            }
        }
        System.out.println(answer);

    }
}
