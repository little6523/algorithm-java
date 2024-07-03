from collections import deque
n = int(input())
"""
arr = deque()
for i in range(n):
    arr.append(i+1)
"""
arr = deque(i for i in range(1, n+1))
while len(arr)>1:
    arr.popleft()
    arr.append(arr.popleft())

print(arr[0])

"""
# 시간촐과
import sys
n = int(sys.stdin.readline())
arr = []
for i in range(n):
    arr.append(i+1)

while len(arr)>1:
    arr.pop(0)
    arr.append(arr.pop(0))

print(arr.pop(0))
"""

"""
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        while(q.size()>1){
            q.poll();
            q.add(q.poll());
        }
        br.close();
        System.out.println(q.poll());
    }
}
"""
