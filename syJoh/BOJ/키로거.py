import sys

t = int(input())
while t>0:
    answer = []
    right = []
    s = sys.stdin.readline().strip() # strip() 문자열 양 끝 공백 제거
    for i in s:
        if i == '<':
            if answer: #answer에 요소가 하나라도 있을 때
                right.append(answer.pop())
        elif i=='>':
            if right:
                answer.append(right.pop())
        elif i=='-':
            if answer:
                answer.pop()
        else:
            answer.append(i)
    answer.extend(reversed(right)) #right에 있는 문자열을 뒤집어서 answer에 추가
    print(''.join(answer)) #리스트를 문자열로 변환하여 출력
    t-=1

"""
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        /*
        백스페이스 입력 (-)  :    X-  글자 X 삭제
        화살표 입력 (< 또는 > 왼쪽)  :  왼쪽 또는 오른쪽으로 1만큼 움직임
         */
        while(t>0){
            String[] strArr = br.readLine().split("");
            LinkedList<String> list = new LinkedList<>();
            ListIterator<String> iter = list.listIterator();

            for(int i=0; i<strArr.length; i++){
                if(strArr[i].equals("<")){
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                }else if(strArr[i].equals(">")){
                    if(iter.hasNext()){
                        iter.next();
                    }
                }else if(strArr[i].equals("-")){
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                }else{
                    iter.add(strArr[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String s : list){
                sb.append(s);
            }
            System.out.println(sb);
            t--;
        }
    }
}

  """
