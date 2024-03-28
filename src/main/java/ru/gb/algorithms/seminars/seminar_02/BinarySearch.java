package ru.gb.algorithms.seminars.seminar_02;

public class BinarySearch {
    public static void main(String[] args) {
        final int SIZE = 20_000;
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        quickSort(array);
        System.out.println(binarySearch(array, 42));
    }

    // Бинарный поиск
    public static Integer binarySearch(int[] array, int value) {
        int left = 0, right = array.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (array[mid] < value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] == value) {
            return left;
        }
        if (array[right] == value) {
            return right;
        }

        return null;
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        do {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) {
            quickSort(array, left, j);
        }
        if (i <= right) {
            quickSort(array, i, right);
        }
    }
}
