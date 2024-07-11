def solution(cacheSize, cities):
    answer = 0
    cache = []
    for city in cities:
        #캐시크기가 0 이면 모두 miss
        if cacheSize == 0:
            answer += 5*len(cities)
            break
        #소문자로 전환
        c = city.lower()
        if not c in cache: #cache miss
            if len(cache) < cacheSize:
                cache.append(c)
            else:  # 교체
                cache.pop(0)
                cache.append(c)
            answer += 5
        else: #cache hit
            cache.remove(c)
            cache.append(c)
            answer+=1
    return answer
