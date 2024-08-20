import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int X, a, b, sum;
        int sign;
        int n;
        
        X = scanner.nextInt();
        
        a = 1;
        b = 1;
        sum = 2;
        sign = 0;
        n = 1;
        
        for (int i = 1; i < X; i++) {
            if (n == X) {
                break;
            }
            
            sum++;
            
            if (sign == 0) {
                sign = 1;
            } else {
                sign = 0;
            }
            
            if (sign == 0) {
                a = sum - 1;
                b = 1;
            } else {
                a = 1;
                b = sum - 1;
            }
            
            n += 1;
            
            if (n == X) {
                break;
            }
            
            for (int j = 0; j < i; j++) {
                if (sign == 0) {
                    a--;
                    b++;
                    n += 1;
                } else {
                    a++;
                    b--;
                    n += 1;
                }
                
                if (n == X) {
                    break;
                }
            }
        }
        
        System.out.println(a + "/" + b);
        
        scanner.close();
    }
}