package com.gb.algorithms.lesson4;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("Artem", 22);
        list.insert("Anton", 33);
        list.insert("Sergey", 44);

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
