n = int(input())
stack = []
count = 1
answer = []
flag = True
for _ in range(n):
    num = int(input())
    #num 이하 숫자까지 스택에 넣기
    while count<=num:
        stack.append(count)
        answer.append("+")
        count += 1
    #num과 스택 가장 최근 숫자와 동일하면 제거
    if stack[-1] == num:
        stack.pop()
        answer.append("-")
    else:
        flag = False
        break

if flag == False:
    print("NO")
else:
    for i in answer:
        print(i)
"""
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        while(n>0){
            int num = Integer.parseInt(br.readLine());
            if(num>tmp){
                for(int i=tmp+1; i<=num; i++){ // 수열
                    stack.push(i);
                    sb.append("+\n");
                }
                tmp = num;
            }
            if(stack.peek()==num){
                stack.pop();
                sb.append("-\n");
            }
            n--;
        }
        if(!stack.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
        br.close();
    }
}

"""
