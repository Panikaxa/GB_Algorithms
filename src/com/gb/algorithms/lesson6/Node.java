package com.gb.algorithms.lesson6;

public class Node {
    public int number;
    public Node leftChild;
    public Node rightChild;

    public Node(){

    }

    public Node(int number){
        this.number = number;
    }

    public void display(){
        System.out.print("Number: " + number);
    }
}
