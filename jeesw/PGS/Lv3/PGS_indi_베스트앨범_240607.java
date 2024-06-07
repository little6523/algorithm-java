import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Pair<Integer, Integer>>> genreMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Pair<>(i, play));
            sumMap.put(genre, sumMap.getOrDefault(genre, 0) + play);
        }

        List<String> orderedGenres = sumMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        for (String genre : orderedGenres) {
            List<Pair<Integer, Integer>> musicList = genreMap.get(genre).stream()
                    .sorted((a, b) -> {
                        if (a.getSecond().equals(b.getSecond())) {
                            return a.getFirst().compareTo(b.getFirst());
                        }
                        return b.getSecond().compareTo(a.getSecond());
                    })
                    .collect(Collectors.toList());

            answer.add(musicList.get(0).getFirst());
            if (musicList.size() > 1) {
                answer.add(musicList.get(1).getFirst());
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}