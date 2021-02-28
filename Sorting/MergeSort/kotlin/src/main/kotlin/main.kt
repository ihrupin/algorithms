fun main() {
    val unsortedArray = arrayOf(10, 5, 7, 4, 1, 2, 5, 18)
    println("Before sorting ${unsortedArray.joinToString()}")

    val sortedArray = sort(unsortedArray)
    println("After sorting ${sortedArray.joinToString()}")
}

fun sort(array: Array<Int>): Array<Int> {
    return mergeSort(array, 0, array.size - 1)
}

fun mergeSort(array: Array<Int>, left: Int, right: Int): Array<Int> {
    if (left < right) {
        val middle = (left + (right - 1)) / 2
        mergeSort(array, left, middle)
        mergeSort(array, middle + 1, right)
        merge(array, left, middle, right)
    }
    return array
}

fun merge(array: Array<Int>, left: Int, middle: Int, right: Int) {
    val leftSubArraySize = middle - left + 1
    val rightSubArraySize = right - middle

    val leftSubArray = IntArray(leftSubArraySize)
    val rightSubArray = IntArray(rightSubArraySize)

    for (i in 0 until leftSubArraySize) {
        leftSubArray[i] = array[left + i]
    }
    for (j in 0 until rightSubArraySize) {
        rightSubArray[j] = array[middle + 1 + j]
    }

    var indexOfLeftSubArray = 0
    var indexOfRightSubArray = 0
    var indexOfMergedArray = left

    while (indexOfLeftSubArray < leftSubArraySize && indexOfRightSubArray < rightSubArraySize) {
        if (leftSubArray[indexOfLeftSubArray] < rightSubArray[indexOfRightSubArray]) {
            array[indexOfMergedArray] = leftSubArray[indexOfLeftSubArray]
            indexOfLeftSubArray++
        } else {
            array[indexOfMergedArray] = rightSubArray[indexOfRightSubArray]
            indexOfRightSubArray++
        }
        indexOfMergedArray++
    }

    while (indexOfLeftSubArray < leftSubArraySize) {
        array[indexOfMergedArray] = leftSubArray[indexOfLeftSubArray]
        indexOfLeftSubArray++
        indexOfMergedArray++
    }

    while (indexOfRightSubArray < rightSubArraySize) {
        array[indexOfMergedArray] = rightSubArray[indexOfRightSubArray]
        indexOfRightSubArray++
        indexOfMergedArray++
    }
}
