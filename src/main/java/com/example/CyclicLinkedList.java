package com.example;

import java.util.StringJoiner;

public class CyclicLinkedList {

    private Link current;

    public void add(int value) {
        if (current == null) {
            current = new Link(value);
        } else if (current.next == null) {
            current.next = new Link(value);
            current.next.next = current;
            current = current.next;
        } else {
            Link newLink = new Link(value);
            newLink.next = current.next;
            current.next = newLink;
            current = current.next;
        }
    }

    public Link find(int value) {
        Link end = current;

        do {
            if (current == null) break;
            if (current.value == value) return current;
            if (current.next == null) break;
            current = current.next;

        } while (current != end);

        return null;
    }

    public void deleteN(int key) {
        if (current == null) return;
        if (current.next == null && current.value == key) {
            current = null;
            return;
        }

        Link previous = current;
        current = current.next;

        for (int i = 0; i < key; i++) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        current = previous.next;
    }

    public void delete(int value) {
        if (current == null) return;
        if (current.next == null && current.value == value) {
            current = null;
            return;
        }

        Link previous = current;
        Link end = current.next;
        current = current.next;

        do {
            if (current.value == value) {
                previous.next = current.next;
                current = previous.next;
                break;
            } else {
                previous = current;
                current = current.next;
            }

        } while (current != end);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        Link end = current;

        do {
            if (current == null) break;
            sj.add(String.valueOf(current.value));
            if (current.next == null) break;
            current = current.next;

        } while (current != end);

        return "CyclicLinkedList { " + sj + " }";
    }

    private static class Link {
        int value;
        Link next;

        Link(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Link { " + "value=" + value + " }";
        }
    }
}
