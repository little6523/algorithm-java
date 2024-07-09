package Alice;

import java.util.Arrays;
import java.util.Scanner;

public class 정리정돈을_좋아하는_K씨 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    while (n-- > 0) {
      arr[arr.length - n - 1] = sc.nextInt();
    }
    while (m-- > 0) {
      int i = sc.nextInt() - 1;
      int j = sc.nextInt() - 1;
      int k = sc.nextInt() - 1;
      int[] newArr = new int[j - i + 1];
      for (int idx = 0; idx < j - i + 1; idx++) {
        newArr[idx] = arr[i + idx];
      }
      Arrays.sort(newArr);
      System.out.println(newArr[k]);
    }
  }
}
