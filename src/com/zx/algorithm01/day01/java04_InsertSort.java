package com.zx.algorithm01.day01;

/**
 * @ Date : 2023-02-07 09:41
 * @ Author : ZX
 **/
public class java04_InsertSort {
    public static void main(String[] args) {
        int []sort = {2,222,44,520,0,6666,5,666,88};
        int[] results = insertSort(sort);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    public static int[] insertSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {  //每一次都将当前index 和前面有序的数进行比较
            for (int j = i-1; j >=0 && arr[j] > arr[j+1] ; j--) {   //当 j >=0 并且 当前的数要比有序数组中的数要小，才循环
                    swap(arr,j,j+1);
            }
        }
        return arr;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
