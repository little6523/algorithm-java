public class Day11_05 {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 0}, 3);
    }
    public static int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if(arr[i] == 1)
            {
                return i;
            }
        }
        return -1;
    }
}
