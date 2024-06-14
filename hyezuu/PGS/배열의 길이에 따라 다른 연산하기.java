class Solution {
    public int[] solution(int[] arr, int n) {
      int rmd = arr.length%2;
      for(int i=0; i<arr.length; i++){
          if(i%2!=rmd){
              arr[i]+=n;
          }
      }
      return arr;
    }
}
