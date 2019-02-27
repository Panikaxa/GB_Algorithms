package com.gb.algorithms.lesson2;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int length) {
        size = 0;
        array = new int[length];
    }

    public void fillRandomArray(){
        size = array.length;
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public void addElement(int value) {
        array[size] = value;
        size++;
    }

    public void delElement(int value) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == value) break;
        }
        if (i == array.length) System.out.println("Искомое значение не найдено");

        for (int j = i; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        size--;

    }

    public void outputArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void linearSearch(int value) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == value) break;
        }
        if (i == array.length) {
            System.out.println("Искомое значение не найдено");
        } else {
            System.out.println("Искомое значение найдено под индексом " + i);
        }
    }

    public void binarySearch(int value) {
        int low = 0;
        int high = size - 1;
        int middle;
        boolean check = false;
        while (low <= high) {
            middle = (low + high) / 2;
            if (value == array[middle]) {
                check = true;
                System.out.println("Искомое значение найдено под индексом " + middle);
                break;
            } else {
                if (value < array[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        if (!check) System.out.println("Искомое значение не найдено");
    }

    public void bubbleSort() {
        int in, out;
        for (out = size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
    }

    public void selectSort() {
        int out, in, marker;
        for (out = 0; out < size; out++) {
            marker = out;
            for (in = out + 1; in < size; in++) {
                if (array[in] < array[marker]) marker = in;
            }
            int temp = array[out];
            array[out] = array[marker];
            array[marker] = temp;
        }
    }

    public void insertSort() {
        int in, out;
        for (out = 1; out < size; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp){
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}
