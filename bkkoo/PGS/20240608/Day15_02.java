public class Day15_02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 100, 99, 98};
        solution(arr);
    }
    public static int solution(int[] arr) {
        int answer = -1;
        int check = 0;
        while(check != arr.length)
        {
            check = 0;
            for (int i = 0; i < arr.length; i++) {
                if((arr[i] >= 51 && arr[i] % 2 == 1) || (arr[i] < 50 && arr[i] % 2 == 0)) {
                    check++;
                    continue;
                }

                if (arr[i]>=50 && arr[i] % 2 == 0) {
                    arr[i] = arr[i] / 2;
                }
                else if(arr[i]<=50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                }
            }
            answer++;
        }
        return answer;
    }
}
