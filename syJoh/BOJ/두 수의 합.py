import sys
n=int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
x = int(sys.stdin.readline())
arr.sort()
answer=0
left, right = 0, n-1

while left<right:
    tmp = arr[left] + arr[right]
    if tmp==x:
        answer+=1
        left+=1
    elif tmp<x:
        left+=1
    else:
        right-=1
print(answer)

"""
# 시간초과
import sys
n=int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
x = int(sys.stdin.readline())
answer=0

for i in range(n-1):
    for j in range(i+1, n):
        if arr[i]+arr[j]==x:
            answer+=1
            break
print(answer)
"""

"""
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j]==x){
                    answer++;
                    break;
                }
            }
        }
        br.close();
        System.out.println(answer);
    }
}
"""
