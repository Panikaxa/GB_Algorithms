package com.gb.algorithms.lesson5;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(powerOfNumber(4,4));
    }

    private static int powerOfNumber(int number, int power) {
        if (power == 1)
            return number;
        return number * powerOfNumber(number, --power);
    }
}
