class Day6_01 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        // answer[] = num_list[]
        for(int i = 0; i<num_list.length; i++){
            answer[i] = num_list[i];
        }
        int last = num_list[num_list.length-1];
        int beforelast=num_list[num_list.length-2];
        int answerlast=0;

        if(last>beforelast){
            answerlast=last-beforelast;
        }else{
            answerlast=last*2;
        }
        answer[answer.length-1]=answerlast;
        return answer;
    }
}