public class Day05_04 {
    public int solution(int[] num_list) {
        int caseSum = 0;
        int caseMultiple = 1;


        for (int num : num_list) {
            caseMultiple *= num;
            caseSum += num;
        }


        return caseMultiple > caseSum*caseSum ? 0 : 1;
    }
}
