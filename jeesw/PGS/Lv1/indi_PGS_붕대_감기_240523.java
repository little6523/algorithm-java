import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int curHp = health; // 현재 체력
        int cnt = 0; // 연속 성공 횟수
        int idx = 0; // attacks 순서를 나타내는 인덱스
        int lastAtk = attacks[attacks.length - 1][0]; // 마지막 공격 시간

        for (int i = 1; i <= lastAtk; i++) {
            cnt++;

            if (i == attacks[idx][0]) {
                curHp -= attacks[idx][1];
                idx++;
                cnt = 0;
                if (curHp <= 0) {
                    curHp = -1;
                    break;
                }
            } else {
                if (curHp + bandage[1] < health) {
                    curHp += bandage[1];
                } else {
                    curHp = health;
                }

                if (cnt == bandage[0]) {
                    if (curHp + bandage[2] < health) {
                        curHp += bandage[2];
                    } else {
                        curHp = health;
                    }
                    cnt = 0;
                }
            }
        }
        answer = curHp;

        return answer;
    }
}