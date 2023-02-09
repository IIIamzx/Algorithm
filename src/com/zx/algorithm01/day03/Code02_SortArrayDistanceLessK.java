package com.zx.algorithm01.day03;

import java.util.PriorityQueue;

/**
 * @ Date : 2023-02-09 13:29
 * @ Author : ZX
 * @ Description :
 **/
public class Code02_SortArrayDistanceLessK {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        sortedArrDistanceLessK(arr,1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sortedArrDistanceLessK(int[]arr,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        while(index < k){                   //首先将 K 个数字添加到小根堆中
            heap.add(arr[index++]);
        }
        int i = 0;
        while(index < arr.length){          //每次从小根堆中得到最小值，放入有序数组中，并加入新的值进入小根堆中
            heap.add(index++);
            arr[i++] = heap.poll();
        }
        while(!heap.isEmpty()){             //最后将小根堆中所有值一次存入数组
            arr[i++] = heap.poll();
        }
    }

}
