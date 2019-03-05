package com.gb.algorithms.lesson3;

public class TestStack {
    public static void main(String[] args) {
        Stack st = new Stack(5);
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
