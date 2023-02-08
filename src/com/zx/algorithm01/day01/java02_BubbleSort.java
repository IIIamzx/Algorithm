package com.zx.algorithm01.day01;

/**
 * @ Date : 2023-02-07 08:03
 * @ Author : ZX
 **/
public class java02_BubbleSort {
    public static void main(String[] args) {
        int []sort = {2,222,44,520,0,6666,5,666,88};
        int[] results = bubbleSort(sort);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return arr;
        }
        for(int i = arr.length-1;i > 0;i--){        //每次冒泡一次，从 0-n-1 减小一次
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){              //每次把大的数往后冒泡
                    swap(arr,j,j+1);
                }
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
