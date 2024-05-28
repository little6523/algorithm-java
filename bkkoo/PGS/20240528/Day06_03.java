public class Day06_03 {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();

        int temp = 0;

        for (int i : numLog)
        {
            int gap = i - temp;

            switch (gap)
            {
                case 1: answer.append('w'); break;
                case -1: answer.append('s'); break;
                case 10: answer.append('d'); break;
                case -10: answer.append('a'); break;
            }

            temp = i;
        }
        return answer.toString();
    }
}
