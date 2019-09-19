package com.ekta.lab2;

import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = s.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.nextInt();
        }
    }
}
