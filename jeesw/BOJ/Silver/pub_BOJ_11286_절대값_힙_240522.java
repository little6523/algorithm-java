import java.util.*;

class Main {
   static class AbsoluteValueHeapComparator implements Comparator<Integer> {
       public int compare(Integer a, Integer b) {
           int absA = Math.abs(a);
           int absB = Math.abs(b);
           if (absA == absB) {
               // 절대값이 같을 경우 음수를 우선순위로 둠
               return a < b ? -1 : 1;
           }
           // 절대값이 작은 것을 우선순위로 둠
           return absA - absB;
       }
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       PriorityQueue<Integer> pq = new PriorityQueue<>(new AbsoluteValueHeapComparator());

       for (int i = 0; i < N; i++) {
           int oper = sc.nextInt();
           if (oper == 0) {
               if (pq.isEmpty()) {
                   System.out.println(0);
               } else {
                   System.out.println(pq.poll());
               }
           } else {
               pq.offer(oper);
           }
       }
   }
}