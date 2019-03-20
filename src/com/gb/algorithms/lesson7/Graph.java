package com.gb.algorithms.lesson7;

public class Graph {
    //private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int size;
    private Stack stack;
    private Queue queue;

    public Graph(int maxVertex){
        stack = new Stack(maxVertex);
        queue = new Queue(maxVertex);
        vertexList = new Vertex[maxVertex];
        adjMatrix = new int[maxVertex][maxVertex];
        size = 0;
        for (int i = 0; i < maxVertex; i++) {
            for (int j = 0; j < maxVertex; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge (int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.print(vertexList[vertex].label);
    }

    public int getVertex(char vertex){
        for (int i = 0; i < size; i++) {
            if (vertexList[i].label == vertex){
                return i;
            }
        }
        return -1;
    }

    private int getAdjUnvisitedVertex(int vertex){
        for (int i = 0; i < size; i++) {
            if (adjMatrix[vertex][i] == 1 && !vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }

    private int getAdjVisitedVertex(int vertex){
        for (int i = 0; i < size; i++) {
            if (adjMatrix[vertex][i] == 1 && vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        System.out.print("->");
        stack.push(0);
        int p = 0;
        while (!stack.isEmpty()){
            int adjUnvisitedVertex = getAdjUnvisitedVertex(stack.peek());
            if (adjUnvisitedVertex == -1){
                stack.pop();
                p++;
            } else {
                vertexList[adjUnvisitedVertex].wasVisited = true;
                if (p != 0) {
                    System.out.println();
                    for (int i = 0; i < p; i++) {
                        System.out.print("    ");
                    }
                    p = 0;
                }
                displayVertex(adjUnvisitedVertex);
                System.out.print("->");
                stack.push(adjUnvisitedVertex);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int adjUnvisitedVertex;
        while (!queue.isEmpty()){
            int firstVertex = queue.remove();
            while ((adjUnvisitedVertex = getAdjUnvisitedVertex(firstVertex)) != -1){
                vertexList[adjUnvisitedVertex].wasVisited = true;
                displayVertex(adjUnvisitedVertex);
                queue.insert(adjUnvisitedVertex);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public boolean bfs(char start, char end){
        int first = getVertex(start);
        int last = getVertex(end);
        Stack stack = new Stack(size);
        vertexList[first].wasVisited = true;
        queue.insert(first);
        int adjUnvisitedVertex;
        while (!queue.isEmpty()){
            int firstVertex = queue.remove();
            stack.push(firstVertex);
            while ((adjUnvisitedVertex = getAdjUnvisitedVertex(firstVertex)) != -1){
                vertexList[adjUnvisitedVertex].wasVisited = true;
                queue.insert(adjUnvisitedVertex);
                if (adjUnvisitedVertex == last){
                    stack.push(last);
                    displayVertex(last);
                    while (!stack.isEmpty()){
                        int adjVisitedVertex = getAdjVisitedVertex(stack.peek());
                        if (adjUnvisitedVertex == -1){
                            stack.pop();
                        } else {
                            vertexList[adjVisitedVertex].wasVisited = false;
                            displayVertex(adjVisitedVertex);
                            stack.push(adjVisitedVertex);
                        }

                    }
                    return true;
                }
            }
        }


        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
        //while (!stack.isEmpty()) displayVertex(stack.pop());
        return false;
    }
}
