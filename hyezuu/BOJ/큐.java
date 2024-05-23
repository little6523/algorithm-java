import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        System.out.print(T.queue(strings));
    }

    public String queue(String[] strings) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();

        for(String str : strings) {
            StringTokenizer stk = new StringTokenizer(str);
            String tmp = stk.nextToken();
            switch (tmp) {
                case "push" : {
                    list.add(Integer.parseInt(stk.nextToken()));
                    break;
                }
                case "size" : {
                    sb.append(list.size()).append("\n");
                    break;
                }
                case "empty" : {
                    sb.append(list.isEmpty() ? 1: 0).append("\n");
                    break;
                }
                case "front" : {
                    sb.append(list.isEmpty() ? -1: list.get(0)).append("\n");
                    break;
                }
                case "pop" : {
                    sb.append(list.isEmpty() ? -1: list.removeFirst()).append("\n");
                    break;
                }
                case "back" :{
                    sb.append(list.isEmpty() ? -1: list.get(list.size() - 1)).append("\n");
                    break;
                }
            }
        }
        return sb.toString();
    }
}

