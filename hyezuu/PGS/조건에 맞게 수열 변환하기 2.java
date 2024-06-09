class Solution {
    public int solution(int[] arr) {
        
        int max = 0;        
        for(int num : arr){
            int cnt = 0;
            
            while(num>=50 && num%2==0||num<50 && num%2==1){
                num = num>=50 && num%2==0 ? num/2 : (num*2)+1;
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}
