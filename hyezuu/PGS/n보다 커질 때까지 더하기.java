class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        
        for(int number : numbers){
            sum+=number;
            if(sum>n) return sum;
        }
        
        return sum;
        
        // int sum = 0, i=0;
        // while(sum<=n){
        //     sum+=numbers[i];
        //     i++;
        // }
        // return sum;
    }
}
