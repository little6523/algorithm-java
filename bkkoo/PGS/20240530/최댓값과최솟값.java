import java.util.Arrays;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String[] inputArray = s.split(" ");
        int[] arr = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++)
        {
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        Arrays.sort(arr);


        return arr[0] + " " + arr[arr.length - 1];
    }
}
