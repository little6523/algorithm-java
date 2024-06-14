package Day20;

public class Day20_04 {
    public int[] solution(int[] arr, int n) {
        int index = arr.length % 2 == 0 ? 1 : 0;

        for (int i = index; i < arr.length; i+= 2) {
            arr[i] += n;
        }

        return arr;
    }
}
