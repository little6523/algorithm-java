import sys
# 입력이 끝날 때까지(Ctrl+D) 입력을 받을 수 있음
input = sys.stdin.read

n, *nums = input().split()
# print(n, nums)
# 10 ['5', '2233', '1601', '90100', '13009', '802', '50000000', '301', '7654321', '210']
for i in range(int(n)):
    nums[i] = int(nums[i][::-1]) #문자열 슬라이싱 기법 역순
nums.sort()
for i in nums:
  print(i)

"""
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();
        String str = "";
        String rev = "";
        while(list.size()<n){
            while(st.hasMoreTokens()){
                str = st.nextToken();
                rev = "";
                for(int j=str.length()-1; j>=0; j--){
                    rev += str.charAt(j);
                }
                list.add(Long.parseLong(rev));//10^12 이하
            }
            if(list.size()<n) {
                st = new StringTokenizer(br.readLine());
            }
        }
        Collections.sort(list);
        for(long num: list){
            bw.write(num+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
"""
