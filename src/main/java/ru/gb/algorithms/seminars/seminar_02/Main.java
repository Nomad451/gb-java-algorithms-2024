package ru.gb.algorithms.seminars.seminar_02;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 20_000;
        int[] array1 = new int[SIZE];
        int[] array2 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array1[i] = (int) (Math.random() * 100);
            array2[i] = array1[i];
        }

        Date start = new Date();
        bubbleSort(array1);
        Date end = new Date();
        long time1 = end.getTime() - start.getTime();

        start = new Date();
        quickSort(array2);
        end = new Date();
        long time2 = end.getTime() - start.getTime();

        System.out.printf("time1 = %d, time2 = %d%n ", time1, time2);
    }

    // Пузырьковая сортировка
    public static void bubbleSort(int[] array) {
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    needSort = true;
                }
            }
        } while (needSort);
    }

    // Быстрая сортировка
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
