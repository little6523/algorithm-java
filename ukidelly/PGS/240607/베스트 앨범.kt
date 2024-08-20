class Solution {
  /**
   * 제가 푼 방식
   */
  fun solution(genres: Array<String>, plays: IntArray): IntArray {
    // plays들을 Song으로 변환
    val songs: List<Song> = plays.mapIndexed { index, play -> Song(index, play, genres[index]) }

    // songs를 장르별로 그룹화
    val genresMap = songs.groupBy { it.genre }

    // 각 장르별로 랭킹을 매긴다
    val genreRank = genresMap.map { (key, value) ->
      // key는 장르 이름, value는  해당 장르의 노래들의 총 재생횟수
      key to value.sumOf { it.plays }
      // 총 재생횟수로 내림차순 정렬
    }.sortedByDescending { it.second }

    // 각 장르마다
    return genreRank.map { (genre, _) ->
      // 각 장르의 노래들을 뽑아서 재생횟수로 내림차순 정렬
      val songList = songs.filter { it.genre == genre }.sortedByDescending { it.plays }

      // 재생횟수로 그룹을 몪고(그 이유는 재생횟수가 같은 노래들이 있을 수 있기 때문에)
      songList.groupBy { it.plays }
        // 각 노래(들)을 id 기준으로 정렬후 평탄화(하나의 리스트로 만든다)
        .map { (_, value) -> value.sortedBy { it.id } }.flatten()
        // 각 장르에서 가장 많이 재생된 노래 2개를 뽑아서 id만 추출
        .map { it.id }.take(2)
      // 평탄화 작업후 배열로 변환
    }.flatten().toIntArray()
  }

  /**
   * 인상적이고 깔끔한 다른 사람 풀이
   */
  fun solution2(genres: Array<String>, plays: IntArray): IntArray {
    // 고유번호를 장르별로 그룹화 {장르 : [고유번호1, 고유번호2, ...], ...}후 리스트로 변환 -> [ {장르: [고유번호1, 고유번호2, ..]}, ... ]
    return genres.indices.groupBy { genres[it] }
      .toList()
      // 그런 다음, 각 요소인 Pair -> {장르 : [고유번호1, 고유번호2, ...], ...}에서 두번째인 [고유번호1, 고유번호2, ...]를 총 재생횟수로 내림차순 정렬
      .sortedByDescending { pair -> pair.second.sumOf { plays[it] } }
      // 그런 다음, 정렬된 각 요소인 Pair -> {장르 : [고유번호1, 고유번호2, ...], ...}에서 두번째인 [고유번호1, 고유번호2, ...]를 오름차순으로 정렬후, 2개만 추출
      .map { it.second.sortedByDescending { plays[it] }.take(2) }
      // 추출한 값을을 하나의 리스트로 평탄화후, IntArray로 변환
      .flatten()
      .toIntArray()
  }
}

// 노래 클래스
data class Song(val id: Int, val plays: Int, val genre: String)