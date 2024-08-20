// 내가 푼 풀이
// 1. 길이 별로 내림차순 정렬(같은 반복문 안에서 해결하기 위해)
// 2. 문자열 순서대로 해당 부분문자열 갯수 1증가
// 3. 만약 전체 문자열과 부분 문자열 같으면 답

// import java.util.*;

// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         Map<String, Integer> map = new HashMap<>();
        
//         Arrays.sort(phone_book, (s1, s2) -> s2.length() - s1.length());
        
//         for (String str : phone_book) {
//             for (int i = 0; i < str.length(); i++) {
//                 String key = str.substring(0, i + 1);
//                 map.put(key, map.getOrDefault(key, 0) + 1);
//             }
//             if (map.get(str) > 1) {
//                 answer = false;
//                 break;
//             }
//         }
        
//         return answer;
//     }
// }

// 다른 사람 풀이
// 1. 전화번호부를 (전체 문자열, 인덱스)로 맵핑한다.
// 2. 진 부분문자열을 제외한 모든 부분 문자열에 대해서 맵 안에 해당 부분문자열을 포함하고 있는지 탐색.
import java.util.HashMap;
import java.util.Map;


class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < phoneBook.length; i++) {
                map.put(phoneBook[i], i);
            }


            for(int i = 0; i < phoneBook.length; i++) {
                for(int j = 0; j < phoneBook[i].length(); j++) {
                    if(map.containsKey(phoneBook[i].substring(0,j))) {
                        answer = false;
                        return answer;
                    }
                }
            }




            return answer;
    }
}