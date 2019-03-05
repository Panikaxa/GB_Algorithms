package com.gb.algorithms.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    private static String input;

    public static void main(String[] args) throws IOException {
        System.out.println("Введите строку");
        input = getString();
        System.out.println("Преобразованная строка:");
        check();
    }

    public static void check(){
        int size = input.length();
        Stack st = new Stack(size);

        for (int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            st.push(ch);
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

}

