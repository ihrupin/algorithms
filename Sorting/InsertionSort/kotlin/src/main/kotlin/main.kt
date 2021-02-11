fun main() {
    val unsortedArray = arrayOf(9, 1, 5, 6, 7, 4, 2, 1, 7, 8, 0)
    println("Before sorting ${unsortedArray.joinToString()}")

    val sortedArray = sort(unsortedArray)
    println("After sorting ${sortedArray.joinToString()}")
}

fun sort(array: Array<Int>): Array<Int> {
    for (index in 1 until array.size) {
        var tempIndex = index
        while (tempIndex > 0 && array[tempIndex] < array[tempIndex - 1]) {
            val temp = array[tempIndex - 1]
            array[tempIndex - 1] = array[tempIndex]
            array[tempIndex] = temp
            tempIndex--
        }
    }
    return array
}
