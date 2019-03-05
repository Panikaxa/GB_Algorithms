package com.gb.algorithms.lesson4;

public class StackListApp {
    public static void main(String[] args) {
        StackList stack = new StackList();
        stack.push("Artem", 22);
        stack.push("Anton", 33);
        stack.push("Sergey", 44);

        stack.display();

        System.out.println();
        while (!stack.isEmpty()) {
            System.out.println("Элемент " + stack.pop() + " удален из стека");
        }

    }
}
