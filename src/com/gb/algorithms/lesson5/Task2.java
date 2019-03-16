package com.gb.algorithms.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    static class Item {
        private int weight;
        private int value;
        private String name;

        public Item(int weight, int value, String name) {
            this.weight = weight;
            this.value = value;
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    static class Backpack {

        private int size; //максимальная вместимость рюкзака
        private int bestValue; //ценность наиболее подходящего набора объектов
        private List<Item> bestSetOfItems = null; //наиболее подходящий набор объектов

        public Backpack(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        /**
         * Метод, возвращающий суммарный вес объектов в наборе
         * @param setOfItems - набор объектов
         * @return - суммарный вес объектов в наборе
         */
        public int calcWeight(List<Item> setOfItems) {
            int weight = 0;
            for (Item arr : setOfItems) {
                weight += arr.getWeight();
            }
            return weight;
        }

        /**
         * Метод, возвращающий суммарную ценность объектов в наборе
         * @param setOfItems - набор объектов
         * @return - суммарная ценность объектов в наборе
         */
        public int calcValue(List<Item> setOfItems) {
            int value = 0;
            for (Item item : setOfItems) {
                value += item.getValue();
            }
            return value;
        }

        /**
         * Метод для поиска наиболее подходящего набора объектов
         * @param setOfItems - набор объектов
         */
        public void checkBestSet(List<Item> setOfItems){
            if (bestSetOfItems == null) {
                if (calcWeight(setOfItems) <= this.size) {
                    bestSetOfItems = setOfItems;
                    bestValue = calcValue(setOfItems);
                }
            } else {
                if (calcWeight(setOfItems) <= this.size && calcValue(setOfItems) > bestValue) {
                    bestSetOfItems = setOfItems;
                    bestValue = calcValue(setOfItems);
                }
            }
        }

        /**
         * Рекурсивный метод, проверяющий все возможные комбинации объектов.
         * @param setOfItems - набор объектов
         */
        public void checkAllSets(List<Item> setOfItems){
            if(setOfItems.size() > 0)
                checkBestSet(setOfItems);

            for (int i = 0; i < setOfItems.size(); i++) {
                List<Item> nextSet = new ArrayList<>(setOfItems);
                nextSet.remove(i);
                checkAllSets(nextSet);
            }
        }

        /**
         * Метод выводит на экран содержимое рюкзака
         */
        public void display(){
            if (bestSetOfItems != null){
                for (Item item : bestSetOfItems) {
                    System.out.print(item.getName() + " ");
                }
            } else {
                System.out.println("Упс! Пусто...");
            }
        }
    }

    public static void main(String[] args) {

        List<Item> setOfItems = new ArrayList<>();
        setOfItems.add(new Item(7, 8, "Мяч"));
        setOfItems.add(new Item(24, 9, "Книга"));
        setOfItems.add(new Item(6, 10, "Удочка"));
        setOfItems.add(new Item(16, 4, "Сапоги"));
        setOfItems.add(new Item(8, 5, "Скрипка"));


        Backpack backpack = new Backpack(22);

        backpack.checkAllSets(setOfItems);

        System.out.println("В рюкзаке находятся следующие предметы:");
        backpack.display();
    }
}