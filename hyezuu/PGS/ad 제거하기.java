import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for(String x : strArr){
            if(!x.contains("ad"))list.add(x);
        }
        return list.toArray(new String[0]);
    }
}
