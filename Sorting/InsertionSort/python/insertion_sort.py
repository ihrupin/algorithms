def sort(array):
    for index in range(1, len(array)):
        tempIndex = index
        
        while tempIndex > 0 and array[tempIndex] < array[tempIndex - 1]:
            array[tempIndex],array[tempIndex - 1] = array[tempIndex - 1],array[tempIndex]
            tempIndex -= 1

    return array
 
 
# Testing
unsortedArray = [10, 5, 7, 4, 1, 2, 5, 18, 9, 8, 3, 10]
print("before: {}".format(unsortedArray))
sortedArray = sort(unsortedArray)
print("sorted array: {}".format(sort(sortedArray)))