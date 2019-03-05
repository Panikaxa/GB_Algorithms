package com.gb.algorithms.lesson4;

public class DoubleLinkedListApp {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertFirst("Artem", 22);
        list.insertFirst("Anton", 33);
        list.insertFirst("Sergey", 44);
        list.insertLast("Georgy", 55);

        list.display();

        System.out.println();
        list.find("Anton").display();

        System.out.println();
        if (!list.isEmpty()) list.delete();
        list.display();

        System.out.println();
        list.delete("Artem");
        list.display();
    }
}
