class Day5_01 {
    public String solution(String code) {
        String answer = "";
        char mode = '0';
        for(int i=0; i<code.length(); i++){ //i가 0부터 문자열 길이(11까지반복)
            char tmp = code.charAt(i); //'a''b''c'
            if(mode=='0'){//mode가 0일때 
                if(tmp!='1'){//code[idx]가 1이 아닐때
                    if(i%2==0){//idx가 짝수일때
                        answer+=tmp;
                    }
                }else if(tmp=='1'){ //code[idx]가 1일때
                    mode='1'; //mode는 1
                }
            }else if(mode=='1'){ //mode 가 1일때
                if (tmp!='1') { //code[idx]가 1이 아니면
                    if(i%2==1){ // idx가 홀수일때
                        answer+=tmp;
                    }
                }else if(tmp=='1'){
                    mode='0';
                }
            }
        } if(answer==""){
            return "EMPTY";
        }
        //ret (answer) 가 빈 문자열일때 empty를 대신 반환
        return answer;
    }
}