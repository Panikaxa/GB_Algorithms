package com.gb.algorithms.lesson4;

import java.util.Objects;

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }

        if (getClass() != obj.getClass()){
            return false;
        }

        final People other = (People) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", age: " + this.age;
    }
}

class Links<T>{
    private T link;
    private Links<T> next;

    public Links(T link) {
        this.link = link;
    }

    public Links<T> getNext() {
        return next;
    }

    public void setNext(Links<T> next) {
        this.next = next;
    }

    public T getValue(){
        return link;
    }
}

class LinkedLists<T>{
    private Links<T> first;

    public LinkedLists(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(T link){
        Links<T> l = new Links<>(link);
        l.setNext(first);
        this.first = l;
    }

    public Links<T> delete(){
        Links<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display(){
        Links<T> current = first;
        while (current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public T find (T searchNode){
        Links<T> findNode = new Links<>(searchNode);
        Links<T> current = first;
        while (current != null){
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}

public class GenericListApp{
    public static void main(String[] args) {
        LinkedLists<String> list = new LinkedLists<>();
        list.insert("Artem");
        list.insert("Roman");
        System.out.println(list.find("Arteam"));

        System.out.println("--------------------------------");

        LinkedLists<People> peopleLinkedLists = new LinkedLists<>();
        peopleLinkedLists.insert(new People("Artem", 22));
        peopleLinkedLists.insert(new People("Roman", 23));
        System.out.println(peopleLinkedLists.find(new People("Artem", 22)).toString());
    }
}
