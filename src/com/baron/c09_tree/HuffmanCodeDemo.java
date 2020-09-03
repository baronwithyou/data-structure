package com.baron.c09_tree;

import java.util.*;

public class HuffmanCodeDemo {
    public static void main(String[] args) {
        String s = "I Love Love coding";

        HuffmanCode code = new HuffmanCode();

        System.out.println(code.code(s));

//        HuffmanTreeNode node = code.create(s);
//
//        node.prePrint();
    }
}

class HuffmanCode {
    // 最终目的 - 将一串字符串进行哈夫曼编码
    // 哈夫曼编码 - 将出现的字符做为data，出现的次数作为weight生成叶子节点

    Map<Byte, String> ans = new HashMap<>();

    static StringBuilder sb = new StringBuilder();


    /**
     * 根据字符串生成一个哈夫曼树
     * @param s
     * @return
     */
    public HuffmanTreeNode create(String s) {
        byte[] bs = s.getBytes();

        // 初始化一个map
        Map<Byte, Integer> map = new HashMap<>();
        for ( Byte b : bs ) {
            // 看一下map-merge的用法
            map.merge(b, 1, Integer::sum);
        }

        List<HuffmanTreeNode> nodes = new ArrayList<>();

        // 看一下entrySet的用法
        for ( Map.Entry<Byte, Integer> entry : map.entrySet() ){
            nodes.add(new HuffmanTreeNode(entry.getValue(), entry.getKey()));
        }

        return create(nodes);
    }

    // 需要返回一个编码后的string
    public String code(String s) {
        HuffmanTreeNode node = create(s);

        // 左路径为0，右路径为1的方式为每个子节点生成一个二进制string
        generate(node, "", sb);

        System.out.println(ans);

        return sb.toString();
    }

    public void generate(HuffmanTreeNode node, String code, StringBuilder s) {
        StringBuilder s2 = new StringBuilder(s);
        s2.append(code);
        if ( node != null ) {
            if ( node.getData() != null ) {
                ans.put(node.getData(), s2.toString());
            } else {
                generate(node.getLeft(), "0", s2);
                generate(node.getLeft(), "1", s2);
            }
        }

    }

    private HuffmanTreeNode create(List<HuffmanTreeNode> nodes) {
        while ( nodes.size() > 1 ) {

            Collections.sort(nodes);

            //  取出头两个节点
            HuffmanTreeNode node1 = nodes.get(0);
            HuffmanTreeNode node2 = nodes.get(1);

            // 生成一个新的节点
            HuffmanTreeNode node = new HuffmanTreeNode(node1.getWeight() + node2.getWeight());

            node.setLeft(node1);
            node.setRight(node2);

            nodes.remove(node1);
            nodes.remove(node2);

            nodes.add(node);

        }

        return nodes.get(0);
    }

}
