package com.zx.algorithm01.day03;

/**
 * @ Date : 2023-02-09 10:26
 * @ Author : ZX
 * @ Description : 堆排序算法
 *
 * index
 * 父节点： (index-1)/2
 * 左孩子：（index*2）+1
 * 右孩子：（index*2）+2
 **/
public class Code01_HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 4, 5, 6, 2, 8, 7, 10, 6};


        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {      //自顶向上初始化大根堆
            heapInsert(arr, i);
        }
//        for (int i = arr.length-1; i >= 0; i--) {   //自底向上初始化大根堆
//            heapify(arr,i,arr.length);
//        }


        int size = arr.length;
        swap(arr,0,--size);                              //移除大根堆堆顶，大根堆顶和最后一个元素进行交换
        while(size > 0){
            heapify(arr,0,size);                      //维护大根堆
            swap(arr,0,--size);                          //移除一次大根堆堆顶，继续维护
        }
    }
    //维护大根堆
    private static void heapify(int[] arr, int index, int size) {
        int left = (index * 2) + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;     //获取较大左右孩子的下标
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index) break;
            swap(arr,largest,index);
            index = largest;                    //更新index，使之等于孩子结点，继续往下维护大根堆
            left = index * 2 + 1;
        }
    }

    //初始化大根堆，保证堆顶从上往下都为递减趋势
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {           //当前节点比父节点大，则交换，并继续往上进行判断
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[]arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}








