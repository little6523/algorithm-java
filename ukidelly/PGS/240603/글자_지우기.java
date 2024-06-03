class Solution {
  public String solution(String myString, int[] indicies) {
    ArrayList<String> array = new ArrayList<>(Arrays.asList(myString.split("")));

    for (int i : indicies){
      array.set(i, "");
    }

    return String.join("", array);
  }
}