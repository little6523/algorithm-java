def solution(N, stages):
    fail= []
    x = len(stages)
    for i in range(1, N+1):
        if x!=0:
            fail.append((i, stages.count(i)/x))
        else:
            fail.append((i, 0))
        x -= (stages.count(i))
    fail.sort(key=lambda x: (-x[1], x[0]))
    answer = list(i[0] for i in fail)
    return answer
"""
# 70점 실패(런타임 에러)
def solution(N, stages):
    stages.sort()
    fail= []
    x = len(stages)
    for i in range(1, N+1):
        fail.append((i, stages.count(i)/x))
        x -= (stages.count(i))
    fail.sort(key=lambda x: (-x[1], x[0]))
    answer = list(i[0] for i in fail)
    #answer = [i[0] for i in fail]
    return answer
"""
"""
import java.util.*;
class Pair{
    int stg;
    double rate;
    
    Pair(int stg, double rate){
        this.stg = stg;
        this.rate = rate;
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int x = stages.length;
        List<Pair> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            //스테이지별 도달한 유저 수
            int count = 0;
            for(int stage: stages){
                if(i==stage){
                    count++;
                }
            }
            //실패율
            double rate = x==0 ? 0 : (double)count/x;
            //double rate = x==0 ? 0 : count/x;
            list.add(new Pair(i, rate));
            //다음 스테이지 도전자 수
            x -= count;  
        }
        //1차 실패율 기준 내림차순, 2차 스테이지 기준 오름차순
        Collections.sort(list, (p1, p2)->{
            if(p1.rate == p2.rate){
                return Integer.compare(p1.stg, p2.stg);
            }else{
                return Double.compare(p2.rate, p1.rate);
            }
        });
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).stg;
        }
        return answer;
    }
}
"""
