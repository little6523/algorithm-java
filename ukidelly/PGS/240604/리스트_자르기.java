import java.util.ArrayList;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Main m = new Main();

    System.out.println(Arrays.toString(m.solution(4, new int[]{1, 5, 2}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
  }

  public int[] solution(int n, int[] slicer, int[] numList) {
    int a = slicer[0], b = slicer[1], c = slicer[2]; // 오? 이건 되네

    int[] answer = {};
    switch (n) {
      case 1:
        // Java에서 Slicing하는 방법은 Arrays.copyOfRange(기존 배열, 시작, 끝)을 사용하면 된다.
        answer = Arrays.copyOfRange(numList, 0, b + 1);
        break;

      case 2:
        answer = Arrays.copyOfRange(numList, a, numList.length);
        break;

      case 3:
        answer = Arrays.copyOfRange(numList, a, b + 1);
        break;

      case 4:
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = a; i <= b; i += c) {
          list.add(numList[i]);
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
          answer[i] = list.get(i);
        }
        break;

      default:
        break;
    }

    return answer;
  }
}
// 후.. 자바..