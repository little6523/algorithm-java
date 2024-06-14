class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int a1 = 0, a2 = 0;
        if(arr1.length>arr2.length)
            answer = 1;
        else if(arr1.length<arr2.length)
            answer = -1;
        else{
            for(int i: arr1)
                a1 +=i;
            for(int j: arr2)
                a2 +=j;
            if(a1>a2) answer = 1;
            else if(a1<a2) answer = -1;
            else answer = 0;
        }
        return answer;
    }
}
