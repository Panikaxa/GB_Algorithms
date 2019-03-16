package com.gb.algorithms.lesson6;

import static java.lang.Math.abs;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node find(int number){
        Node current = root;
        while (current.number != number){
            if (number < current.number){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int number){
        Node node = new Node();
        node.number = number;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (number < current.number){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int number){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        //Поиск удаляемого элемента
        while (current.number != number){
            parent = current;
            if (number < current.number){
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }
        //Удаление если элемент не имеет потомков
        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            } else if (isLeftChild){
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        //Если нет правого потомка
        else if (current.rightChild == null){
            if (current == root){
                root = current.leftChild;
            } else if (isLeftChild){
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        //Если нет левого потомка
        else if (current.leftChild == null){
            if (current == root){
                root = current.rightChild;
            } else if (isLeftChild){
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        //Если есть оба потомка
        else {
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            } else if (isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTree(){
        Stack stack = new Stack(100);
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack localStack = new Stack(100);
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("---");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < nBlanks * 2; j++)
                    System.out.print(' ');
            }
            System.out.println("");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..........................................................................................................");
        }
    }

    private void inOrder(Node rootNode){
        if (rootNode != null){
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min(){
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max(){
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    /**
     * Метод определяющий глубину дерева
     * @param node - корневой элемент
     * @return - глубина дерева
     */
    public int depth(Node node){
        if (node == null){
            return 0;
        } else {
            int leftDepth = depth(node.leftChild);
            int rightDepth = depth(node.rightChild);

            if (leftDepth > rightDepth )
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    /**
     * Метод проверяющий дерево на сбалансированнность
     * @param node - корневой элемент дерева
     * @return - true - сбалансировано, false - нет
     */
    public boolean isBalance(Node node){
        if (node == null){
            return false;
        } else {
            int leftDepth = depth(node.leftChild);
            int rightDepth = depth(node.rightChild);
            return abs(leftDepth - rightDepth) <= 1;
        }
    }
}
