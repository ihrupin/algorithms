def binarySearchLoopImplementation(sortedArray, element):
    startIndex = 0
    finishIndex = len(sortedArray) - 1

    while startIndex < finishIndex:
        middleIndex = int((finishIndex + startIndex) / 2)
        if sortedArray[middleIndex] == element:
            return middleIndex
        elif sortedArray[startIndex] == element:
            return startIndex
        elif sortedArray[finishIndex] == element:
            return finishIndex
        elif sortedArray[middleIndex] > element:
            finishIndex = middleIndex - 1
        elif sortedArray[middleIndex] < element:
            startIndex = middleIndex + 1

def binarySearchRecursively(sortedArray, element, startIndex, finishIndex):
    middleIndex = int((finishIndex + startIndex) / 2)
    if sortedArray[middleIndex] == element:
        return middleIndex
    elif sortedArray[startIndex] == element:
        return startIndex
    elif sortedArray[finishIndex] == element:
        return finishIndex
    elif sortedArray[middleIndex] > element:
        return binarySearchRecursively(sortedArray, element, startIndex, middleIndex - 1)
    elif sortedArray[middleIndex] < element:
        return binarySearchRecursively(sortedArray, element, middleIndex + 1, finishIndex)

array = [1, 4, 10, 43, 45, 46, 51, 53, 60, 64, 65, 66, 67, 72, 81, 82, 84, 90, 100]

print("Result for recursively implementation:", binarySearchRecursively(array, 4, 0, len(array) - 1))
print("Result for loop implementation:", binarySearchLoopImplementation(array, 4))