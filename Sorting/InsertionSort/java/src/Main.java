import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortedArray = new int[] {9, 1, 5, 6, 7, 4, 2, 1, 7, 8, 0};
        System.out.println("Before sorting=" + Arrays.toString(unsortedArray));

        int[] sortedArray = sort(unsortedArray);

        System.out.println("After sorting=" + Arrays.toString(sortedArray));
    }

    private static int[] sort(int[] array) {
        for(int index = 1; index < array.length; index++) {
            int tempIndex = index;

            while (tempIndex > 0 && array[tempIndex] < array[tempIndex - 1]) {
                int temp = array[tempIndex - 1];
                array[tempIndex - 1] = array[tempIndex];
                array[tempIndex] = temp;
                tempIndex--;
            }
        }
        return array;
    }
}
