package com.gb.algorithms.lesson3;

public class Queue {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items; //количество элементов в очереди

    public Queue(int size) {
        this.maxSize = size;
        this.queue = new int[this.maxSize];
        this.front = 0;
        this.rear = -1;
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

    public void insert(int value){
        if (isFull()) {
            System.out.println("Переполнение очереди. Элемент " + value + " не добавлен.");
        } else {
            if (rear == maxSize-1) rear = -1;
            queue[++rear] = value;
            items++;
        }

    }

    public int remove() {
        int temp = queue[front++];
        if (isEmpty()) {
            System.out.println("Очередь пуста. Невозможно удалить элемент");
        } else {

            if (front == maxSize) front = 0;
            items--;
        }
        return temp;
    }

    public int peek(){
        return queue[front];
    }
}
