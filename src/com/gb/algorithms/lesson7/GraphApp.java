package com.gb.algorithms.lesson7;

public class GraphApp {
    public static void main(String[] args) {
        //Создаем граф
        Graph graph = new Graph(10);
        //Добавляем вершины в граф
        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6
        graph.addVertex('H'); //7
        graph.addVertex('I'); //8
        graph.addVertex('J'); //9
        //Создаем ребра между вершинами
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 6);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);

        System.out.println("Текущий граф:");
        System.out.println("  - B - C");
        System.out.println("A - D - E - F - J");
        System.out.println("  - G - H - I");

        System.out.println("------------------------");
        System.out.println("Вывод графа в глубину...");
        graph.dfs();

        System.out.println();
        System.out.println("------------------------");
        System.out.println("Вывод графа в ширину...");
        graph.bfs();

        System.out.println();
        System.out.println("------------------------");
        System.out.println("Поиск кратчайшего пути между двумя вершинами...");
        graph.bfs('I','C');
    }
}
