
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        solution(a,b,c);

    }
    public static void solution(int a, int b, int c){
        String str = String.valueOf(a*b*c);
        int[] counts = {0,0,0,0,0,0,0,0,0,0};

        int num = 0;
        for(int i =0; i< str.length(); i++){

            num = Integer.parseInt(String.valueOf(str.charAt(i)));
            counts[num] += 1;
        }

        for(int n : counts){
            System.out.println(n);
        }
    }
}
