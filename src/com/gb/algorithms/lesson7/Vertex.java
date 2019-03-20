package com.gb.algorithms.lesson7;

public class Vertex {
    public char label; // Название вершины
    public boolean wasVisited; // Статус вершины (была посещена при обходе, либо нет)
    public int parent; // Индекс вершины, из которой был сделан переход в текущюю

    public Vertex(char label){
        this.label = label;
        this.wasVisited = false;
        parent = -1;
    }
}
