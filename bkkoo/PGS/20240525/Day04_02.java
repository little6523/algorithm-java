public class Day04_02 {
    public int solution(int number, int n, int m) {
        int answer = 0;
        return IsMultiple(n, number) && IsMultiple(m, number) ? 1 : 0;
    }

    public boolean IsMultiple(int divisor , int number)
    {
        return number % divisor == 0 ? true : false;
    }
}
