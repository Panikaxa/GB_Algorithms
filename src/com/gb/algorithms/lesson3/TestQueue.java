package com.gb.algorithms.lesson3;

public class TestQueue {
    public static void main(String[] args) {
        Queue qu = new Queue(5);
        qu.insert(1);
        qu.insert(2);
        qu.insert(3);
        qu.insert(4);
        qu.insert(5);
        qu.remove();
        qu.insert(6);

        while (!qu.isEmpty()) {
            System.out.println(qu.remove());
        }
    }
}
