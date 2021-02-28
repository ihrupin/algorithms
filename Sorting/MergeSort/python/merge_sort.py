def merge(array, left, middle, right):
    leftSubarraySize = middle - left + 1
    rightSubarraySize = right - middle

    leftTempSubarray = [0] * (leftSubarraySize)
    rightTempSubarray = [0] * (rightSubarraySize)

    for i in range(0, leftSubarraySize):
        leftTempSubarray[i] = array[left + i]

    for j in range(0, rightSubarraySize):
        rightTempSubarray[j] = array[middle + 1 + j]

    indexOfLeftSubarray = 0
    indexOfRightSubarray = 0
    indexOfMergedArray = left

    while indexOfLeftSubarray < leftSubarraySize and indexOfRightSubarray < rightSubarraySize:
        if leftTempSubarray[indexOfLeftSubarray] < rightTempSubarray[indexOfRightSubarray]:
            array[indexOfMergedArray] = leftTempSubarray[indexOfLeftSubarray]
            indexOfLeftSubarray += 1
        else:
           array[indexOfMergedArray] = rightTempSubarray[indexOfRightSubarray]
           indexOfRightSubarray += 1
        indexOfMergedArray += 1

    while indexOfLeftSubarray < leftSubarraySize: 
        array[indexOfMergedArray] = leftTempSubarray[indexOfLeftSubarray]
        indexOfLeftSubarray += 1
        indexOfMergedArray += 1

    while indexOfRightSubarray < rightSubarraySize: 
        array[indexOfMergedArray] = rightTempSubarray[indexOfRightSubarray]
        indexOfRightSubarray += 1
        indexOfMergedArray += 1

def mergeSort(array, left, right):
    if left < right:
        middle = (left + (right - 1)) // 2

        mergeSort(array, left, middle)
        mergeSort(array, middle + 1, right)

        merge(array, left, middle, right)

    return array


def sort(array):
    return mergeSort(array, 0, len(array) - 1)
 
 
# Testing
unsortedArray = [10, 5, 7, 4, 1, 2, 5, 18]
print("before: {}".format(unsortedArray))
sortedArray = sort(unsortedArray)
print("sorted array: {}".format(sort(sortedArray)))