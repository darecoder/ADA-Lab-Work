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
        return -1;
    }
}