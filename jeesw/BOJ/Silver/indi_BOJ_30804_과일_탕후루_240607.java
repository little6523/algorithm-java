import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Pair> v = new ArrayList<>();
        int prev = 0;
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            if (prev == tmp) {
                v.get(v.size() - 1).second++;
            } else {
                v.add(new Pair(tmp, 1));
            }

            prev = tmp;
        }

        if (v.size() == 1) {
            result = v.get(0).second;
        } else if (v.size() == 2) {
            result = v.get(0).second + v.get(1).second;
        } else {
            for (int i = 0; i < v.size() - 1; i++) {
                int v_max = 0;
                int[] kind = {0, 0};
                for (int j = i; j < v.size(); j++) {
                    if (kind[0] == 0 || kind[0] == v.get(j).first) {
                        kind[0] = v.get(j).first;
                    } else if (kind[1] == 0 || kind[1] == v.get(j).first) {
                        kind[1] = v.get(j).first;
                    } else {
                        break;
                    }

                    v_max += v.get(j).second;
                    i = j - 1;
                }
                result = Math.max(result, v_max);
            }
        }

        System.out.println(result);
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}