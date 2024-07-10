package BOJ;

import java.util.Scanner;

public class S2_1012 {

  private static final int[] MV_X = {1, -1, 0, 0};
  private static final int[] MV_Y = {0, 0, 1, -1};

  static void bfs(boolean[][] map, boolean[][] visits, int x, int y) {
    visits[y][x] = true;
    for (int i = 0; i < 4; i++) {
      int x_idx = x + MV_X[i];
      int y_idx = y + MV_Y[i];
      if (x_idx >= 0 && x_idx < map[0].length && y_idx >= 0 && y_idx < map.length && map[y_idx][x_idx] && !visits[y_idx][x_idx]) {
        visits[y_idx][x_idx] = true;
        bfs(map, visits, x_idx, y_idx);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    while (T-- > 0) {
      int m = scanner.nextInt();
      int n = scanner.nextInt();
      boolean[][] map = new boolean[n][m];
      boolean[][] visits = new boolean[n][m];
      int k = scanner.nextInt();
      int res = 0;
      while (k-- > 0) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        map[y][x] = true;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (visits[i][j] || !map[i][j]) {
            visits[i][j] = true;
            continue;
          }
          res++;
          bfs(map, visits, j, i);
        }
      }
      System.out.println(res);
    }
  }
}
