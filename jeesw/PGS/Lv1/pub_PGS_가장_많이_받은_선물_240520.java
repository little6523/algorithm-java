import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> giftLog = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> receive = new HashMap<>();

        for (String name : friends) {
            giftScore.put(name, 0);
            receive.put(name, 0);
            Map<String, Integer> temp = new HashMap<>();
            for (String name2 : friends) {
                temp.put(name2, 0);
            }
            giftLog.put(name, temp);
        }

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String give = parts[0];
            String take = parts[1];
            giftLog.get(give).put(take, giftLog.get(give).get(take) + 1);
            giftScore.put(give, giftScore.get(give) + 1);
            giftScore.put(take, giftScore.get(take) - 1);
        }

        for (int i = 0; i < friends.length; i++) {
            String name = friends[i];
            for (int j = i + 1; j < friends.length; j++) {
                String name2 = friends[j];
                if (!name.equals(name2)) {
                    int giftCount1 = giftLog.get(name).get(name2);
                    int giftCount2 = giftLog.get(name2).get(name);
                    if (giftCount1 > giftCount2) {
                        receive.put(name, receive.get(name) + 1);
                    } else if (giftCount1 < giftCount2) {
                        receive.put(name2, receive.get(name2) + 1);
                    } else {
                        int score1 = giftScore.get(name);
                        int score2 = giftScore.get(name2);
                        if (score1 > score2) {
                            receive.put(name, receive.get(name) + 1);
                        } else if (score1 < score2) {
                            receive.put(name2, receive.get(name2) + 1);
                        }
                    }
                }
            }
        }

        for (int value : receive.values()) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}