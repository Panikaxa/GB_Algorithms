package com.gb.algorithms.lesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashApp {
    public static void main(String[] args) throws IOException {
        Item aDataItem;
        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();

        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 100;

        HashTable hashTable = new HashTable(size);
        for (int i = 0; i < n; i++) {
            aKey = (int)(Math.random() * keysPerCell * size);
            aDataItem = new Item(aKey);
            hashTable.insert(aDataItem);
        }
        while(true){
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete or find: ");
            char choise = getChar();
            switch (choise){
                case 's':
                    hashTable.display();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Item(aKey);
                    hashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    if (hashTable.delete(aKey))
                        System.out.println("Successfully deleted " + aKey);
                    else
                        System.out.println("Could not deleted " + aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    if (hashTable.find(aKey)){
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could not find " + aKey);
                    }
                    break;
                default:
                    System.out.println("Invalid entry \n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
