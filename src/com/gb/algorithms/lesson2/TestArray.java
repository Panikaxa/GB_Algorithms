package com.gb.algorithms.lesson2;

public class TestArray {
    public static void main(String[] args) {
        MyArray arr = new MyArray(5);
        arr.addElement(4);
        arr.addElement(7);
        arr.addElement(3);
        arr.addElement(1);
        arr.addElement(2);

        System.out.println("Вывод массива:");
        arr.outputArray();
        System.out.println("------------------------");

        int value = 3; //значение элемента для поиска и удаления.

        System.out.println("Начинаем линейный поиск значения " + value + " ...");
        arr.linearSearch(value);
        System.out.println("------------------------");

        System.out.println("Пузырьковая сортировка... ");
        arr.bubbleSort();
        arr.outputArray();
        System.out.println("------------------------");

        System.out.println("Начинаем бинарный поиск значения " + value + " ...");
        arr.binarySearch(value);
        System.out.println("------------------------");

        System.out.println("Удаляем элемент " + value + " из массива...");
        arr.delElement(value);
        arr.outputArray();
        System.out.println("------------------------");

    }
}
