fun main() {
    val unsortedArray = arrayOf(9, 1, 5, 6, 7, 4, 2, 1, 7, 8, 0)
    println("Before sorting ${unsortedArray.joinToString()}")

    val sortedArray = sort(unsortedArray)
    println("After sorting ${sortedArray.joinToString()}")
}

fun sort(array: Array<Int>): Array<Int> {
    for (end in array.size - 1 downTo 1) {
        var swapped = false
        for (index in 0 until end) {
            if (array[index] > array[index + 1]) {
                val temp = array[index]
                array[index] = array[index + 1]
                array[index + 1] = temp
                swapped = true
            }
        }
        if (!swapped) {
            break
        }
    }
    return array
}
