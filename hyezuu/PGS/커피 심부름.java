class Solution {
    public int solution(String[] order) {
        int sum = 0;
        for(String coffee : order){
            sum += coffee.contains("cafelatte") ? 5000 : 4500 ;
        }       
        return sum;
    }
}
