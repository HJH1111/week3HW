import kotlin.random.Random


fun main() {
    val rangeRandom1 = IntArray(3)
    var t = 0
    while (t < 3) {
        val number = Random.nextInt(1, 10)
        if (number in rangeRandom1)
            continue
        else rangeRandom1[t] = number
        t++
    }
    var strike: Int
    var ball: Int
    val r = IntArray(3)

    while (true) {
        t = 0
        while (t < 3) {
            try {
                print("${t + 1} 번째 숫자 : ")
                r[t] = readln().toInt()
                if (r[t] !in 1..9) {
                    println("다시입력")
                    continue
                }
                t++

            } catch (e: NumberFormatException) {
                println("다시입력")
                continue
            }
        }
        if (r[0] == r[1] || r[0] == r[2] || r[1] == r[2]) {
            println("중복")
            continue
        }
        strike = 0
        ball = 0


        for (i in r.indices) {
            for (j in rangeRandom1.indices) {
                if (r[i] == rangeRandom1[j]) {
                    if (i == j) {
                        strike++
                    } else {
                        ball++
                    }
                }
            }
        }
        if (strike == 0 && ball == 0)
            println("Nothing")
        else {
            println("스트라이크: $strike")
            println("볼: $ball")
        }
        if (strike == 3) {
            println("끝")
            break
        }
    }
}

// TODO #1: 숫자 입력받는 거 반복문으로 바꾸기
// TODO #2: 위의 무작위 수 3개 생성하는 거 뜯어보기