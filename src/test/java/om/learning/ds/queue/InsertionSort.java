package om.learning.ds.queue;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] listOfIntegers = IntStream.generate(() -> (int) (Math.random() * 10)).limit(10).boxed().toList().toArray(new Integer[0]);

        System.out.println(Arrays.stream(listOfIntegers).toList());
        insertionSort(listOfIntegers);
    }

    private static void insertionSort(Integer[] array) {
        int start = 1;
        int end = array.length;
        for (int i = start; i < end; i++) {
            int key = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
            //System.out.println(" key " + key + " new array " + Arrays.stream(array).toList());
        }
        System.out.println(Arrays.stream(array).toList());
    }

}

