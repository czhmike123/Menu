package com.mike.menu.mainApp.common.test;

public class AlgorithmCase {
    //排序算法 从小排到大


    /**
     * 交换方法
     * @param arr
     * @param a
     * @param b
     */
    public void swap(int [] arr,int a,int b){
        if(arr[a]>arr[b]){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
        }
    }
    /**
     * 选择排序
     */
    public void selectSort(int [] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int min=i;//
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(min!=i){
                swap(arr,i,min);
            }
        }
    }

}
