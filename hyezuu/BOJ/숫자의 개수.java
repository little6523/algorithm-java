import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        for(int n : main.solution(a,b,c)){
            bw.write(n+"\n");
        }

        bw.flush();
        bw.close();
    }

    public int[] solution(int a, int b, int c) {
        int[] answer = new int[10];
        int result = a*b*c;

        while(result > 0) {
            answer[result%10]++;
            result/=10;
        }

        return answer;
    }
}

