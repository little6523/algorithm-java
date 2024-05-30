class Solution {
    public String solution(String code) {
        int mode = 0;
        String ret = "";
        String empty = "EMPTY";
        
        for(int i=0; i<code.length(); i++) {
            char c = code.charAt(i);
            if(c == '1') {
                if(mode == 1) {
                    mode = 0;
                } else {
                    mode = 1;
                }   
                continue;
            } else {
                if(mode == 0) {
                    if(i % 2 == 0) {
                        ret += String.valueOf(c);
                    } else {
                        continue;
                    }
                } else {
                    if(i % 2 == 1) {
                        ret += String.valueOf(c);
                    } else {
                        continue;
                    }
                }
            }
        }
        
        if(ret.equals("")) {
            return empty;
        } else {
            return ret;
        }
    }
}
