package sort;

/**
 * @ Date : 2023-02-07 08:53
 * @ Author : ZX
 **/
public class java03_EvenTimeOddTime {

    //使用异或运算得到，数组中唯一出现一次的奇数次数字
    public static void odd_one(int[]arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println("出现奇数次的数为：" + eor);
    }


    public static void odd_two(int[]arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;           //得到 eor = a ^ b      a ,b 在某一位上一定不相同
        }

        int rightOne = eor& (~eor + 1);     //取出最右的 1

        int onlyOne = 0;
        for (int i : arr) {
            if((rightOne & i) == 0){        //将某位数为0 的数全部进行异或
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
