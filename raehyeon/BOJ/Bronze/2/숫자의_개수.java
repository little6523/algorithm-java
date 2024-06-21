import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String s = String.valueOf(a * b * c);
        int[] arr = new int[10];
        
        for(int i=0; i<s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            arr[num] += 1;
        }
        
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
