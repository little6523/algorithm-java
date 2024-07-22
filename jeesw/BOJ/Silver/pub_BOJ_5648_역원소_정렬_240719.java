import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Long> v = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            long tmp = scanner.nextLong();
            String str = Long.toString(tmp);
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            v.add(Long.parseLong(sb.toString()));
        }
        
        Collections.sort(v);
        
        for (Long num : v) {
            System.out.println(num);
        }
        
        scanner.close();
    }
}