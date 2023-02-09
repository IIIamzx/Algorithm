package com.zx.algorithm01.day03;

/**
 * @ Date : 2023-02-09 15:07
 * @ Author : ZX
 * @ Description : 基数排序
 **/
public class Code03_RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 4, 5, 6, 2, 8, 7, 100, 6};

        System.out.println(getDigit(123,2));
        radixSort(arr,0,arr.length-1,maxbit(arr));
        System.out.println(maxbit(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0,j = 0;
        int[] bucket = new int[end - begin +1];

        for (int d = 1; d <= digit; d++) {              //基数排序外层总次数
            int[]count = new int[radix];

            for(i = begin;i <= end;i++){
                j = getDigit(arr[i],d);
                count[j]++;                             //利用数组count统计，某个位上的数字总数
            }

            for(i = 1;i < radix;++i){
                count[i] = count[i] + count[i-1];       //计算前缀和，表示前面有多少个数字小于等于当前数，用于出桶时，确定元素位置
            }

            for(i = end;i >= begin;i--){
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];            //从右往左遍历，出桶操作，利用前缀和 和 计数操作确定元素位置
                count[j]--;
            }
            for(i = begin,j=0;i <= end;i++,j++){        //赋值给arr，进行下一次基数排序
                arr[i] = bucket[j];
            }
        }
    }


    //计算当前数组中的最大 位数
    private static int maxbit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
        }
        int res = 0;
        while(max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

/*
123
123 / 10 = 12
12 % 10 = 2
*/
    //传入数字，返回第 d 位上的数字
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);        //先除以 x 舍去后面部分，在整除 10 获得最后一位
    }



}




