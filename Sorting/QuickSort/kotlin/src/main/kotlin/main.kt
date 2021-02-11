fun main() {
    val unsortedArray = arrayOf(9, 1, 5, 6, 7, 4, 2, 1, 7, 8, 0)
    println("Before sorting ${unsortedArray.joinToString()}")

    val sortedArray = sort(unsortedArray)
    println("After sorting ${sortedArray.joinToString()}")
}

fun sort(array: Array<Int>): Array<Int> {
    quickSort(array, 0, array.size - 1)
    return array
}

fun quickSort(array: Array<Int>, begin: Int, end: Int) {
    if (begin < end) {
        val partitionIndex = partition(array, begin, end)

        // Separately sort elements before and after partition element
        quickSort(array, begin, partitionIndex - 1)
        quickSort(array, partitionIndex + 1, end)
    }
}

fun partition(array: Array<Int>, begin: Int, end: Int): Int {
    val pivot = array[end]
    var smallestElementIndex = begin - 1

    for (currentElementIndex in begin until end) {
        if (array[currentElementIndex] <= pivot) {
            smallestElementIndex++
            swapElementsInArray(array, smallestElementIndex, currentElementIndex)
        }
    }

    val partitionIndex = smallestElementIndex + 1
    swapElementsInArray(array, partitionIndex, end)

    return partitionIndex
}

private fun swapElementsInArray(array: Array<Int>, l: Int, r: Int) {
    val temp = array[l]
    array[l] = array[r]
    array[r] = temp
}
