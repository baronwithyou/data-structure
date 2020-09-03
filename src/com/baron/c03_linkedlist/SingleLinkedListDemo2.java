package com.baron.c03_linkedlist;

public class SingleLinkedListDemo2 {
    public static void main(String[] args) {
        SingleLinkedNode node1 = new SingleLinkedNode(1, "baron");
        SingleLinkedNode node2 = new SingleLinkedNode(2, "Elain");
        SingleLinkedNode node3 = new SingleLinkedNode(3, "Alexandra");

        SingleLinkedList2 list = new SingleLinkedList2();

        list.add(node1);
        list.add(node2);
        list.add(node3);

        list.list();

        list.reverse();

        list.list();
    }
}

class SingleLinkedList2 {
    SingleLinkedNode head = new SingleLinkedNode(0, "");

    public void add(SingleLinkedNode node) {
        SingleLinkedNode last = getLast();

        last.setNext(node);
    }

    public void list() {
        SingleLinkedNode node = head.getNext();
        while (node != null) {
            System.out.println(node);

            node = node.getNext();
        }
    }

    private SingleLinkedNode getLast() {
        SingleLinkedNode node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node;
    }

    public void reverse() {
        SingleLinkedNode newHead = new SingleLinkedNode(0, "");

        SingleLinkedNode node = head.getNext();
        SingleLinkedNode tmp;
        while (node != null) {
            tmp = node.getNext();

            node.setNext(newHead.getNext());
            newHead.setNext(node);

            node = tmp;
        }

        head = newHead;
    }
}

class SingleLinkedNode {

    int id;
    String name;
    SingleLinkedNode next;

    public SingleLinkedNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SingleLinkedNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleLinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
