fun main() {
    val sortedArray = intArrayOf(1, 4, 10, 43, 45, 46, 51, 53, 60, 64, 65, 66, 67, 72, 81, 82, 84, 90, 100)

    println("Result: " + search(sortedArray, 60))
}

private fun search(sortedArray: IntArray, element: Int): Int {
    var startIndex = 0
    var finishIndex = sortedArray.size - 1
    while (startIndex < finishIndex) {
        val middleIndex = (finishIndex + startIndex) / 2
        when {
            sortedArray[middleIndex] == element -> {
                return middleIndex
            }
            sortedArray[startIndex] == element -> {
                return startIndex
            }
            sortedArray[finishIndex] == element -> {
                return finishIndex
            }
            sortedArray[middleIndex] > element -> {
                finishIndex = middleIndex - 1
            }
            sortedArray[middleIndex] < element -> {
                startIndex = middleIndex + 1
            }
        }
    }
    return -1
}