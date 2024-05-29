class Day6_03 {
    public int solution(int n, String control) {
        int answer = n;
        char[] charArray = control.toCharArray();

        for(int i = 0; i<charArray.length; i++){
            if(charArray[i]=='w'){
                answer+=1;
            }else if(charArray[i]=='s'){
                answer-=1;
            }else if (charArray[i]=='d'){
                answer+=10;
            }else if (charArray[i]=='a')
                answer-=10;
        }
        return answer;
    }
}