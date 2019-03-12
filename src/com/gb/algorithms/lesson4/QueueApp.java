package com.gb.algorithms.lesson4;

public class QueueApp {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert("Artem", 22);
        q.insert("Anton", 33);
        q.insert("Sergey", 44);

        q.display();

        System.out.println();
        while (!q.isEmpty()) {
            System.out.println("Элемент " + q.delete() + " удален из очереди");
        }
    }
}
