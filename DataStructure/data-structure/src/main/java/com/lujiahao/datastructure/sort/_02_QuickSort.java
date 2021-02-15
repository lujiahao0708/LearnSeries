package com.lujiahao.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author lujiahao
 * @date 2020-09-09
 */
public class _02_QuickSort {
    public static final int[] arr = {3, 1, 4, 6, 2, 5};
    public static void main(String[] args) {
        System.out.println("原始数组:" + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
//        sort2(arr, 0, arr.length - 1);
        System.out.println("最终排序结果:" + Arrays.toString(arr));
    }

    /** 挖坑法递归 **/
    public static void sort(int arr[], int low, int hight) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= hight) {
            return;
        }
        int left = low;
        int right = hight;
        // 挖坑 1:保存基准值
        int temp = arr[left];

        while (left < right) {
            // 从后向前找到比基准值小的数
            while (left < right && temp <= arr[right]) {
                right--;
            }
            // 坑 2:找到后将元素插入到基准坑位1中,同时元素原来的位置变为坑 2
            arr[left] = arr[right];

            // 从前向后找到比基准值大的数
            while (left < right && temp >= arr[left]) {
                left++;
            }
            // 坑 3:找到后将元素插入到坑 2 中,同时元素原来的位置变为坑 3
            arr[right] = arr[left];
        }

        // 基准值舔不到坑 3 中,准备分治递归快排
        arr[left] = temp;
        System.out.println("Sorting:" + Arrays.toString(arr));
        sort(arr, low, left - 1);
        sort(arr, left + 1, hight);
    }

    public static void sort2(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        int key = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, left);
        System.out.println("Sorting: " + Arrays.toString(arr));
        sort2(arr, low, left - 1);
        sort2(arr, left + 1, high);
    }

    public static void swap(int arr[], int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }

//    作者：foofoo
//    链接：https://juejin.im/post/6844903687932887053
//    来源：掘金
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
