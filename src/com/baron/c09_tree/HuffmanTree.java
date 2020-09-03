package com.baron.c09_tree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] tree = { 5,8,4,11,9,13 };

        HuffmanTreeNode node = create(tree);

        node.prePrint();
    }

    public static HuffmanTreeNode create(int[] tree) {
        ArrayList<HuffmanTreeNode> list = new ArrayList<>();

        for ( int value : tree ) {
            list.add(new HuffmanTreeNode(value));
        }

        while ( list.size() > 1 ) {
            Collections.sort(list);

            HuffmanTreeNode node1 = list.get(0);
            HuffmanTreeNode node2 = list.get(1);

            HuffmanTreeNode node = new HuffmanTreeNode(node1.getWeight() + node2.getWeight());
            node.setLeft(node1);
            node.setRight(node2);

            list.remove(node1);
            list.remove(node2);

            list.add(node);
        }

        return list.get(0);
    }
}

class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {

    private int weight;
    private Byte data;
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }

    public HuffmanTreeNode(int weight, Byte data) {
        this.weight = weight;
        this.data = data;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public void prePrint() {
        prePrint(this);
    }

    private void prePrint(HuffmanTreeNode node) {
        System.out.println(node);

        if ( node.getLeft() != null ) {
            prePrint(node.getLeft());
        }

        if ( node.getRight() != null ) {
            prePrint(node.getRight());
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanTreeNode(int weight) {
        this.weight = weight;
    }

    public HuffmanTreeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanTreeNode left) {
        this.left = left;
    }

    public HuffmanTreeNode getRight() {
        return right;
    }

    public void setRight(HuffmanTreeNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        return this.weight - o.weight;
    }
}