def swapElementsInArray(array, i, j):
    array[i], array[j] = array[j], array[i]

def partition(array, min, max):
    smallestElementIndex = (min-1)
    pivotIndex = max
    pivot = array[pivotIndex]

    for currentElementIndex in range(min, pivotIndex):
        if array[currentElementIndex] <= pivot:
            smallestElementIndex +=1
            swapElementsInArray(array, smallestElementIndex, currentElementIndex)
 
    partitionElementIndex = smallestElementIndex+1
    swapElementsInArray(array, partitionElementIndex, pivotIndex)

    return partitionElementIndex


def quickSort(array, min, max):
    if min < max:
        partitionElementIndex = partition(array, min, max)
 
        # Separately sort elements before and after partition element
        quickSort(array, min, partitionElementIndex-1)
        quickSort(array, partitionElementIndex+1, max)

def sort(array):
    minIndex = 0
    maxIndex = len(array)-1
    quickSort(array, minIndex, maxIndex)
    return array
 
 
# Testing
unsortedArray = [10, 5, 7, 4, 1, 2, 5, 18, 9, 8, 3, 10]
print("before: {}".format(unsortedArray))
sortedArray = sort(unsortedArray)
print("sorted array: {}".format(sort(sortedArray)))