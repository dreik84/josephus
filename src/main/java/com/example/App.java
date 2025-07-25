package com.example;

class App {
    public static void main(String[] args) {
        CyclicLinkedList list = new CyclicLinkedList();
        int josephusNum = 7;

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
        list.find(1);
        System.out.println(list);

        for (int i = 0; i < 20; i++) {
            list.deleteN(4);
        }

        System.out.println(list);
    }
}