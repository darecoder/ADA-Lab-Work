package com.ekta.lab1;

import  java.util.Arrays;

public class Sorting {

    static int cost1 = 0;
    static int cost2 = 0;
    static int cost3 = 0;
    static int cost4 = 0;
    static int cost5 = 0;
    static int cost6 = 0;
    static int cost7 = 0;
    static int cost8 = 0;

    public static void main(String[] args) {

        int[] nums1 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        System.out.println("Input Array : " + Arrays.toString(nums1));
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
        int[] nums4 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        bubbleSort(nums4);
        System.out.println(Arrays.toString(nums4));
        int[] nums5 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        radixSort(nums5);
        System.out.println("Radix sort cost : " + cost5);
        System.out.println(Arrays.toString(nums5));
        int[] nums6 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        shellSort(nums6);
        System.out.println(Arrays.toString(nums6));
        int[] nums7 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        selectionSort(nums7);
        System.out.println(Arrays.toString(nums7));
        int[] nums8 = {1,6,3,7,2,5,0,2,1,7,2,0,9};
        heapSort(nums8);
        System.out.println("Heap sort cost : "+ cost8);
        System.out.println(Arrays.toString(nums8));

    }

    public static void insertionSort(int[] nums) {
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

    public static void swap(int[] nums, int st, int end) {
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp;
    }

    public static int[] mergeSort(int[] nums){
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

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                res[k++] = first[i++];
            }else{
                res[k++] = second[j++];
            }
        }
        while(i < first.length){
            res[k++] = first[i++];
        }
        while(j < second.length){
            res[k++] = second[j++];
        }
        return res;
    }

    public static void bubbleSort(int[] nums) {
        cost4++;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if (nums[j] > nums[j+1]) {
                    cost4++;
                    swap(nums,j,j+1);
                    cost4++;
                }
            }
        }
        System.out.println("Bubble sort cost : " + cost4);
    }

    public static void radixSort(int[] nums) {
        int max = getMax(nums);
        for (int exp = 1; max/exp > 0; exp *= 10) {
            countSort(nums,exp);
            cost5++;
        }

    }

    public static void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        cost5++;

        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
            cost5++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            cost5++;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            cost5++;
            count[(arr[i] / exp) % 10]--;
            cost5++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
            cost5++;
        }
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void shellSort(int[] nums) {
        cost6++;
        for (int gap = nums.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i += 1) {
                cost6++;
                int temp = nums[i];
                int j;
                cost6++;
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];
                    cost6++;
                }
                nums[j] = temp;
            }
            cost6++;
        }
        System.out.println("Shell sort cost : " + cost6);

    }

    public static void selectionSort(int[] nums) {
        cost7++;
        for (int i = 0; i < nums.length-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
                cost7++;
            }

            swap(nums,min_idx,i);
            cost7++;
        }
        System.out.println("Selection sort cost : " + cost7);

    }

    public static void heapSort(int[] nums) {

        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            cost8++;
            heapify(nums,nums.length, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            cost8++;
            swap(nums,0,i);
            cost8++;
            heapify(nums, i, 0);
        }

    }

    public static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
            cost8++;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
            cost8++;
        }
        if (largest != i) {
            swap(arr,i,largest);
            cost8++;
            heapify(arr, n, largest);
        }

    }

}
