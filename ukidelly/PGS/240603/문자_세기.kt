/**
 * 제가 푼 방식
 */
fun solution(myString:String){
  val bigAlph = ('A'..'Z').associateWith { 0 }.toMutableMap()
  val smallAlph = ('a'..'z').associateWith { 0 }.toMutableMap()

  myString.forEach {
    if ( bigAlph.containsKey(it) ) {
      bigAlph[it] = bigAlph[it]!! + 1
    } else if ( smallAlph.containsKey(it) ) {
      smallAlph[it] = smallAlph[it]!! + 1
    }
  }

  return (bigAlph.values + smallAlph.values).toIntArray()
}

/**
 * 인상 깊었던 풀이
 */
fun solution2(myString:String){
  return ('A'..'Z').map { alph -> myString.count { it == alph } }.toIntArray() + ('a'..'z').map { alph -> myString.count { it == alph } }.toIntArray()
}