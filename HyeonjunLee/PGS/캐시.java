package Programmers;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> cache = new LinkedList<>();

        String temp;
        for (int i = 0; i < cities.length; i++) {

            // 대소문자 구분이 없으므로 다 대문자로 만들어서 비교한다.
            temp = cities[i].toUpperCase();

            // cache miss: 찾고자 하는 문자열이 캐시에 없는 경우
            if (!cache.contains(temp)) {
                answer += 5;

                // 캐시가 0보다 클 때만 캐시를 계산한다.
                if (cacheSize > 0) {

                    // 현재 캐시가 꽉 찼다면 맨 앞의 문자열이 가장 오래되었으므로 제거
                    if (cache.size() == cacheSize) {
                        cache.poll();
                    }

                    // 새로운 문자열을 캐시의 맨 뒤에 추가한다.
                    cache.offer(temp);
                }

            }

            // cache hit: 찾고자 하는 문자열이 캐시에 있는 경우
            else {
                answer += 1;

                // 최근 참조한 문자열이 되므로 캐시에서 해당 문자열을 제거하고,
                // 캐시의 맨 뒤로 보낸다.
                cache.remove(temp);
                cache.offer(temp);
            }
        }

        return answer;
    }
}
