import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        if(cacheSize==0){
            answer = cities.length*5;
            return answer;
        }
        for(String city : cities){
            String c = city.toLowerCase();
            if(cache.contains(c)){
                cache.remove(c);
                cache.offer(c);
                answer+=1;
            }else{
                if(cache.size()<cacheSize){
                    cache.offer(c);
                }else{
                    cache.poll();
                    cache.offer(c);
                }
                answer+=5;
            }
        }
        return answer;
    }
}
