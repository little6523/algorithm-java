package Alice;

import java.util.*;



class 목표량 {
  static boolean check(int[] cnt, int n) {
    cnt = cnt.clone();
    while (n > 0) {
      cnt[n%10]--;
      n/=10;
    }
    for (int i = 0; i < 10; i++) {
      if (cnt[i] != 0) return false;
    }
    return true;
  }
  static int[] getCnt(int n) {
    int[] cnt = new int[10];
    while(n > 0) {
      cnt[n%10]++;
      n/=10;
    }
    return cnt;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input = Integer.parseInt(sc.nextLine());
    int[] cnt = getCnt(input);
    for (int i = input+1; i < 999_999; i++) {
      if (check(cnt, i)) {
        System.out.println(i);
        break;
      }
    }
  }
}