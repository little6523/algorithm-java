class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int multi = 1;
        for(int a : num_list){
            sum+=a;
            multi*=a;
        }
        return multi< Math.pow(sum,2)?1:0;
    }
}
