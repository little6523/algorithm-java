class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int count = 0;
        
        for(int i=0; i<picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<picture[i].length(); j++) {
                for(int m=0; m<k; m++) {
                    sb.append(picture[i].charAt(j));
                }
            }          
            
            for(int j=count; j<k+count; j++) {
                answer[j] = sb.toString();
            }
            
            count += k;
        }  
        
        return answer;
    }
}
