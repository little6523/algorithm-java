fun main(){
  val inputList = buildList<Int> { for (i in 1..3) { add(readln().toInt()) } }
  val sum = inputList.reduce { acc, i ->  acc * i }.toString()

  for (i in 0..9){
    println(sum.count{it.toString() == i.toString()})
  }
}

// 다른 사람 풀이 보고 수정한 코드
fun main() {
  val a = readln().toInt()
  val b = readln().toInt()
  val c = readln().toInt()

  val mult = (a * b * c).toString()

  for (i in 0..9) {
    println(mult.count { it.toString() == i.toString() })
  }
}