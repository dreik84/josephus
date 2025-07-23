package com.example;

class App {
    public static void main(String[] args) {

        CyclicLinkedList list = new CyclicLinkedList();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.delete(2);

        System.out.println(list.find(3));
        System.out.println(list);
    }
}