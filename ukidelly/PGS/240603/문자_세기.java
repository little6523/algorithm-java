class Solution {
  public int[] solution(String myString) {
    HashMap<String,Integer> alphMap = new HashMap<>();

    // 대문자 알파벳 초기화
    for (int = 65; i < 91; i++){
      alphMap.put(String.valueOf((char)i), 0);
    }

    // 소문자 알파벳 초기화
    for (int i = 97; i < 123; i++){
      alphMap.put(String.valueOf((char)i), 0);
    }
    
    // 문자열을 순회하며 알파벳 개수 카운트
    for (int i = 0; i < myString.length(); i++){
      String s = String.valueOf(myString.charAt(i));
      alphMap.put(s, alphMap.get(s)+1);
    }

    // Map을 순회하며 int[]로 변환
    return alphMap.values().stream().mapToInt(i->i).toArray();
  }
}