public class Day12_01 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer;
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        if(n == 1)
        {
            answer = new int[b + 1];
            for(int i = 0; i <= b; i++)
            {
                answer[i] = num_list[i];
            }
        }
        else if(n == 2)
        {
            answer = new int[num_list.length - a];
            for (int i = 0; i < num_list.length - a; i++)
            {
                answer[i] = num_list[i + a];
            }
        }

        else if(n == 3)
        {
            answer = new int[b - a + 1];
            for (int i = 0; i <= b - a; i++)
            {
                answer[i] = num_list[i + a];
            }
        }

        else
        {
            int count = (b - a) / c + 1;
            answer = new int[count];
            for (int i = 0; i < count; i++)
            {
                answer[i] = num_list[a + i * c];
            }
        }

        return answer;
    }
}
