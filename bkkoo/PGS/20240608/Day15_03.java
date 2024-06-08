public class Day15_03 {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 4, 15, 1, 14};
        System.out.println(solution(arr));
    }

    public static int solution(int[] num_list) {
        int answer = 0;
        int check = 0;
        while (check != num_list.length) {
            check = 0;
            for (int i = 0; i < num_list.length; i++) {
                if(num_list[i] == 1) {
                    check++;
                    continue;
                }
                num_list[i] /= 2;
                answer++;
            }
        }
        return answer;
    }
}
