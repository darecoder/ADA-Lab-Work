package com.ekta.lab2;

import java.util.Arrays;
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

        int[] freq = new int[10];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int cnt = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                nums[cnt] = i;
                cnt++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
