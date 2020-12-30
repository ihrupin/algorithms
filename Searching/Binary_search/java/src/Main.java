public class Main {

    public static void main(String[] args) {
        int[] sortedArray = {1, 4, 10, 43, 45, 46, 51, 53, 60, 64, 65, 66, 67, 72, 81, 82, 84, 90, 100};

        System.out.println("Result: " + search(sortedArray, 60));
    }

    private static int search(int[] sortedArray, int element) {
        int startIndex = 0;
        int finishIndex = sortedArray.length - 1;


        while (startIndex < finishIndex) {
            int middleIndex = (finishIndex + startIndex) / 2;
            if (sortedArray[middleIndex] == element) {
                return middleIndex;
            } else if (sortedArray[ startIndex] == element) {
                return startIndex;
            } else if (sortedArray[ finishIndex] == element) {
                return finishIndex;
            } else if (sortedArray[ middleIndex] > element) {
                finishIndex = middleIndex - 1;
            } else if (sortedArray[ middleIndex] < element) {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }
}
