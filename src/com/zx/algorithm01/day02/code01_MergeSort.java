package com.zx.algorithm01.day02;

/**
 * @ Date : 2023-02-08 11:15
 * @ Author : ZX
 * @ Description : 归并排序
 **/
public class code01_MergeSort {

    public static void main(String[] args) {
        int []sort = {2,222,44,520,0,6666,5,666,88};
        mergeSort(sort,0,sort.length-1);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left == right) return;       //递归结束条件
        int mid = left + (right-left) / 2;
        //递归：先对左边进行排序，再对右边进行排序，最后合并数组
        mergeSort(arr,0,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {           //完成 left-right区间上一次 merge过程
        int[] help = new int[right-left+1];     //创建与合并数组同长度的数组
        int len = 0,p1 = left,p2= mid + 1;      //left,right与传入的参数有关
        while(p1 <= mid && p2 <= right){         //两个数组均未走完
            help[len++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while(p1 <= mid){                        //p1剩余
            help[len++] = arr[p1++];
        }
        while(p2 <= right){
            help[len++] = arr[p2++];            //p2未剩余
        }
        for (int i = 0; i < help.length; i++) {
            arr[left+i] = help[i];
        }
    }
}
