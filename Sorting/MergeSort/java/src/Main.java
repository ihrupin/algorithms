import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortedArray = new int[] {10, 5, 7, 4, 1, 2, 5, 18};
        System.out.println("Before sorting=" + Arrays.toString(unsortedArray));

        int[] sortedArray = sort(unsortedArray);

        System.out.println("After sorting=" + Arrays.toString(sortedArray));
    }

    private static int[] sort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + (right - 1)) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
        return array;
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int leftSubArraySize = middle - left + 1;
        int rightSubArraySize = right - middle;

        int[] leftSubArray = new int[leftSubArraySize];
        int[] rightSubArray = new int[rightSubArraySize];

        for (int i = 0; i < leftSubArraySize; i++) {
            leftSubArray[i] = array[left + i];
        }

        for (int j = 0; j < rightSubArraySize; j++) {
            rightSubArray[j] = array[middle + 1 + j];
        }

        int indexOfLeftSubArray = 0;
        int indexOfRightSubArray = 0;
        int indexOfMergedArray = left;

        while (indexOfLeftSubArray < leftSubArraySize && indexOfRightSubArray < rightSubArraySize) {
            if (leftSubArray[indexOfLeftSubArray] < rightSubArray[indexOfRightSubArray]){
                array[indexOfMergedArray] = leftSubArray[indexOfLeftSubArray];
                indexOfLeftSubArray++;
            } else {
                array[indexOfMergedArray] = rightSubArray[indexOfRightSubArray];
                indexOfRightSubArray++;
            }
            indexOfMergedArray++;
        }

        while (indexOfLeftSubArray < leftSubArraySize) {
            array[indexOfMergedArray] = leftSubArray[indexOfLeftSubArray];
            indexOfLeftSubArray++;
            indexOfMergedArray++;
        }

        while (indexOfRightSubArray < rightSubArraySize) {
            array[indexOfMergedArray] = rightSubArray[indexOfRightSubArray];
            indexOfRightSubArray++;
            indexOfMergedArray++;
        }
    }
}
