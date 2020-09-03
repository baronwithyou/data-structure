package com.baron.c03_linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        DoubleNode node1 = new DoubleNode(3);
        DoubleNode node2 = new DoubleNode(5);
        DoubleNode node3 = new DoubleNode(7);
        DoubleNode node4 = new DoubleNode(9);
        DoubleNode node5 = new DoubleNode(11);

        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        list.list();

        try {
            list.remove(11);
        }catch (Exception e) {
            System.out.println(e);
        }

        list.list();
    }
}

class DoubleLinkedList {
    DoubleNode head = new DoubleNode(0);

    public void add(DoubleNode node) {
        DoubleNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        node.pre = temp;
        temp.next = node;
    }

    public void list() {
        DoubleNode temp = head.next;

        while (temp != null) {
            System.out.println(temp);

            temp = temp.next;
        }

        System.out.println("Done");
    }

    public void remove(int val) throws Exception {
        DoubleNode temp = head.next;
        boolean flag = false;

        while (temp != null) {
            if (temp.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            throw new Exception("没有该值");
        }

        temp.pre.next = temp.next;
        // 如果是最后一个节点，就不需要执行pre操作
        if ( temp.next != null ) {
            temp.next.pre = temp.pre;
        }
    }
}

class DoubleNode {
    int val;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "val=" + val +
                '}';
    }
}
