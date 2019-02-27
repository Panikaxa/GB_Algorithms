package com.gb.algorithms.lesson3;

public class Deque {
    private int maxSize;
    private int[] deque;
    private int markFirst;
    private int markLast;
    private int items; //количество элементов в очереди

    public Deque(int size) {
        this.maxSize = size;
        this.deque = new int[this.maxSize];
        this.markFirst = maxSize -1;
        this.markLast = 0;
        this.items = 0;
    }

    public boolean isEmpty(){
        return (this.items == 0);
    }

    public boolean isFull(){
        return (this.items == this.maxSize);
    }

    public int size() {
        return this.items;
    }

    public void insertFirst(int value){

        if (isFull()) {
            System.out.println("Переполнение очереди. Элемент " + value + " не добавлен.");
        } else {
            if (markFirst != -1) {
            } else if (markLast != -1) {
                markFirst = markLast;
            }
            if (markFirst == maxSize-1) {
                markFirst = -1;
            }
            deque[++markFirst] = value;
            items++;
        }
    }

    public void insertLast(int value){

        if (isFull()) {
            System.out.println("Переполнение очереди. Элемент " + value + " не добавлен.");
        } else {
            if (markLast != -1) {
            } else if (markFirst != -1) {
                markLast = markFirst;
            }
            if (markLast <= 0) {
                markLast = maxSize;
            }
            deque[--markLast] = value;
            items++;
        }
    }

    public int removeFirst() {
        int temp = deque[markFirst--];
        if (isEmpty()) {
            System.out.println("Очередь пуста. Невозможно удалить элемент");
        } else {

            if (markFirst == -1) markFirst = maxSize-1;
            items--;
        }
        return temp;
    }

    public int removeLast() {
        int temp = deque[markLast++];
        if (isEmpty()) {
            System.out.println("Очередь пуста. Невозможно удалить элемент");
        } else {

            if (markLast == maxSize) markLast = 0;
            items--;
        }
        return temp;
    }

    public int peekLast(){
        return deque[markLast];
    }

    public int peekFirst(){
        return deque[markFirst];
    }
}
