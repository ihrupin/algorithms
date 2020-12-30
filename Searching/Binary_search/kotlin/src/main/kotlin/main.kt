fun main() {
    val sortedArray = intArrayOf(1, 4, 10, 43, 45, 46, 51, 53, 60, 64, 65, 66, 67, 72, 81, 82, 84, 90, 100)

    println("Result loop implementation: " + binarySearchLoopImplementation(sortedArray, 60))
    println("Result recursive implementation: " + binarySearchRecursively(sortedArray, 60, 0, sortedArray.size - 1))
}

private fun binarySearchLoopImplementation(sortedArray: IntArray, element: Int): Int {
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

fun binarySearchRecursively(sortedArray: IntArray, element: Int, startIndex: Int, finishIndex: Int): Int {
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
            return binarySearchRecursively(sortedArray, element, 0, middleIndex - 1)
        }
        sortedArray[middleIndex] < element -> {
            return binarySearchRecursively(sortedArray, element, middleIndex + 1, finishIndex)
        }
    }
    return -1
}