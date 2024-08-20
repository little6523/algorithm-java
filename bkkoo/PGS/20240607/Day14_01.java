public class Day14_01 {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;

        int index = 1;
        for (int i : num_list)
        {
            if(index % 2 == 0)
            {
                even += i;
            }
            else
            {
                odd += i;
            }
            index++;
        }

        return Math.max(even, odd);
    }

//    public static void main(String[] args) {
//        int arr[] = new int[999999999];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//
//        for (int i = 0; i < 10; i++) {
//            solution(arr);
//        }
//    }
//
//    public static int solution(int[] num_list) {
//        int odd = 0;
//        int even = 0;
//
//        long start = 0;
//        long end = 0;
//
//        start = System.nanoTime();
//        int index = 1;
//        for (int i : num_list)
//        {
//            if(index % 2 == 0)
//            {
//                even += i;
//            }
//            else
//            {
//                odd += i;
//            }
//            index++;
//        }
//        end = System.nanoTime();
//        long foreachTime = end - start;
//        System.out.println("foreach : " +  (foreachTime));
//
//
//        start = System.nanoTime();
//
//        for (int i =0; i < num_list.length; i++)
//        {
//            if(i % 2 == 0)
//            {
//                even += num_list[i];
//            }
//            else
//            {
//                odd += num_list[i];
//            }
//        }
//        end = System.nanoTime();
//        long forTime =end - start;
//        System.out.println("for : " +  (forTime));
//        System.out.println("---------------");
//        return Math.max(even, odd);
//
////        foreach : 397413200
////        for : 401709300
////                ---------------
////                foreach : 348359700
////        for : 368000500
////                ---------------
////                foreach : 522816900
////        for : 366343700
////                ---------------
////                foreach : 681401200
////        for : 391160400
////                ---------------
////                foreach : 679066700
////        for : 392223600
////                ---------------
////                foreach : 705823100
////        for : 398057300
////                ---------------
////                foreach : 679845800
////        for : 392801500
////                ---------------
////                foreach : 686307700
////        for : 394535800
////                ---------------
////                foreach : 703171000
////        for : 407515000
////                ---------------
////                foreach : 684503100
////        for : 394723600
////                ---------------
//    }
}
