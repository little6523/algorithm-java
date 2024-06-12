public class Day18_01 {
    public int[] solution(String myString) {
        String[] splilts = myString.split("x", -1);
        //limit가 0보다 클 경우 limit 개수만큼 split을 진행
        //limit가 0일 경우 맨 뒤의 값이 빈값이면 생략
        //limit가 0보다 작을 경우 맨 뒤의 빈값에 대해 split을 모두 진행
        int[] answer = new int[splilts.length];

        for (int i = 0; i < splilts.length; i++) {
            answer[i] = splilts[i].length();
        }

        return answer;
    }
}
