package com.ekta.lab1;

import java.util.Arrays;

public class Sorting {
    static int cost1 = 0;
    static int cost2 = 0;
    static int cost3 = 0;
    public static void main(String[] args) {
        int[] nums1 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        insertionSort(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        quickSort(nums2,0,nums2.length-1);
        System.out.println("Quick sort cost : " + cost2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        nums3 = mergeSort(nums3);
        System.out.println("Merge sort cost : " + cost3);
        System.out.println(Arrays.toString(nums3));
    }

    private static void insertionSort(int[] nums) {
        cost1++;
        for (int i = 1; i < nums.length; i++) {
            cost1 += 4;
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key){
                cost1 ++;
                nums[j+1] = nums[j];
                j--;
            }
            cost1++;
            nums[j+1] = key;
        }

        System.out.println("Insertion sort cost : " + cost1);
    }

    public static void quickSort(int[] nums,int start, int end){
        cost2++;
        if(start >= end){
            return;
        }
        int p = pivot(nums,start,end);

        quickSort(nums,start,p-1);
        quickSort(nums,p+1,end);
    }

    public static int pivot(int[] nums,int start,int end){
        cost2 ++;
        int p = end;
        int j=start;

        for (int i = start; i <= end; i++) {
            cost2++;
            if(nums[i] < nums[p]) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums,p,j);
        return j;
    }

    private static void swap(int[] nums, int st, int end) {
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp;
    }

    public static int[] mergeSort(int[] nums){
        cost3++;
        if(nums.length < 2){
            return nums;
        }

        int mid = nums.length/2;

        int[] first = Arrays.copyOfRange(nums,0,mid);
        int[] second = Arrays.copyOfRange(nums,mid,nums.length);

        first = mergeSort(first);
        second = mergeSort(second);

        return merge(first, second);
    }

    public static int[] merge(int[] first, int[] second){
        int i=0,j=0,k=0;
        int[] res = new int[first.length+second.length];

        cost3++;
        while(i < first.length && j < second.length){
            cost3++;
            if(first[i] < second[j]){
                res[k++] = first[i++];
            }else{
                res[k++] = second[j++];
            }
        }
        cost3++;
        while(i < first.length){
            res[k++] = first[i++];
        }
        while(j < second.length){
            res[k++] = second[j++];
        }
        return res;
    }
}
