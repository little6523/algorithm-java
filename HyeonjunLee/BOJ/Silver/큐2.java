package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Queue queue = new Queue();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String command;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch (command) {
                case "push": {
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                }

                case "pop": {
                    queue.pop();
                    break;
                }

                case "size": {
                    queue.size();
                    break;
                }

                case "empty": {
                    queue.empty();
                    break;
                }

                case "front": {
                    queue.front();
                    break;
                }

                case "back": {
                    queue.back();
                }
            }
        }
        queue.print();
    }
}

class Queue {

    List<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    void push(int x) {
        queue.add(x);
    }

    void pop() {
        if (queue.size() == 0) {
            sb.append("-1\n");
            return;
        }
        sb.append(queue.get(0)).append("\n");
        queue.remove(0);
    }

    void size() {
        sb.append(queue.size()).append("\n");
    }

    void empty() {
        if (queue.size() == 0) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    void front() {
        if (queue.size() == 0) {
            sb.append("-1\n");
            return;
        }
        sb.append(queue.get(0)).append("\n");
    }

    void back() {
        if (queue.size() == 0) {
            sb.append("-1\n");
            return;
        }
        sb.append(queue.get(queue.size() - 1)).append("\n");
    }

    void print() {
        System.out.println(sb);
    }
}
