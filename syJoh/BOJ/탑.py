import sys
input = sys.stdin.readline

n = int(input())
toplist = list(map(int, input().split()))
answer = [0]*n
stack = []

for i in range(len(toplist)):
    while stack: #stack이 비어있지 않은 동안 실행
        if stack[-1][1] > toplist[i]:
            answer[i] = stack[-1][0] + 1 #인덱스 1부터 시작
            break
        else:
            stack.pop()
    stack.append((i, toplist[i])) #현재 탑의 인덱스와 높이 추가
print(*answer)

"""
import java.util.*;
import java.io.*;

class Pair{
    int num;
    int idx;
    Pair(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Pair> stack = new Stack<>();

        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                Pair cur = stack.peek();
                if(cur.num >= num){
                    System.out.print(cur.idx+" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.add(new Pair(num, i));
        }
    }
}

"""
