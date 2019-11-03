package com.ekta.lab2;

import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = s.nextInt();
        System.out.print("Enter the elements : ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

//        System.out.println(linearSearch(nums, 8));
        System.out.println(binarySearch(nums, 8));

    }

    public static int linearSearch(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return target;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target){
        int start = 0;
        int end =  nums.length;
        while ( start < end ){
            int mid = (start + end)/2;
            if ( target ==  nums[mid]){
                return mid;
            } else if( target < mid){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
