import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            String str = br.readLine();

            for(int j=0; j<str.length(); j++) {
                switch(str.charAt(j)) {
                    case '<':
                        if(iterator.hasPrevious()) {
                            iterator.previous(); // 커서의 위치를 역방향으로
                        }
                        break;

                    case '>':
                        if(iterator.hasNext()) {
                            iterator.next(); // 커서의 위치를 순방향으로
                        }
                        break;

                    case '-':
                        if(iterator.hasPrevious()) {
                            iterator.previous(); // 커서의 위치를 역방향으로
                            iterator.remove();
                        }
                        break;

                    default:
                        iterator.add(str.charAt(j));
                        break;
                }
            }

            for(char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
