from collections import deque
import sys
input = sys.stdin.readline
t = int(input())
while t>0:
    p = input().strip() #수행할 함수
    n = int(input().strip()) #배열 개수
    arr = input().strip()
    q = deque(arr[1:-1].split(","))
    if n==0:
        q = []
    rcount = 0
    flag = True
    for i in p:
        if i == "R":
          rcount += 1
        elif i == "D":
          if len(q) == 0:
            flag = False
            break
          else:
            if rcount%2==0:
              q.popleft()
            else:
              q.pop()
    if flag:
        if rcount%2!=0 :
            q.reverse()
        print("["+",".join(list(q))+"]")
    else:
        print("error")
    t-=1
"""
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String[] pList = br.readLine().split("");//함수
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> q = new LinkedList<>();
            String str = br.readLine(); //배열 형태의 정수
            String[] arr = {};
            if(n!=0){
                arr = str.substring(1, str.length()-1).split(",");
            }
            for(int i=0; i<arr.length; i++){
                q.add(Integer.parseInt(arr[i]));
            }
            boolean isRotated = false;
            boolean flag = true;
            for(String p : pList){
                if(p.equals("R")){
                    isRotated = !isRotated;
                }else if(p.equals("D")){
                    if(q.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(isRotated){
                        q.pollLast();
                    }else{
                        q.pollFirst();
                    }
                }
            }
            if(flag){
                if(isRotated){ //홀수일 경우 회전
                    List<Integer> list = new ArrayList<>(q);
                    Collections.reverse(list);
                    q = new LinkedList<>(list);
                }
                sb.append("[");
                while(q.size()>1){
                    sb.append(q.poll()+",");
                }
                if(q.peek()!=null) {
                    sb.append(q.poll());
                }
                sb.append("]\n");
            }else{
                sb.append("error\n");
            }
            t--;
        }
        br.close();
        System.out.print(sb);
    }
}
"""
