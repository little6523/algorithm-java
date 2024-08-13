import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i]= Integer.parseInt(br.readLine());
        }
        for(int answer : solution(nums)){
            System.out.println(answer);
        }
        br.close();
    }

    static int[] solution(int[] nums){
        Arrays.sort(nums);
        //산술평균, 중앙값, 최빈값, 범위
        int[] answer = new int[4];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new LinkedHashSet<>();
        int sum = 0;
        for(int num : nums){
            sum += num;
            map.put(num, map.getOrDefault(num,0)+1);
            set.add(num);
            max = Math.max(max, map.get(num));
        }
        int cnt = 0;
        for(int a : set){
            if(max == map.get(a) && cnt<2){
                answer[2] = a;
                cnt++;
            }
        }

        answer[0] = Math.round((float) sum /nums.length);
        answer[1] = nums[nums.length/2];
        answer[3] = nums[nums.length-1]-nums[0];

        return answer;
    }
}
