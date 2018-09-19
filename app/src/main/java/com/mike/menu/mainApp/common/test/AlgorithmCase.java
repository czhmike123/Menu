package com.mike.menu.mainApp.common.test;

import com.mike.commonlib.logger.Log;

public class AlgorithmCase {
    Log log=Log.Factory.getInstance().setTag(getClass().getSimpleName());
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
     * 选择排序 从第一个元素开始,分别与数组中的每个元素比较,找出最小值.然后依次重复,直到排序完成;
     * 步骤:
     *      1.第一次排序步骤(i=0)
     *                      1.用变量min记录arr[0]角标0
     *                      2.从第二个元素开始遍历数组for循环
     *                      3.当前循环到元素与arr[min]比较,如果小于arr[min],把角标赋值给min   (循环)
     *                      4.直到最后一个元素比较完,结束循环
     *                      5.如果min!=0,说明元素值比arr[0] 更小,交换
     *        得到结果:最小的元素已经排到前面了
     *      2.第二次排序步骤(i=1)
     *                      1.用变量min记录arr[1]角标1
     *                      2.从第三个元素开始遍历数组for循环
     *                      3.当前循环到元素与arr[min]比较,如果小于arr[min],把角标赋值给min   (循环)
     *                      4.直到最后一个元素比较完,结束循环
     *                      5.如果min!=1,说明元素值比arr[1] 更小,交换
     *        得到结果:第二小的元素已经排到前面了
     *      3.第i+1次排序步骤
     *                      1.用变量min记录arr[i]角标i
     *                      2.从第i+2个元素开始遍历数组for循环
     *                      3.当前循环到元素与arr[min]比较,如果小于arr[min],把角标赋值给min   (循环)
     *                      4.直到最后一个元素比较完,结束循环
     *                      5.如果min!=i,说明元素值比arr[i] 更小,交换
     *        得到结果:第i+1小的元素已经排到前面了
     *
     *      4.当第arr.length-1小的元素排在前面时,循环结束;
     *
     *      外循环次数 arr.length-1次    内循环从第i+1元素 循环到最后一个元素
     *
     *
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

    /**
     * 冒泡排序 从第一个开始相邻元素比较,前者大于后者交换,直到最后一个元素比完,找出最大的值. 重复开始找出第二大,依次循环
     * 步骤:
     *       1.第一次排序步骤(i=0)
     *                         1.开始遍历数组for循环
     *                         2.当前循环到元素与下一个元素比较,如果大于后者,交换   (循环)
     *                         3.直到最后一个元素比较完,结束循环
     *         得到结果:最大的元素已经排到最后了(循环次数: arr.length-1-0,最大元素下标arr.length-1)
     *       2.第二次排序步骤(i=1)
     *                         1.开始遍历数组for循环
     *                         2.当前循环到元素与下一个元素比较,如果大于后者,交换   (循环)
     *                         3.直到倒数第二个元素比较完,结束循环
     *         得到结果:第二大的元素已经排到最后了(循环次数: arr.length-1-1,最大元素下标arr.length-2)
     *       3.第i+1次排序步骤
     *                         1.开始遍历数组for循环
     *                         2.当前循环到元素与下一个元素比较,如果大于后者,交换   (循环)
     *                         3.直到倒数第i+1个元素比较完,结束循环
     *         得到结果:第i+1大的元素已经排到最后了(循环次数: arr.length-i-1,最大元素下标arr.length-i-1)
     *
     *       4.当第arr.length-1大的已经元素排到最后了,外循环就可以结束了;
     *
     *     外循环次数 arr.length-1次,内循环次数 arr.length-i-1;(i 从0开始)
     * @param arr
     */
    public void bubbleSort(int [] arr){
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 直接插入排序 将未排序元素插入已经排好序的数列中
     * 步骤:
     *
     *      1.第一次排序: (i=0)
     *                  1.开始前1个元素循环
     *                  2.当前循环元素大于arr[1],变量pos记录当前元素位置,变量temp记录arr[1]值,结束循环break;
     *                  3.从pos记录位置元素开始,1-pos个元素需要全部后移一位
     *                  4.把temp记录的赋值给pos位置
     *       得到结果:前2个元素有序
     *      2.第二次排序: (i=1)
     *                  1.开始前2个元素循环
     *                  2.当前循环元素大于arr[2],变量pos记录当前元素位置,变量temp记录arr[2]值,结束循环break;
     *                  3.从pos记录位置元素开始,2-pos个元素需要全部后移一位
     *                  4.把temp记录的赋值给pos位置
     *        得到结果:前3个元素有序
     *
     *      3.第i+1次排序:
     *                  1.开始前i+1个元素循环
     *                  2.当前循环元素大于arr[i+1],变量pos记录当前元素位置,变量temp记录arr[i+1]值,结束循环break;
     *                  3.从pos记录位置元素开始,i+1-pos个元素需要全部后移一位
     *                  4.把temp记录的赋值给pos位置
     *        得到结果:前i+2个元素有序
     *
     */

    public void directInsertSort(int [] arr){
        for (int i = 0; i <arr.length-1; i++) {
            int pos=0;
            int temp=0;
            boolean flag=false;
            for (int j = 0; j <i+1 ; j++) {
                if(arr[j]>arr[i+1]){
                    temp=arr[i+1];
                    pos=j;
                    flag=true;
                    break;
                }
            }

            if(flag){
                for (int j = 0; j <i+1 ; j++) {
                    if(i-j<pos){
                        break;
                    }
                    arr[i+1-j]=arr[i-j];
                }
                arr[pos]=temp;
            }
        }
        log.d(arr);
    }
}
