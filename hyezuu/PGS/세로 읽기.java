class Solution {
    public String solution(String myString, int m, int c) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=c-1; i<myString.length(); i+=m){
            sb.append(myString.charAt(i));
        }
        
        return sb.toString();
        // while(myString.length()>0){
        //     sb.append(myString.charAt(c-1));
        //     myString = myString.substring(m);
        // }
        // return sb.toString();
    }
}
