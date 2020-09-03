package com.baron.c09_tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, "Baron");
        TreeNode node2 = new TreeNode(2, "Elain");
        TreeNode node3 = new TreeNode(3, "Elliot");
        TreeNode node4 = new TreeNode(4, "Alex");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);

        MyTree tree = new MyTree(node1);

        tree.list();
//        System.out.println(tree.preOrderSearch(0));
        System.out.println(tree.delete(2));

        tree.list();
    }
}

class MyTree {
    private TreeNode root;

    public MyTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode preOrderSearch(int id) {
        return root.preOrderSearch(id);
    }

    public boolean delete(int id) {
        if ( root.getId() == id ) {
            this.root = null;
            return true;
        }

        return root.preDeleteNode(id);
    }

    public void list() {
        if (root != null) {
            root.preList();
        }
    }
}

class TreeNode {
    private int id;
    private String name;

    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, String name) {
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

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void preList() {
        System.out.println(this);

        if ( this.getLeft() != null ) {
            this.getLeft().preList();
        }

        if ( this.getRight() != null ) {
            this.getRight().preList();
        }
    }

    public TreeNode preOrderSearch(int id) {
        if ( this.id == id ) {
            return this;
        }

        TreeNode ans = null;
        if ( this.getLeft() != null ) {
            ans = this.getLeft().preOrderSearch(id);
        }

        if ( this.getRight() != null ) {
            ans = this.getRight().preOrderSearch(id);
        }

        return ans;
    }

    public boolean preDeleteNode(int id) {
        // 若左节点的数等于当前需要删除的数，则将当前节点的左节点设为空
        if ( this.getLeft() != null && this.getLeft().getId() == id ) {
            this.setLeft(null);
            return true;
        }
        // 若右节点的数等于当前需要删除的数，则将当前节点的右节点设为空
        if ( this.getRight() != null && this.getRight().getId() == id ) {
            this.setRight(null);
            return true;
        }

        boolean result = false;
        if ( this.getLeft() != null ) {
            result = this.getLeft().preDeleteNode(id);
            if ( result ) {
                return true;
            }
        }

        if ( this.getRight() != null ) {
            result = this.getRight().preDeleteNode(id);
        }

        return result;
    }
}
