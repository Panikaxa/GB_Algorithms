package com.gb.algorithms.lesson7;

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        System.out.println("  -> B ------> C ->");
        System.out.println("A -> D -> E -> F -> J");
        System.out.println("  -> G -> H -> I ->");

        System.out.println();
        System.out.println("Вывод графа в глубину");
        graph.dfs();
        System.out.println();
        System.out.println("Вывод графа в ширину");
        graph.bfs('A', 'J');

    }
}
