class Day3_05 {
    public int solution(int a, int b) {
        int answer = 0;
        int a1 = Integer.parseInt(""+a+b);
        int a2 = 2*a*b;;
        answer = a1 > a2 ? a1 : a2;
        return answer;
    }
}