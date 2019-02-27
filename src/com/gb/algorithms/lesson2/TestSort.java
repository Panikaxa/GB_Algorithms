package com.gb.algorithms.lesson2;

public class TestSort {
    public static void main(String[] args) {
        MyArray testArr1 = new MyArray(100000);
        MyArray testArr2 = new MyArray(100000);
        MyArray testArr3 = new MyArray(100000);
        long timeStart, timeFinish;

        testArr1.fillRandomArray();
        testArr2.fillRandomArray();
        testArr3.fillRandomArray();

        System.out.println("Массивы для тестирования сортировок");
        testArr1.outputArray();
        System.out.println("------------------------");

        testArr2.outputArray();
        System.out.println("------------------------");

        testArr3.outputArray();
        System.out.println("------------------------");

        System.out.println("Пузырьковая сортировка... ");
        timeStart = System.currentTimeMillis();
        testArr1.bubbleSort();
        timeFinish = System.currentTimeMillis();
        testArr1.outputArray();
        System.out.println("Время выполнения сортировки " + (timeFinish - timeStart) + " ms");
        System.out.println("------------------------");

        System.out.println("Сортировка методом выбора... ");
        timeStart = System.currentTimeMillis();
        testArr2.selectSort();
        timeFinish = System.currentTimeMillis();
        testArr2.outputArray();
        System.out.println("Время выполнения сортировки " + (timeFinish - timeStart) + " ms");
        System.out.println("------------------------");

        System.out.println("Сортировка методом вставки... ");
        timeStart = System.currentTimeMillis();
        testArr3.insertSort();
        timeFinish = System.currentTimeMillis();
        testArr3.outputArray();
        System.out.println("Время выполнения сортировки " + (timeFinish - timeStart) + " ms");
        System.out.println("------------------------");
    }
}
