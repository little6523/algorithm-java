class Solution {
  public int solution(int[] numList) {
    int evenSum = 0;
    int oddSum = 0;

    for(int idx=0; idx<numList.length; idx++) {
      if(idx%2==0) {
        oddSum += numList[idx];
      }
      else {
        evenSum += numList[idx];
      }
    }

    return Math.max(evenSum,oddSum);
  }
}