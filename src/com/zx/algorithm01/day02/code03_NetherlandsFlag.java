package com.zx.algorithm01.day02;

/**
 * @ Date : 2023-02-08 16:09
 * @ Author : ZX
 * @ Description :
 **/
public class code03_NetherlandsFlag {
    public static void main(String[] args) {
        int[]arr = new int[]{2,1,3,4,5,6,2,8,7,10,6};


        int[] index = partition(arr, 0,arr.length-1,6);
        System.out.println(index[0]);
        System.out.println(index[1]);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int[] partition(int[] arr,int l,int r,int target) {
        int left = l - 1;
        int right = r + 1 ;
        while(l < right){
            if(arr[l] < target){                //当前 num < target: 和left后一个进行交换,l++
                swap(arr,++left,l++);
            }else if(arr[l] > target){          //当前 num > target: 和right前一个进行交换,此时 l 不变
                swap(arr,--right,l);
            }else{
                l++;                            //num == target ,si++
            }
        }
        return new int[]{left+1,right-1};         //返回相等部分前后的下标
    }

    public static void swap(int[]arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}






