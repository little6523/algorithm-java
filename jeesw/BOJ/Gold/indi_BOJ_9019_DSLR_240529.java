// 처음 시도한 코드

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());

//        for (int test_case = 0; test_case < T; test_case++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String A = validate(st.nextToken());
//            String B = validate(st.nextToken());
//            System.out.println(bfs(A, B));
//        }
//    }

//    static String bfs(String a, String b) {
//        Queue<Pair> q = new LinkedList<>();
//        q.offer(new Pair(a, ""));

//        while (!q.isEmpty()) {
//            Pair curr = q.poll();
//            String s = curr.first;
//            String ret = curr.second;

//            if (s.equals(b)) return ret;

//            String s1 = funcD(s);
//            String s2 = funcS(s);
//            String s3 = funcL(s);
//            String s4 = funcR(s);

//            q.offer(new Pair(s1, ret + "D"));
//            q.offer(new Pair(s2, ret + "S"));
//            q.offer(new Pair(s3, ret + "L"));
//            q.offer(new Pair(s4, ret + "R"));
//        }

//        return "";
//    }

//    static String validate(String n) {
//        StringBuilder sb = new StringBuilder();
//        switch (n.length()) {
//            case 1:
//                sb.append("000").append(n);
//                break;
//            case 2:
//                sb.append("00").append(n);
//                break;
//            case 3:
//                sb.append("0").append(n);
//                break;
//            default:
//                sb.append(n);
//                break;
//        }
//        return sb.toString();
//    }

//    static String funcD(String n) {
//        int number = Integer.parseInt(n);
//        number = (number * 2 < 10000) ? number * 2 : (number * 2) % 10000;
//        return validate(String.valueOf(number));
//    }

//    static String funcS(String n) {
//        int number = Integer.parseInt(n);
//        number = (number == 0) ? 9999 : number - 1;
//        return validate(String.valueOf(number));
//    }

//    static String funcL(String n) {
//        return validate(n.substring(1, 4) + n.charAt(0));
//    }

//    static String funcR(String n) {
//        return validate(n.charAt(3) + n.substring(0, 3));
//    }

//    static class Pair {
//        String first;
//        String second;

//        Pair(String first, String second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
// }




// 1.string을 int로, 2. 중복 검색 지우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
   int num;
   String op;

   Pair(int num, String op) {
       this.num = num;
       this.op = op;
   }
}

public class Main {
   static int A, B;
   static boolean[] visited = new boolean[10000];

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());

       for (int test_case = 0; test_case < T; test_case++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           A = Integer.parseInt(st.nextToken());
           B = Integer.parseInt(st.nextToken());
           bfs();
           visited = new boolean[10000];
       }
   }

   static void bfs() {
       Queue<Pair> q = new LinkedList<>();
       q.offer(new Pair(A, ""));
       visited[A] = true;

       while (!q.isEmpty()) {
           Pair curr = q.poll();
           int num = curr.num;
           String op = curr.op;

           if (num == B) {
               System.out.println(op);
               return;
           }

           int D = (num * 2) % 10000;
           int S = (num == 0) ? 9999 : num - 1;
           int L = (num % 1000) * 10 + num / 1000;
           int R = (num % 10) * 1000 + num / 10;

           if (!visited[D]) {
               q.offer(new Pair(D, op + "D"));
               visited[D] = true;
           }
           if (!visited[S]) {
               q.offer(new Pair(S, op + "S"));
               visited[S] = true;
           }
           if (!visited[L]) {
               q.offer(new Pair(L, op + "L"));
               visited[L] = true;
           }
           if (!visited[R]) {
               q.offer(new Pair(R, op + "R"));
               visited[R] = true;
           }
       }
   }
}