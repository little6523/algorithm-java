import javax.security.sasl.SaslClient;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(solution(number));
    }
    public static int solution(int number){
        int answer = 0;
        int[] arr = new int[9];
        String str = String.valueOf(number);

        for(int idx = 0; idx < str.length(); idx++){
            if(Integer.parseInt(String.valueOf(str.charAt(idx))) == 9){
                arr[6] += 1;
                continue;
            }
            arr[Integer.parseInt(String.valueOf(str.charAt(idx)))] += 1;
        }
        if(arr[6] % 2 == 1){
            arr[6] = (arr[6] / 2) + 1;
        }else{
            arr[6] = arr[6] /2;
        }
        answer = Arrays.stream(arr).max().getAsInt();
        return answer;
    }
}



//Python
/*

def solution(num) :
    answer = 0
    lst = [0,0,0,0,0,0,0,0,0]
    s = str(num)

    for tmpS in s :
        if int(tmpS) == 9 :
            lst[6] += 1
            continue
        lst[int(tmpS)] += 1
    if lst[6] % 2 == 1:
        lst[6] = (lst[6] // 2) +1
    else :
        lst[6] = lst[6] // 2
    answer = max(lst)
    return answer
if __name__ == "__main__" :
    num = int(input())
    print(solution(num))

*/
