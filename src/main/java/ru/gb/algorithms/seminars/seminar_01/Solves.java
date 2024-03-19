package ru.gb.algorithms.seminars.seminar_01;

import java.util.ArrayList;
import java.util.Date;

public class Solves {
    public static void main(String[] args) {
//        System.out.println(sum(10));

//        ArrayList<Integer> result = findSimpleNumbers(100);
//        for (Integer i : result) {
//            System.out.println(i);
//        }

//        System.out.println(comb_1(6));
//        System.out.println(comb_2(4, 6));

//        System.out.println(fib_rec(10));

//        System.out.println(fib_rec(10));
//        System.out.println(fib_lin(10));

        test();
    }

    public static void test() {
        for (int n = 10; n <= 45; n++) {
            Date start = new Date();
            fib_rec(n);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            fib_lin(n);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("n: %d, rec: %d, lin: %d%n", n, time1, time2);
        }
    }

    public static int fib_lin(int n) {
        final int[] numbers = new int[n + 1];
        numbers[1] = 1;
        numbers[2] = 1;
        for (int i = 3; i <= n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers[n];
    }

    public static int fib_rec(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fib_rec(n - 1) + fib_rec(n - 2);
    }

    private static int comb_2_rec(int h, int k, int n) {
        if (h == k + 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += comb_2_rec(h + 1, k, n);
        }
        return count;
    }

    public static int comb_2(int k, int n) {
        if (k > 0) {
            return comb_2_rec(1, k, n);
        }

        return 0;
    }

    public static int comb_1(int n) {
        // k = 4
        int count = 0;
        // O(n^4)
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static ArrayList<Integer> findSimpleNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean simple = true;
        for (int i = 2; i <= n; i++) {
            simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }

        return result;
    }

    public static int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
