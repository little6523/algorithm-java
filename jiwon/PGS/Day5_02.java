class Day5_02 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int value = 0;
        for (int i=0; i<included.length; i++){ //0부터 included의 길이까지 반복하고
            boolean tmp = included[i]; //included의 인덱스의 값을 찾아서
            if(tmp==true){
                answer+=a+i*d;//a+(n-1)d
            } //included가 true인 값을 찾는다
            //true 인 항들만 더한다
        }
        return answer;
    }
}