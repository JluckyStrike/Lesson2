package com.gb.lesson2;

import java.io.Console;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //replace0to1And1to0(new int[] {1, 0, 0, 0, 1});
        //fillArray(new int[8]);
        //numberLess6Multiply2(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        //diagMatrix();
        //findMinAndMaxNum(new int[] {1, -1, 24, 55, 44, 23});
        // System.out.println(isLeftAndRightPartsEqual(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));

        shiftArray(new int[]{3, 5, 6, 1}, -2);
    }

    // Задание 1
    public static void replace0to1And1to0(int[] array) {
        System.out.println("Было: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }

        System.out.println("Стало:" + Arrays.toString(array));
    }

    // Задание 2
    public static void fillArray(int[] array) {
        for (int i = 0; i <= 21; i += 3)
            array[i / 3] = i;

        System.out.println("Результат: " + Arrays.toString(array));
    }

    // Задание 3
    public static void numberLess6Multiply2(int[] array) {
        System.out.println("Было: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) array[i] *= 2;

        System.out.println("Стало:" + Arrays.toString(array));
    }

    // Задание 4
    public static void diagMatrix() {
        int[][] matrix = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int n = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][n] = 1;
            n -= 1;
        }

        outputMatrix(matrix);
    }

    // Задание 5
    public static void findMinAndMaxNum(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }

        System.out.println("Макс. " + max + " : Мин. " + min);

        /*Также можно воспользоваться сортировкой и вывести первый и последний элемент
         * Я просто не знаю, можно ли в этом задании пользоватьсь сторонними методами*/
    }

    // Заданиее 6
    public static boolean isLeftAndRightPartsEqual(int[] array) {
        int arrSum = 0;

        // Для начала найдем сумму  массива
        for (int el : array) {
            arrSum += el;
        }

        // далее из текущей левой части будем вычитать сумму массива
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];

            // Если сумма массива и левой части равны => части равны
            if (leftSum == arrSum - leftSum)
                return true;
        }

        return false;
    }


    //Задание 7
    public static void shiftArray(int[] array, int n) {

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tmp = array[array.length - 1];

                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }

                array[0] = tmp;
            }
        } else {
            n *= -1;
            for (int i = 0; i < n; i++) {
                int tmp = array[0];

                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }

                array[array.length - 1] = tmp;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void outputMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
