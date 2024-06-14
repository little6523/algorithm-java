import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        return (arr1.length < arr2.length) ? -1 : (arr1.length > arr2.length) ? 1 : (Arrays.stream(arr1).sum() > Arrays.stream(arr2).sum()) ? 1 : (Arrays.stream(arr1).sum() < Arrays.stream(arr2).sum()) ? -1 : 0;
    }
}