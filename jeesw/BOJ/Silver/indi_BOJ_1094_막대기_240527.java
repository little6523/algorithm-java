import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int X = sc.nextInt();
       int result = 0;

       String bin = Integer.toBinaryString(X);

       while (bin.length() < 7) {
           bin = "0" + bin;
       }

       for (int i = 0; i < 7; i++) {
           if (bin.charAt(i) == '1') {
               result++;
           }
       }

       System.out.println(result);
   }
}