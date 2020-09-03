package com.baron.c03_linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "Captain America", "Avenger");
        HeroNode hero2 = new HeroNode(2, "Iron Man", "Avenger");
        HeroNode hero3 = new HeroNode(3, "flash", "DC");
        HeroNode hero4 = new HeroNode(4, "flash", "DC");

        SingleLinkedList list = new SingleLinkedList();

        try {
            list.addByOrder(hero1);
            list.addByOrder(hero2);
            list.addByOrder(hero3);
            list.addByOrder(hero4);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("正常排序：");
        list.list();

        list.reverse();

        System.out.println("排序：");
        list.list();
    }
}

class SingleLinkedList {
    HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode node) {
        HeroNode lastNode = lastNode();

        lastNode.next = node;
    }

    public void addByOrder(HeroNode newNode) throws Exception {
        HeroNode node = head;

        // 取出适当位置的node
        while (node.next != null) {
            if (node.next.id == newNode.id) {
                throw new Exception("已存在相同排名的英雄");
            }

            if (node.next.id > newNode.id) {
                break;
            }

            node = node.next;
        }

        newNode.next = node.next;
        node.next = newNode;
    }

    private HeroNode lastNode() {
        HeroNode node = head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    public void list() {
        HeroNode node = head;

        while (node.next != null) {
            node = node.next;

            System.out.println(node);
        }
    }

    public void reverse() {
        HeroNode newHead = new HeroNode(0, "", "");

        HeroNode node = head.next;

        while ( node != null ) {
            HeroNode next = node.next;

            node.next = newHead.next;

            newHead.next = node;

            node = next;
        }

        head.next = newHead.next;
    }
}

class HeroNode {
    int id;
    String name;
    String department;
    HeroNode next;

    public HeroNode(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
