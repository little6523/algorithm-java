public class Day08_04 {
    public int solution(String number) {
        int sum = 0;
        char[] arr = number.toCharArray();
        for(char ch : arr) {
            sum += ch - '0';
        }

        return sum % 9;
    }
}
