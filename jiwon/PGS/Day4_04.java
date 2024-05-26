class Day4_04 {
    public int solution(String ineq, String eq, int n, int m) {
//        int answer = 0;
//        if(ineq.equals("<")){
//            if(eq.equals("=")){
//                if(n<=m){
//                    return 1;
//                }if(n>m){
//                    return 0;
//                }
//            }
//            if(eq.equals("!")){
//                if(n<m){
//                    return 1;
//                }if(n>=m){
//                    return 0;
//                }
//            }
//        }
//
//        if(ineq.equals(">")){
//            if(eq.equals("!")){
//                if(n>m){
//                    return 1;
//                }if(n<=m){
//                    return 0;
//                }
//            }
//            if(eq.equals("=")){
//                if(n>=m){
//                    return 1;
//                }if(n<m){
//                    return 0;
//                }
//            }
//        }
//        return answer;
//    }
        int answer = 0;

        if(ineq.equals(">")){
            if(eq.equals("=")){
                if(n >= m){
                    answer = 1;
                }
            }
            else if(eq.equals("!")){
                if(n > m){
                    answer = 1;
                }
            }
        }
        else if(ineq.equals("<")){
            if(eq.equals("=")){
                if(n <= m){
                    answer = 1;
                }
            }
            else if(eq.equals("!")){
                if(n < m){
                    answer = 1;
                }
            }
        }

        return answer;
    }
}
