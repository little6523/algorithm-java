import java.util.*;
import java.io.*;

public class Main {
    static int N, C;
    static Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.putIfAbsent(tmp, new Pair<>(0, 0));
            Pair<Integer, Integer> p = map.get(tmp);
            map.put(tmp, new Pair<>(p.first + 1, p.second == 0 ? i : p.second));
        }

        List<Map.Entry<Integer, Pair<Integer, Integer>>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (a.getValue().first.equals(b.getValue().first))
                return a.getValue().second.compareTo(b.getValue().second);
            return b.getValue().first.compareTo(a.getValue().first);
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : list) {
            for (int j = 0; j < entry.getValue().first; j++) {
                sb.append(entry.getKey()).append(" ");
            }
        }

        System.out.println(sb);
    }
}