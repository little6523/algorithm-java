public class Day18_03 {
    public int solution(String binomial) {
        String[] strArr = binomial.split(" ");
        int front = Integer.parseInt(strArr[0]);
        int back = Integer.parseInt(strArr[2]);
        if(strArr[1].equals("+"))
        {
            return front + back;
        }
        else if(strArr[1].equals("-"))
        {
            return  front - back;
        }
        else {
            return  front * back;
        }
    }
}
