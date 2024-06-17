package Day22;
import java.math.BigInteger;

public class Day22_02 {
    public String solution(String a, String b) {
        return (new BigInteger(a).add(new BigInteger(b))).toString();
    }
}
