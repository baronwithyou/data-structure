package com.baron.c03_linkedlist;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {

        CircleSingleLinkedList list = new CircleSingleLinkedList();

        CircleSingleNode node1 = new CircleSingleNode(1);
        CircleSingleNode node3 = new CircleSingleNode(3);
        CircleSingleNode node5 = new CircleSingleNode(5);
        CircleSingleNode node7 = new CircleSingleNode(7);
        CircleSingleNode node9 = new CircleSingleNode(9);

        list.add(node1, node3, node5, node7, node9);

        list.list();

        list.play(2);

    }

}

class CircleSingleLinkedList {
    private CircleSingleNode first = null;

    public void add(CircleSingleNode ...nodes) {
        for ( CircleSingleNode node : nodes ) {
            if ( first == null ) {
                first = node;
                first.setNext(first);
                continue;
            }

            CircleSingleNode last = first;
            while (last.next != first) {
                last = last.next;
            }

            last.setNext(node);
            node.setNext(first);
        }
    }

    public void list() {
        CircleSingleNode node = first;
        while (true) {
            System.out.println(node);

            if (node.getNext() == first) {
                break;
            }

            node = node.getNext();
        }

        System.out.println("打印完成");
    }

    public void play(int n) {
        CircleSingleNode node = first;

        while (node.getNext() != first) {
            node = node.getNext();
        }

        CircleSingleNode temp = node;
        node = node.getNext();

        int i = 1;

        while (true) {
            if (i == n) {
                i = 1;
                System.out.println(node + "出队");
                // 节点出队
                temp.setNext(node.getNext());
                node = temp.getNext();
            } else {
                i++;
                temp = temp.getNext();
                node = node.getNext();
            }

            if (node == temp) {
                System.out.println(temp + "我是最后一个");
                break;
            }
        }

        System.out.println("遍历完成");
    }
}

class CircleSingleNode{
    int val;
    CircleSingleNode next;

    public CircleSingleNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public CircleSingleNode getNext() {
        return next;
    }

    public void setNext(CircleSingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleSingleNode{" +
                "val=" + val +
                '}';
    }
}
