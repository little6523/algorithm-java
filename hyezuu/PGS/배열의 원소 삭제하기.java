import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for(int n : arr){
            list.add(n);
        }
        
        for(int n : delete_list){
            //int 타입일 시 인덱스로 동작하므로 객체타입인 Integer타입으로 박싱해줘야함
            list.remove(Integer.valueOf(n));
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}
