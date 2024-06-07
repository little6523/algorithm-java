import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int time = 0;
        for(String city : cities) {
            city = city.toLowerCase();
            if(q.isEmpty()||!q.contains(city)){
                q.offer(city);
                time+=5;
                if(q.size()>cacheSize) q.poll();
            }
            else {
                q.remove(city);
                q.offer(city);
                time++;
            }
        }
        return time;
    }
}
