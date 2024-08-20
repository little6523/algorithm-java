import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String p: participant){
            if(!map.containsKey(p)){
                map.put(p, 1);
            }else{ //동명이인
                map.replace(p, map.get(p)+1);
            }
        }
        /*
        for (String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        */
        for(String c: completion){
            if(map.containsKey(c)){
                map.replace(c, map.get(c)-1);
            }
        }
        for(String key: map.keySet()){
            if(map.get(key)>0){
                answer = key;
            }
        }
        return answer;
    }
}
