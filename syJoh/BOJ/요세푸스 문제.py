from collections import deque

n, k = map(int, input().split())
q = deque(range(1, n + 1))

result = []
idx = 1

while len(q) > 0:
    if idx == k:
        result.append(q.popleft())
        idx = 1
    else:
        q.append(q.popleft())
        idx += 1

print("<" + ", ".join(map(str, result)) + ">")
"""
#시간초과
import queue
n, k = map(int, input().split())
print(n, k)

q = queue.Queue()
for i in range(1, n+1):
    q.put(i)

result = []
idx = 1

while q.qsize()>0:
    if idx == k:
        result.append(q.get())
        idx = 1
    else:
        q.put(q.get())
        idx += 1
#result 요소들을 문자열로 변환 후, ','로 연결하여 출력
print("<" + ",".join(map(str, result)) + ">")
"""
"""
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        int idx = 1;
        while(q.size()>1) {
            if (idx == k) {
                sb.append(q.poll()).append(", ");
                idx = 1;
            } else {
                q.add(q.poll());
                idx++;
            }
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
"""
