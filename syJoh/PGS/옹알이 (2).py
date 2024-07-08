def solution(babbling):
    answer = 0
    words = ['aya', 'ye', 'woo', 'ma']
    for b in babbling:
        for word in words:
            if word*2 not in b:
                b = b.replace(word, ' ')
        if len(b.strip())==0:
            answer += 1
    return answer
"""
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        for(String b: babbling){
            for(String a: arr){
                if(!b.contains(a+a)){
                    b = b.replace(a, " ");
                }
            }
            if(b.trim().equals("")){
                answer++;
            }
        }
        return answer;
    }
}
"""
