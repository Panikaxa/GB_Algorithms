package com.gb.algorithms.lesson3;

public class TestDeque {
    public static void main(String[] args) {
        Deque dq = new Deque(5);
        dq.insertFirst(1);
        dq.insertLast(2);
        dq.insertFirst(3);
        dq.insertLast(4);
        dq.insertLast(5);

        while (!dq.isEmpty()) {
            System.out.print(dq.removeFirst() + " ");
        }

    }
}
