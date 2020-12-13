import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortedArray = new int[] {9, 1, 5, 6, 7, 4, 2, 1, 7, 8, 0};
        System.out.println("Before sorting=" + Arrays.toString(unsortedArray));

        int[] sortedArray = sort(unsortedArray);

        System.out.println("After sorting=" + Arrays.toString(sortedArray));
    }

    public static int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            // Separately sort elements before and after partition element
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int smallestElementIndex = begin - 1;

        for (int currentElementIndex = begin; currentElementIndex < end; currentElementIndex++) {
            if (array[currentElementIndex] <= pivot) {
                smallestElementIndex++;

                swapElementsInArray(array, smallestElementIndex, currentElementIndex);
            }
        }

        int partitionIndex = smallestElementIndex + 1;
        swapElementsInArray(array, partitionIndex, end);

        return partitionIndex;
    }

    private static void swapElementsInArray(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
