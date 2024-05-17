//PriorityQueue 사용
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<score.length; i++){
            if(pq.size()<k){
                pq.offer(score[i]);
            }else{
                //k번째 순위의 점수보다 높을 때
                if(pq.peek()<score[i]){
                    pq.poll();
                    pq.offer(score[i]);
                }
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}

//ArrayList 사용
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            if(list.size()>=k){
                //k번째 점수와 비교
                if(list.get(k-1)<score[i]){
                    list.remove(k-1);
                    list.add(score[i]);
                }
            }else{
                list.add(score[i]);
            }
            Collections.sort(list, Collections.reverseOrder());
            answer[i] = list.get(list.size()-1);
        }

        return answer;
    }
}
