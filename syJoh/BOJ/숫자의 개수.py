a = int(input())
b = int(input())
c = int(input())
arr = list(str(a*b*c))

for i in range(10):
    print(arr.count(str(i)))

"""
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        String[] tmp = String.valueOf(a*b*c).split("");
        for(int i=0; i<tmp.length; i++){
            arr[Integer.parseInt(tmp[i])]++;
        }
        for(int num: arr){
            System.out.println(num);
        }
        br.close();
    }
}
"""
