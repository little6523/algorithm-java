class Day5_04 {
    public int solution(int[] num_list) {
        int sum = 0;
        int pow = 0;
        int multi = 1;
        for(int i = 0; i<num_list.length; i++){
            multi*=num_list[i];
            sum+=num_list[i];
        }
        pow=sum*sum;
        return multi<pow?1:0;
    }
}