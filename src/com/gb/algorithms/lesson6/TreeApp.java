package com.gb.algorithms.lesson6;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TreeApp {

    private static final int NUMBEROFTREES = 20; // Количество деревьев в массиве.
    private static final int DEPTH = 6; // Глубина дерева. Ограничена размером стека

    public static void main(String[] args) {

        List<Tree> list = new ArrayList<>();

        for (int i = 1; i <= NUMBEROFTREES ; i++) {
            Tree tree = new Tree();
            while (tree.depth(tree.getRoot()) != DEPTH) {
                int number = -100 + (int) (Math.random() * 200);
                tree.insert(number);
            }
            list.add(tree);
        }

        //printTrees(list);

        System.out.println("rateBalance " + rateBalance(list));
    }

    /**
     * Метод для расчета процента сбалансированных деревьев в массиве
     * @param list - массив, содержащий деревья
     * @return - процент сбалансированных деревьев в массиве
     */
    public static int rateBalance (@NotNull List<Tree> list) {
        int countBalance = 0;
        for (Tree tree : list) {
            if (tree.isBalance(tree.getRoot())) countBalance++;
        }
        return countBalance * 100 / list.size();
    }

    /**
     * Метод для вывода в консоль массива деревьев
     * @param list - массив, содержащий деревья
     */
    public static void printTrees (@NotNull List<Tree> list) {
        for (Tree tree : list) {
            tree.displayTree();
            System.out.println(tree.isBalance(tree.getRoot()));
            System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////");
        }
    }
}