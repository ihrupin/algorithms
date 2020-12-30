public class Main {

    public static void main(String[] args) {
        int[] sortedArray = {1, 4, 10, 43, 45, 46, 51, 53, 60, 64, 65, 66, 67, 72, 81, 82, 84, 90, 100};

        System.out.println("Result for loop implementation: " + binarySearchLoopImplementation(sortedArray, 60));
        System.out.println("Result for recursive implementation: " + binarySearchRecursively(sortedArray, 60, 0, sortedArray.length - 1));
    }

    private static int binarySearchLoopImplementation(int[] sortedArray, int element) {
        int startIndex = 0;
        int finishIndex = sortedArray.length - 1;

        while (startIndex < finishIndex) {
            int middleIndex = (finishIndex + startIndex) / 2;
            if (sortedArray[middleIndex] == element) {
                return middleIndex;
            } else if (sortedArray[startIndex] == element) {
                return startIndex;
            } else if (sortedArray[finishIndex] == element) {
                return finishIndex;
            } else if (sortedArray[middleIndex] > element) {
                finishIndex = middleIndex - 1;
            } else if (sortedArray[middleIndex] < element) {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursively(int[] sortedArray, int element, int startIndex, int finishIndex) {
        int middleIndex = (startIndex + finishIndex) / 2;

        if (sortedArray[middleIndex] == element) {
            return middleIndex;
        } else if (sortedArray[startIndex] == element) {
            return startIndex;
        } else if (sortedArray[finishIndex] == element) {
            return finishIndex;
        } else if (sortedArray[middleIndex] > element) {
            return binarySearchRecursively(sortedArray, element, 0, middleIndex - 1);
        } else if (sortedArray[ middleIndex] < element) {
            return binarySearchRecursively(sortedArray, element, middleIndex + 1, 0);
        }
        return -1;
    }
}
