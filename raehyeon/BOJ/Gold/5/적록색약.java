import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] color1, color2;
    static boolean[][] check1, check2;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int countRed, countGreen, countBlue;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        color1 = new char[N][N];
        color2 = new char[N][N];
        check1 = new boolean[N][N];
        check2 = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                color1[i][j] = str.charAt(j);

                if(str.charAt(j) == 'G') {
                    color2[i][j] = 'R';
                } else {
                    color2[i][j] = str.charAt(j);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(color1[i][j] == 'R') {
                    if(!check1[i][j]) {
                        bfs1(i, j, color1[i][j]);
                        countRed++;
                    }
                } else if(color1[i][j] == 'G') {
                    if(!check1[i][j]) {
                        bfs1(i, j, color1[i][j]);
                        countGreen++;
                    }
                } else {
                    if(!check1[i][j]) {
                        bfs1(i, j, color1[i][j]);
                        countBlue++;
                    }
                }
            }
        }

        int sum = countRed + countGreen + countBlue;
        sb.append(sum).append(" ");
        countRed = 0;
        countBlue = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(color2[i][j] == 'R') {
                    if(!check2[i][j]) {
                        bfs2(i, j, color2[i][j]);
                        countRed++;
                    }
                } else {
                    if(!check2[i][j]) {
                        bfs2(i, j, color2[i][j]);
                        countBlue++;
                    }
                }
            }
        }

        sum = countRed + countBlue;
        sb.append(sum);
        System.out.println(sb);
    }

    public static void bfs1(int i, int j, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()) {
            i = queue.peek()[0];
            j = queue.peek()[1];
            check1[i][j] = true;
            queue.poll();

            for(int k = 0; k < 4; k++) {
                int cx = i + dx[k];
                int cy = j + dy[k];

                if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
                    if (!check1[cx][cy]) {
                        if(color1[cx][cy] == color) {
                            queue.offer(new int[] {cx, cy});
                            check1[cx][cy] = true;
                        }
                    }
                }
            }
        }
    }

    public static void bfs2(int i, int j, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()) {
            i = queue.peek()[0];
            j = queue.peek()[1];
            check2[i][j] = true;
            queue.poll();

            for(int k = 0; k < 4; k++) {
                int cx = i + dx[k];
                int cy = j + dy[k];

                if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
                    if (!check2[cx][cy]) {
                        if(color2[cx][cy] == color) {
                            queue.offer(new int[] {cx, cy});
                            check2[cx][cy] = true;
                        }
                    }
                }
            }
        }
    }
}
