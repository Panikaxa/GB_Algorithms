package com.gb.algorithms.lesson7;

public class Stack {
    private int maxSize; // максимальный размер стека
    private int[] stack; // массив для хранения стека
    private int top; //позиция элемента LIFO

    public Stack(int size) {
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1; // позиция -1 = стек пустой
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }

    public void push(int value) {
        this.stack[++this.top] = value;
    }

    public int pop() {
        return this.stack[this.top--];
    }

    public int peek() {
        return this.stack[this.top];
    }
}
