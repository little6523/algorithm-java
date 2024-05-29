import java.io.*;
import java.util.*;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNum; i++) {

            bw.write(KeyLogger(br.readLine()) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static StringBuilder KeyLogger(String input)
    {
        List<Character> result = new LinkedList<>();
        ListIterator<Character> iterator = result.listIterator();


        for (char current : input.toCharArray()) {
            switch (current) {
                case '<':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case '>':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case '-':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                default:
                    iterator.add(current);
                    break;

            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : result) {
            builder.append(c);
        }

        return builder;
    }
}