package com.zx.algorithm01.day02;

/**
 * @ Date : 2023-02-08 12:49
 * @ Author : ZX
 * @ Description :
 **/
public class code02_SmallSum {
    public static void main(String[] args) {
        int []sort = {1,3,4,2,5};
        int result = mergeSort(sort,0,sort.length-1);
        System.out.println(result);
    }

    private static int mergeSort(int[] arr, int left, int right) {  //递归归并算法
        if(left ==  right) return 0;
        int mid = left + (right-left) / 2;          //res = 左边数组 + 右边数组 + merge合并
        return mergeSort(arr,left,mid) + mergeSort(arr,mid+1,right) + merge(arr,left,mid,right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right-left+1];
        int len = 0,p1 = left,p2 = mid + 1;
        int res = 0;
        while(p1 <= mid && p2 <= right){
            res += arr[p1] < arr[p2] ? (right-p2+1) * arr[p1] : 0;          //计算出当前合并时，右边总共有多少个比当前数大的数字
            help[len++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];        //当两个数相等时，默认先合并右边数组的数
        }
        while(p1 <= mid){
            help[len++] = arr[p1++];
        }
        while(p2 <= right){
            help[len++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }


}
