import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        for (int i = 0; i < a.length(); i++){
            String b = "";
            char c = a.charAt(i);
            if(Character.isUpperCase(c)){
               b += Character.toLowerCase(c);
            } else {
                b += Character.toUpperCase(c);
            }
            System.out.print(b);
        }
    }
}
