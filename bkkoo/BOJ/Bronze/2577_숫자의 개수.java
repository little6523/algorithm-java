import java.util.*;

class Main {
    public static void main(String[] args) {

        List<Integer> resultList = new ArrayList<>();
        int multiplier = 1;
        for (int i = 0; i < 10; i++) {
            resultList.add(0);
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<3; i++) {
            multiplier *= sc.nextInt();
        }

        while(multiplier != 0)
        {
            int remain = multiplier % 10;
            resultList.set(remain, resultList.get(remain) + 1);

            multiplier /= 10;
        }

        for (Integer i : resultList)
        {
            System.out.println(i);
        }

    }
}
