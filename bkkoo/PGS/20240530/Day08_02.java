import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Day08_02 {
    public int solution(int a, int b, int c, int d) {
        int[] inputs = {a, b, c, d};

        Arrays.sort(inputs);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : inputs) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int p = 0;
        int q = 0;
        int r = 0;

        if (map.size() == 4)     // 다 다름
        {
            return inputs[0];
        }
        else if(map.size() == 1)
        {
            return inputs[0]*1111;
        }
        else if(map.size() == 2)
        {
            p = inputs[0];
            q = inputs[3];
            if(map.get(inputs[0]) == 2)
            {
                return (p + q) * Math.abs(p-q);
            }
            else
            {
                if(map.get(p) == 3) {
                    return (int) Math.pow(10 * p + q, 2);
                }
                else
                {
                    return (int) Math.pow(10 * q + p, 2);
                }
            }
        }
        else
        {
            for (int i : map.keySet())
            {
                if(map.get(i) == 2)
                {
                    p = i;
                    continue;
                }
                else if(q == 0)
                {
                    q = i;
                }
                else
                {
                    r = i;
                }
            }
            return q * r;
        }
    }
}
