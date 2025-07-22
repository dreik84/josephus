package com.example;

public class CyclicLinkedList {

    private Link current;

    public void add(int value) {
        if (current == null) {
            current = new Link(value);
        } else if (current.next == null){
            current.next = new Link(value);
            current.next.next = current;
        } else {
            Link newLink = new Link(value);
            newLink.next = current.next;
            current.next = newLink;
        }
    }

    public void search(int value) {

    }

    public void delete(int value) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link end = current;

        do {
            sb.append(current.value);
            current = current.next;

        } while (current != end);

        return sb.toString();
    }

    private static class Link {
        int value;
        Link next;

        Link() {
        }

        Link(int value) {
            this.value = value;
        }
    }
}
