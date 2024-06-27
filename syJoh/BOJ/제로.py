import sys
k = int(sys.stdin.readline())
arr = []
answer = 0
for _ in range(k):
    num = int(sys.stdin.readline())
    if num!=0:
        arr.append(num)
        answer += num
    else:
        answer -= arr.pop()
print(answer)
"""
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        while(k>0){
            int num = Integer.parseInt(br.readLine());
            if(num!=0){
                answer += num;
                stack.push(num);
            }else{
                answer -= stack.peek();
                stack.pop();
            }
            k--;
        }
        br.close();
        System.out.println(answer);
    }
}
"""
