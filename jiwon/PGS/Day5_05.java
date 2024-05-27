class Day5_05 {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";

        for(int i = 0; i<num_list.length; i++){
            int tmp = num_list[i];
            if(tmp%2==1){
                odd+=tmp;
            }else{
                even+=tmp;
            }
        }
        int a = Integer.parseInt(odd);
        int b = Integer.parseInt(even);

        return a+b;


        // int even=0; //짝수
        // int odd=0; //홀수
        // for(int i = 0; i<num_list.length; i++){
        //     int tmp = num_list[i];
        //     if(tmp%2==0){
        //         even=even*10+tmp;
        //     }else{
        //         odd=odd*10+tmp;
        //     }
        // }
        // return even+odd;
    }
}