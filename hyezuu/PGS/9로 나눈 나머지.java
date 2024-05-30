class Solution {
    public int solution(String number) {
        int sum = 0;
        for(char c : number.toCharArray()){
            sum+=c-'0';
        }
        return sum%9;
        // int sum = 0;
        // for(char c : number.toCharArray()){
        //     sum+=c;
        // }
        // return (sum-48*number.length())%9;
    }
}
