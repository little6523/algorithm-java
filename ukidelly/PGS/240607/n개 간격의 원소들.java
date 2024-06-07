import java.util.ArrayList;

class Main {
  /**
   * 제가 푼 방식
   */
  public int[] solution(int[] numList, int n) {

    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < numList.length; i += n) {
      list.add(numList[i]);
    }

    return list.stream().mapToInt(i -> i).toArray();
  }

  /**
   * Math 클래스를 사용한 방식
   */
  public int[] solution2(int[] numList, int n) {
    // Math.ceil() 함수를 사용하여 올림을 한다.
    Double length = Math.ceil(numList.length / n);
    int[] answer = new int[length.intValue()];
    for (int i = 0; i < length; i++) {
      answer[i] = numList[i * n];
    }
    
    return answer;
  }
}