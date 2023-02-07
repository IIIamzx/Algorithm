package sort;

/**
 * @ Date : 2023-02-07 10:13
 * @ Author : ZX
 * @ Description : 二分查找
 **/
public class java05_BinarySearch {
    public static boolean binarySearch(int[]arr,int target){
        if(arr == null || arr.length == 0){
            return false;
        }
        int left = 0,right = arr.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
    public static int binarySearch_left(int[]arr,int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0,right = arr.length-1;
        int index = 0;
        while(left < right){
            int mid = left + (right-left) / 2;
            if(arr[mid] == target){     //此时 arr[mid] == target,可能还有更左侧的位置
                index = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return index;
    }
}
