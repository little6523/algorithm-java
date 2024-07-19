import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list = new ArrayList<>();
        StringBuilder sb;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while (n > 0) {
            while(st.hasMoreTokens()) {
                String tmp = st.nextToken();
                if(tmp.length() >= 12) continue;
                sb = new StringBuilder(tmp).reverse();
                list.add(Long.parseLong(sb.toString()));
                n--;
            }
            if(n > 0) st = new StringTokenizer(br.readLine());
        }

        Collections.sort(list);
        for (long i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
