package com.baron.c09_tree;

public class BSTreeDemo {
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        BSTreeNode node5 = new BSTreeNode(5);
        BSTreeNode node3 = new BSTreeNode(3);
        BSTreeNode node2 = new BSTreeNode(2);
        BSTreeNode node4 = new BSTreeNode(4);
        BSTreeNode node7 = new BSTreeNode(7);
        BSTreeNode node6 = new BSTreeNode(6);
        BSTreeNode node9 = new BSTreeNode(9);

        tree.add(node5, node3, node2, node4, node7, node6, node9);

//        tree.infixOrder();

//        System.out.println();

//        tree.delete(1);
        tree.delete(3);

        tree.infixOrder();

//        System.out.println(tree.searchParent(3));

//        System.out.println(tree.search(node3.val));
    }
}

class BSTree {
    BSTreeNode root;

    public boolean add(BSTreeNode ...nodes) {
        if ( nodes.length <= 0 ) {
            return false;
        }

        if ( root == null ) {
            root = nodes[0];
        }

        for ( int i = 1; i < nodes.length; i++ ) {
            root.addNode(nodes[i]);
        }

        return true;
    }

    public BSTreeNode search(int val) {
        return root.search(val);
    }

    public BSTreeNode searchParent(int val) {
        return root.searchParent(val);
    }

    public boolean delete(int val) {
        /**
         * 思路：
         * 	1. 若删除的节点为叶子节点，则找到其父节点，然后将其指定节点置为空
         * 	2. 若删除的节点拥有一棵子树，则直接将其父节点指向其子树的根节点
         * 	3. 若删除的节点target拥有两棵子树，则将其 左子树的最大值/右子树的最小值find 改成该节点，并且将find删除（此时的find必定只拥有一棵子树）。
         */
        BSTreeNode node = search(val);
        if ( node == null ) {
            return false;
        }

        BSTreeNode parent = searchParent(val);
        if ( parent == null ) {
            // 直接将根节点置为空
            root = null;
            return true;
        }

        // 叶子节点
        if ( node.getChildCount() == 0 ){
            if ( val < parent.getVal() ) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if ( node.getChildCount() == 1 ) { // 存在一个节点
            if ( val < parent.getVal() ) {
                if ( node.getLeft() != null ) {
                    parent.setLeft(node.getLeft());
                } else {
                    parent.setLeft(node.getRight());
                }
            } else {
                if ( node.getLeft() != null ) {
                    parent.setRight(node.getLeft());
                } else {
                    parent.setRight(node.getRight());
                }
            }
        } else {
            BSTreeNode leftMax = node.getLeft().getMax();
            delete(leftMax.getVal());

            node.setVal(leftMax.getVal());
        }

        return true;
    }

    public void infixOrder() {
        root.infixOrder();
    }
}

class BSTreeNode {
    int val;

    BSTreeNode left;
    BSTreeNode right;

    public BSTreeNode(int val) {
        this.val = val;
    }

    public BSTreeNode getMax() {
        if ( this.getRight() == null ) {
            return this;
        }

        return this.getRight().getMax();
    }

    public int getChildCount() {
        int count = 0;
        count += this.left != null ? 1 : 0;
        count += this.right != null ? 1 : 0;

        return count;
    }

    @Override
    public String toString() {
        return "BSTreeNode{" +
                "val=" + val +
                '}';
    }

    public void infixOrder() {
        if ( this.getLeft() != null ) {
            this.getLeft().infixOrder();
        }

        System.out.println(this);

        if ( this.getRight() != null ) {
            this.getRight().infixOrder();
        }
    }

    public BSTreeNode search(int val) {
        if ( this.val == val ) {
            return this;
        }

        if ( val < this.val && this.getLeft() != null ) {
            return this.getLeft().search(val);
        } else if ( val > this.val && this.right != null ){
            return this.getRight().search(val);
        }

        return null;
    }

    public BSTreeNode searchParent(int val) {
        if ( (this.getLeft() != null && this.getLeft().getVal() == val) ||
                (this.getRight() != null && this.getRight().getVal() == val)){
            return this;
        }

        if ( val == this.val ) {
            return null;
        }

        if ( val < this.val ) {
            if ( this.getLeft() == null ) {
                return null;
            } else {
                return this.getLeft().searchParent(val);
            }
        } else {
            if ( this.getRight() == null ) {
                return null;
            } else {
                return this.getRight().searchParent(val);
            }
        }
    }

    public void addNode(BSTreeNode node) {
        if ( node == null ) {
            return;
        }

        if ( this.val < node.val ) {
            // 插入到右边
            if ( this.getRight() == null ) {
                this.setRight(node);
            } else {
                this.getRight().addNode(node);
            }
        } else {
            if ( this.getLeft() == null ) {
                this.setLeft(node);
            } else {
                this.getLeft().addNode(node);
            }
        }

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    public void setRight(BSTreeNode right) {
        this.right = right;
    }
}
