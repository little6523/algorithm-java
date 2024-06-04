class Solution {
  public int[] solution(int n, int k){
    int count = n / k;
    int[] result = new int[count];

    for (int i=1; i<= count; i++){
      result[i-1] = i * k;
    }

    return result;
  }
}