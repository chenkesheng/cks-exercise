package com.cks.exercise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: cks
 * @Date: Created by 9:46 2018/9/7
 * @Package: com.cks.exercise.tree
 * @Description:
 */
public class BinTree<E> {

    private BinTree<E> root;

    private BinTree<E> left;

    private BinTree<E> right;

    private E data;

    public BinTree(BinTree<E> left, BinTree<E> right, E data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinTree(E data) {
        this(null, null, data);
    }

    public BinTree() {
        super();
    }


    public void createTree(E[] objs) {
        List<BinTree<E>> datas = new ArrayList<>();
        for (int i = 0; i < objs.length; i++) {
            datas.add(new BinTree<>(objs[i]));
        }
        root = datas.get(0);//第一个作为根节点
        for (int i = 0; i < objs.length / 2; i++) {
            datas.get(i).left = datas.get(i * 2 + 1);
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }
    }

    //先序遍历
    public void preorder(BinTree<E> root) {
        if (root != null) {
            visit(root.getData());
            preorder(root.left);
            preorder(root.right);
        }
    }

    //中序遍历
    public void inorder(BinTree<E> root) {
        if (root != null) {
            inorder(root.left);
            visit(root.getData());
            inorder(root.right);
        }
    }

    //后序遍历
    public void afterorder(BinTree<E> root) {
        if (root != null) {
            afterorder(root.left);
            afterorder(root.right);
            visit(root.getData());
        }
    }

    public void levelOrder(BinTree<E> root){
        if (root == null){
           return;
        }
        Queue<BinTree<E>> queue = new LinkedList<>();//层序遍历时保存结点的队列
        queue.offer(root);
        while (!queue.isEmpty()){
            BinTree<E> tree = queue.poll();
            visit(tree.getData());
            if (tree.left != null){
                queue.offer(tree.left);
            }
            if (tree.right != null){
                queue.offer(tree.right);
            }
        }
    }

    private void visit(Object obj) {
        System.out.print(obj + " ");
    }

    public BinTree<E> getRoot() {
        return root;
    }

    public Object getData() {
        return data;
    }

}
