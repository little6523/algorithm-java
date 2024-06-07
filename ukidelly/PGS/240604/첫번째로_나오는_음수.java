class Solution {
    public int solution(int[] numList) {
        
    for (int i = 0; i < numList.length; i++) {
      if (numList[i] < 0) {
        return i;
      }
    }
    
    return -1;
  }
}