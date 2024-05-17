import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        //곱한 값을 String 타입의 배열로 만듦
        String[] str = String.valueOf(a*b*c).split("");
        int[] arr = new int[10];
        //곱한 값의 각 숫자를 인덱스로 하여 개수 증가
        for(int i=0; i<str.length; i++){
            arr[Integer.parseInt(str[i])]++;
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        br.close();
    }
}
