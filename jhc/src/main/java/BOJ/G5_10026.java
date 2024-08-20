package BOJ;

import java.util.Scanner;

public class G5_10026 {

  private static final int[] MV_X = {1, -1, 0, 0};
  private static final int[] MV_Y = {0, 0, 1, -1};


  static void bfs(char[][] map, boolean[][] visits, int x, int y, char color, char color2) {
    visits[y][x] = true;
    for (int i = 0; i < 4; i++) {
      int x_idx = x + MV_X[i];
      int y_idx = y + MV_Y[i];
      if (x_idx >= 0 && x_idx < map[0].length && y_idx >= 0 && y_idx < map.length && (
          map[y_idx][x_idx] == color || map[y_idx][x_idx] == color2) && !visits[y_idx][x_idx]) {
        visits[y_idx][x_idx] = true;
        bfs(map, visits, x_idx, y_idx, color, color2);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();
    char[][] chars = new char[T][T];
    boolean[][] noIsVisits = new boolean[T][T];
    boolean[][] yesIsVisits = new boolean[T][T];
    for (int i = 0; i < T; i++) {
      char[] line = sc.nextLine().toCharArray();
      System.arraycopy(line, 0, chars[i], 0, T);
    }

    int no = 0;
    for (int i = 0; i < T; i++) {
      for (int j = 0; j < T; j++) {
        if (noIsVisits[i][j]) {
          continue;
        }
        no++;
        bfs(chars, noIsVisits, j, i, chars[i][j], chars[i][j]);
      }
    }
    System.out.print(no);
    int yes = 0;
    for (int i = 0; i < T; i++) {
      for (int j = 0; j < T; j++) {
        if (yesIsVisits[i][j]) {
          continue;
        }
        yes++;
        char color = chars[i][j] == 'B' ? 'B' : 'R';
        char color2 = chars[i][j] == 'B' ? 'B' : 'G';
        bfs(chars, yesIsVisits, j, i, color, color2);
      }
    }
    System.out.println(" " + yes);
  }
}
