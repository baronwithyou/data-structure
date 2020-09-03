package com.baron.c09_tree;

public class ThreadedTreeDemo {
    public static void main(String[] args) {
        ThreadedTreeNode node1 = new ThreadedTreeNode(1);
        ThreadedTreeNode node3 = new ThreadedTreeNode(3);
        ThreadedTreeNode node8 = new ThreadedTreeNode(8);
        ThreadedTreeNode node10 = new ThreadedTreeNode(10);
        ThreadedTreeNode node14 = new ThreadedTreeNode(14);
        ThreadedTreeNode node6 = new ThreadedTreeNode(6);

        node1.setLeft(node3);
        node3.setLeft(node8);
        node3.setRight(node10);
        node1.setRight(node6);
        node6.setRight(node14);

        ThreadedTree tree = new ThreadedTree(node1);

//        tree.infixThreadNode();
//        tree.infixList();

        tree.postfixThreadNode();

        System.out.println(node8.getRight());
        System.out.println(node10.getLeft());
        System.out.println(node10.getRight());
    }
}

class ThreadedTree{
    ThreadedTreeNode root;
    ThreadedTreeNode pre = null;

    public ThreadedTree(ThreadedTreeNode root) {
        this.root = root;
    }

    public void postfixThreadNode() {
        postfixThreadNode(root);
    }

    // 后续线索
    private void postfixThreadNode(ThreadedTreeNode node) {
        if ( node.getLeft() != null ) {
            postfixThreadNode(node.getLeft());
        }

        if ( node.getRight() != null ){
            postfixThreadNode(node.getRight());
        }

        if ( node.getLeft() == null ) {
            node.setLeft(pre);
            node.setLeftThreadedNode(true);
        }

        if ( pre != null && pre.getRight() == null ) {
            pre.setRight(node);
            pre.setRightThreadedNode(true);
        }

        pre = node;
    }

    public void infixThreadNode() {
        infixThreadNode(root);
    }

    // 中序线索
    private void infixThreadNode(ThreadedTreeNode node) {
        if ( node.getLeft() != null ) {
            infixThreadNode(node.getLeft());
        }

        // 如果节点的左子树为空，则将其指向前驱节点
        if ( node.getLeft() == null ) {
            node.setLeft(pre);
            node.setLeftThreadedNode(true);
        }

        // 如果pre节点的右子树为空，则将其指向后续节点
        if ( pre != null && pre.getRight() == null ) {
            pre.setRight(node);
            pre.setRightThreadedNode(true);
        }

        pre = node;
        if ( node.getRight() != null ) {
            infixThreadNode(node.getRight());
        }
    }

    // 中序遍历
    public void infixList() {
        ThreadedTreeNode node = root;
        while ( node != null ) {
            while ( !node.isLeftThreadedNode() ) {
                node = node.getLeft();
            }

            System.out.println(node);

            while ( node.isRightThreadedNode() ) {
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }
    }
}

class ThreadedTreeNode {
    private boolean leftThreadedNode = false;
    private boolean rightThreadedNode = false;

    private int id;
    private String name;
    private ThreadedTreeNode left;
    private ThreadedTreeNode right;

    public ThreadedTreeNode(int id) {
        this.id = id;
    }

    public ThreadedTreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadedTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedTreeNode left) {
        this.left = left;
    }

    public ThreadedTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isLeftThreadedNode() {
        return leftThreadedNode;
    }

    public void setLeftThreadedNode(boolean leftThreadedNode) {
        this.leftThreadedNode = leftThreadedNode;
    }

    public boolean isRightThreadedNode() {
        return rightThreadedNode;
    }

    public void setRightThreadedNode(boolean rightThreadedNode) {
        this.rightThreadedNode = rightThreadedNode;
    }
}
