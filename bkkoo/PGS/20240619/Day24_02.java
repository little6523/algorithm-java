package Day24;

import java.util.ArrayList;
import java.util.List;

public class Day24_02 {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<String>();
        StringBuilder builder;

        for (String str : picture)
        {
            builder  = new StringBuilder();

            for (int i = 0; i < str.length(); i++)
            {
                for(int j = 0; j < k; j++)
                {
                    builder.append(str.charAt(i));
                }
            }

            for(int i = 0; i < k; i++)
            {
                list.add(builder.toString());
            }
        }

        return list.toArray(new String[0]);
    }
}
