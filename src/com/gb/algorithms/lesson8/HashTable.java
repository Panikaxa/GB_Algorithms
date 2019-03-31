package com.gb.algorithms.lesson8;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Item>[] hashArr;
    private int arrSize;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = new LinkedList[arrSize];
    }

    public void display(){
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null){
                for (Item list : hashArr[i]) {
                    System.out.print(list.getKey() + " ");
                }
            } else {
                System.out.print("*** ");
            }
            System.out.println();
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }


    public boolean find(int key){
        int hashVal = hashFunc(key);
        for (Item list : hashArr[hashVal]) {
            if (list.getKey() == key){
                return hashArr[hashVal].contains(list);
            }
        }
        return false;
    }

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] == null){
            LinkedList<Item> list = new LinkedList<>();
            hashArr[hashVal] = list;
        }
        hashArr[hashVal].add(item);
    }

    public boolean delete(int key){
        int hashVal = hashFunc(key);
        for (Item list : hashArr[hashVal]) {
            if (list.getKey() == key){
                return hashArr[hashVal].remove(list);
            }
        }
        return false;
    }

}
