def search(sortedArray, element):
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

array = [1, 4, 10, 43, 45, 46, 51, 53, 60, 64, 65, 66, 67, 72, 81, 82, 84, 90, 100]

print("Result:", search(array, 60))