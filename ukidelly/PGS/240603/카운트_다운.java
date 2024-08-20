class Solution {
  public int[] solution(int start, int endNum){
    int[] result = new int[start - end + 1];
    int tmp = start;

    for (int i = 0; i < result.length; i++){
      result[i] = tmp--;
    }

    return result;
  }
}