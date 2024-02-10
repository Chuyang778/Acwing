package com.xuechuyang.sort;

import java.util.Arrays;

/**
 * @author ChuYang
 * @version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 15};
        mergeSort(arr,0, 3);
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int k = 0, i = left, j = mid + 1;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= right){
            temp[k++] = arr[j++];
        }
        for(i = left, j = 0; i <= right; i++, j++){
            arr[i] = temp[j];
        }
    }
}
