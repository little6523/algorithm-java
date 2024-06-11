import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int wholeSize = priorities.length;
        PriorityQueue<Integer> pro = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pro.offer(priorities[i]);
            q.offer(new Pair<>(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            Pair<Integer, Integer> front = q.poll();
            int idx = front.getKey();
            int tmp = front.getValue();
            if (tmp == pro.peek()) {
                pro.poll();
                answer = wholeSize - q.size();
                if (idx == location) break;
            } else {
                q.offer(front);
            }
        }

        return answer;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}