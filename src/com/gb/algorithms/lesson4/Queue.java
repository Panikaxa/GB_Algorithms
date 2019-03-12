package com.gb.algorithms.lesson4;

public class Queue {
    private DoubleLinkedList queue;

    public Queue(){
        queue = new DoubleLinkedList();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(String name, int age){
        queue.insertLast(name, age);
    }

    public String delete() {
        return queue.delete().name;
    }

    public void display(){
        queue.display();
    }
}
