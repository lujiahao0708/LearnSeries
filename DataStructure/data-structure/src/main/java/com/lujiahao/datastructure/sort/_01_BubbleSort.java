package com.lujiahao.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author lujiahao
 * @date 2020-09-09
 */
public class _01_BubbleSort {
    private static final int[] arr = {2, 1, 5, 3, 8, 7, 9};

    public static void main(String[] args) {
        Arrays.stream(arr).forEach(System.out::print);

        //外层进行 length-1 次循环
        for (int i = 0; i < arr.length - 1; i++) {
            //内层每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，
            // 同时由于内层每轮循环结束,最后一个值都是最大的,所以内层每次比较次数减去外层进行过的循环次数(即已经排好序的个数)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);
    }

    /**
     * 交换数据
     **/
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     *      O(n2)	O(n)	O(n2)	O(1)
     **/

    /** 交换数据的三种方法 **/

    /**
     * 通过临时变量交换数组array的i和j位置的数据
     * @param array 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swapByTemp(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 通过算术法交换数组array的i和j位置的数据（有可能溢出）
     * @param array 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void  swapByArithmetic(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }


    /**
     * 通过位运算法交换数组array的i和j位置的数据
     * @param array 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void  swapByBitOperation(int[] array, int i, int j) {
        array[i] = array[i]^array[j];
        array[j] = array[i]^array[j]; //array[i]^array[j]^array[j]=array[i]
        array[i] = array[i]^array[j]; //array[i]^array[j]^array[i]=array[j]
    }

//    作者：foofoo
//    链接：https://juejin.im/post/6844903687932887053
//    来源：掘金
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
