import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lens = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            lens[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(lens, M));

        br.close();
    }

        //9, 3일때
        //최소한 3개씩은 묶어야함 -> 근데 이게 과연 최소일까 ?
        //예상 최솟값에서 널널하면 조금씩 추가해도되지않남

        //1 3 2 5 4 1 6 7 8
        //3개씩 묶는다 했을때 나는 어떻게 계산하지
        //일단 쪼개보겠지
        // 1+3+2 = 6
        // 5+4+1 = 10
        // 6+7+8 = 21 (이부분이 최댓값들이긴 하다. 전체길이/m 개만큼 더한 값들의 max!.. 근데 해당 로직을 추가하니까 왠지모르겠지만 시간이 더 길어졌어요) 
        //그러면 일단 여기서 값을 줄이기 위해 노력하겠지 ?
        //최솟값은 뭐야.. 대충 각 레슨 길이의max값이라고 하자 (8정도?)

        //8이랑 21중에 중간값이뭘까 ? 29/2 니까 14(자바계산법)
        //만약에 여기서 14로 끊는다고 쳐
        //1 +3+2+5 +(4)<- over 되니까 넘어가자 (11)
        //4+1+6 (11) -> over
        //7
        //8 
        //근데 이건 4개로 묶어야한다.. 그렇다면 최솟값이 15로 올라감
        //15랑 21의 중간을 해보자-- 하다가 같아지면 그게 크기가 되겠네용

    static int solution(int[] lens, int m) {
        int lt = 0;
        int rt = 0;

        int tmp = 0;
        for (int i = 0; i < lens.length; i++) {
            tmp += lens[i];
            lt = Math.max(lt, lens[i]);
        }
        rt = Math.max(rt, tmp);

        if(lens.length==m) return lt;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            tmp = 0;
            int cnt = 1;
            for (int len : lens) {
                tmp += len;
                if (tmp > mid) {
                    cnt++;
                    tmp = len;
                }
            }
            if(cnt <= m) rt = mid - 1;
            else lt = mid + 1;
        }
        return lt;
    }
}
