package com.mike.menu.mainApp.common.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: Menu
 * 类描述:BinaryTree
 * 作者: Mike
 * 创建时间: 2018/9/30 9:24
 * 邮箱:2468139903@qq.com
 */
public class BinaryTree {
    public int size;
    public Node root;
    public List<Integer> inList=new ArrayList<>();
    public List<Integer> preList=new ArrayList<>();
    public List<Integer> postList=new ArrayList<>();

    /**
     * 插入
     * @param data
     * @return
     */
    public boolean insert(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            root=newNode;
            size++;
            return true;
        }else{
            Node current=root;
            while (current!=null){
                if(current.data>data){
                    if(current.leftChild==null){
                        current.leftChild=newNode;
                        size++;
                        return true;
                    }else{
                       current=current.leftChild;
                    }
                }else{
                    if(current.rightChild==null){
                        current.rightChild=newNode;
                        size++;
                        return true;
                    }else{
                       current=current.rightChild;
                    }
                }
            }

        }
        return false;
    }

    public void preOrder(Node node){
        if(node!=null){
            preList.add(node.data);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.leftChild);
            inList.add(node.data);
            inOrder(node.rightChild);
        }
    }

    public void postOrder(Node node){
        if(node!=null){
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            postList.add(node.data);
        }
    }

    public boolean isEmpty(){
        return size==0;
}
}
