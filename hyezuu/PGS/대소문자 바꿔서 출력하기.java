import java.util.Scanner;

public class Solution {
    public String solution(String str){
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()){
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        System.out.println(T.solution(str));
    }
}
