package com.gb.algorithms.lesson4;

public class ListIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListIterator iter = new ListIterator(list);
        iter.insertAfter("Artem", 22);
        iter.insertAfter("Anton", 33);
        iter.insertBefore("Sergey", 44);
        list.display();
        System.out.println("---------------------------------");

        System.out.println("Позиция итератора");
        iter.getCurrent().display();
        System.out.println("---------------------------------");

        System.out.println("Позиция итератора, после смещения");
        iter.nextLink();
        iter.getCurrent().display();
        System.out.println("---------------------------------");

        System.out.println("Позиция итератора после команды reset");
        iter.reset();
        iter.getCurrent().display();
        System.out.println("---------------------------------");

        System.out.println("Удален элемент " +  iter.deleteCurrent());
        System.out.println("Вывод списка после удаления элемента");
        list.display();




    }
}
