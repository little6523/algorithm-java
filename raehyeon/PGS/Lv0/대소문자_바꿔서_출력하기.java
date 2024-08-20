import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        
        for(int i=0; i<st.length(); i++) {
            char c = st.charAt(i);
            
            if(c >= 65 && c <= 90) {
                c += 32;
                System.out.print(c);
            } else if(c >= 97 && c <= 122) {
                c -= 32;
                System.out.print(c);
            }
        }
    }
}
