package com.gb.algorithms.lesson3;

public class Stack {
    private int maxSize; // максимальный размер стека
    private char[] stack; // массив для хранения стека
    private int top; //позиция элемента LIFO

    public Stack(int size) {
        this.maxSize = size;
        this.stack = new char[this.maxSize];
        this.top = -1; // позиция -1 = стек пустой
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }

    public void push(char value) {
        this.stack[++this.top] = value;
    }

    public char pop() {
        return this.stack[this.top--];
    }

    public char peek() {
        return this.stack[this.top];
    }
}
