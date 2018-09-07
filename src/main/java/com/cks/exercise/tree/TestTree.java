package com.cks.exercise.tree;

import static com.cks.exercise.tree.BiThrNode.createBinaryTree;
import static com.cks.exercise.tree.BiThrNode.Node;

/**
 * @Author: cks
 * @Date: Created by 10:10 2018/9/7
 * @Package: com.cks.exercise.tree
 * @Description:
 */
public class TestTree {
    public static void main(String[] args) {
//        String[] objs = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
//        BinTree<String> binTree = new BinTree<>();
//        binTree.createTree(objs);
//        binTree.preorder(binTree.getRoot());
//        binTree.inorder(binTree.getRoot());
//        binTree.afterorder(binTree.getRoot());
//        binTree.levelOrder(binTree.getRoot());


        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
        Node root = createBinaryTree(array, 0);

        BiThrNode tree = new BiThrNode();
        tree.inThreadOrder(root);
        System.out.println("中序按后继节点遍历线索二叉树结果：");
        tree.inThreadList(root);
        System.out.println("\n中序按后继节点遍历线索二叉树结果：");
        tree.inPreThreadList(root);

        Node root2 = createBinaryTree(array, 0);
        BiThrNode tree2 = new BiThrNode();
        tree2.preThreadOrder(root2);
        tree2.preNode = null;
        System.out.println("\n前序按后继节点遍历线索二叉树结果：");
        tree.preThreadList(root2);
    }
}
