class Solution {
  fun solution(todoList: Array<String>, finished: BooleanArray): Array<String> {
    val todoWithFinished = todoList.zip(finished.toList())
    return todoWithFinished.filter { (todo, finished) -> !finished }.map { (todo, finished) -> todo }.toTypedArray()
  }
}