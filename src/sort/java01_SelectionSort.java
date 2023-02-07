package sort;

/**
 * @ Date : 2023-02-07 07:46
 * @ Author : ZX
 **/
public class java01_SelectionSort {
    public static void main(String[] args) {
        int []sort = {2,222,44,520,0,6666,5,666,88};
        int[] results = selectionSort(sort);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }


    public static int[] selectionSort(int[]arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        for(int i = 0;i < arr.length - 1;i++){
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){      //循环一次找到最小值下标
                //若当前数小于minIndex所记录的数，则更新最小值下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);                       //将记录的最小值的下标，进行交换，完成一次选择排序
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int minIndex) {
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }
}
