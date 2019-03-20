package com.gb.algorithms.lesson7;

public class Graph {
    private Vertex[] vertexList; // массив вершин
    private int[][] adjMatrix; // матрица смежности вершин
    private int size; // текущий размер массива вершин
    private Stack stack; // Стэк для метода поиска в глубину
    private Queue queue; // Очередь для метода поиска в ширину
    private Stack pathStack; // Стэк для вывода кратчайшего пути

    public Graph(int maxVertex){ // maxVertex - максимальный размер графа
        stack = new Stack(maxVertex);
        queue = new Queue(maxVertex);
        pathStack = new Stack(maxVertex);
        vertexList = new Vertex[maxVertex];
        adjMatrix = new int[maxVertex][maxVertex];
        size = 0;
        for (int i = 0; i < maxVertex; i++) {
            for (int j = 0; j < maxVertex; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    /**
     * Метод добавляет вершину в массив вершин
     * @param label - название вершины
     */
    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    /**
     * Метод добавляет ребро между двумя вершинами
     * @param start - начальная вершина
     * @param end - конечная вершина
     */
    public void addEdge (int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    /**
     * Метод выводит в консоль название вершины по индексу
     * @param vertex - индекс вершины в массиве вершин
     */
    public void displayVertex(int vertex){
        System.out.print(vertexList[vertex].label);
    }

    /**
     * Метод возвращает индекс вершины в массиве по указаному названию.
     * Если указанная вершина отсутствует в массиве возвращает -1
     * @param vertex - название вершины
     * @return
     */
    public int getIndexVertex(char vertex){
        for (int i = 0; i < size; i++) {
            if (vertexList[i].label == vertex){
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод возвращает индекс смежной непосещенной вершины для указанной вершины
     * @param vertex - вершина для поиска смежной ей вершины
     * @return
     */
    private int getAdjUnvisitedVertex(int vertex){
        for (int i = 0; i < size; i++) {
            if (adjMatrix[vertex][i] == 1 && !vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод для обхода графа в глубину (Depth First Search)
     */
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int adjUnvisitedVertex = getAdjUnvisitedVertex(stack.peek());
            if (adjUnvisitedVertex == -1){
                stack.pop();
            } else {
                vertexList[adjUnvisitedVertex].wasVisited = true;
                System.out.print("->");
                displayVertex(adjUnvisitedVertex);
                stack.push(adjUnvisitedVertex);
            }
        }
        resetWasVisited();
    }

    /**
     * Метод для обхода графа в ширину (Breadth First Search)
     */
    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int adjUnvisitedVertex;
        while (!queue.isEmpty()){
            int firstVertex = queue.remove();
            while ((adjUnvisitedVertex = getAdjUnvisitedVertex(firstVertex)) != -1){
                vertexList[adjUnvisitedVertex].wasVisited = true;
                System.out.print("->");
                displayVertex(adjUnvisitedVertex);
                queue.insert(adjUnvisitedVertex);
            }
        }
        resetWasVisited();
    }

    /**
     * Метод для поиска кратчайшего пути между двумя вершинами
     * с помощью метода обхода графа в ширину (Breadth First Search)
     * @param from - начальная вершина
     * @param to - конечная вершина
     */
    public void bfs(char from, char to){
        int start = getIndexVertex(from);
        int goal = getIndexVertex(to);
        if (start == -1 || goal == -1) {
            System.out.println("Вершина не найдена");
            return;
        }
        vertexList[start].wasVisited = true;
        queue.insert(start);
        while (!queue.isEmpty()){
            if (start == goal){
                pathStack.push(start);
                getPath(start);
                break;
            }
            int firstVertex = queue.remove();
            int adjUnvisitedVertex;
            while ((adjUnvisitedVertex = getAdjUnvisitedVertex(firstVertex)) != -1){
                vertexList[adjUnvisitedVertex].wasVisited = true;
                queue.insert(adjUnvisitedVertex);
                vertexList[adjUnvisitedVertex].parent = firstVertex;
                if (adjUnvisitedVertex == goal){
                    start = adjUnvisitedVertex;
                }
            }
        }
        printPath(from, to);

        resetWasVisited();
    }

    /**
     * Метод записывает в стэк кратчайший путь,
     * найденный с помощью метода Breadth First Search.
     * @param vertex - найденная конечная вершина
     */
    private void getPath(int vertex){
        int parentVertex = vertexList[vertex].parent;
        if (parentVertex == -1) return;
        pathStack.push(parentVertex);
        getPath(parentVertex);
    }

    /**
     * Метод выводит в консоль кратчайший путь,
     * найденный с помощью метода Breadth First Search.
     * @param from - начальная вершина
     * @param to - конечная вершина
     */
    private void printPath(char from, char to){
        if (pathStack.isEmpty()){
            System.out.println("Путь от " + from + " до " + to + " не найден");
        } else {
            System.out.println("Кратчайший путь от " + from + " до " + to + ": ");
            while (!pathStack.isEmpty()) {
                displayVertex(pathStack.pop());
                if (!pathStack.isEmpty()) System.out.print("-");
            }
        }
    }

    /**
     * Метод возвращает значение false полю wasVisited для всех вершин графа
     */
    private void resetWasVisited(){
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
