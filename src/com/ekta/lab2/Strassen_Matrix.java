package com.ekta.lab2;

import java.util.Scanner;

public class Strassen_Matrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the dimensions of matrix 1 : ");
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.print("Enter the elements of the matrix 1 : ");
        int[][] num1 = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                num1[i][j] = s.nextInt();
            }
        }

        System.out.print("Enter the dimensions of matrix 2 : ");
        int x = s.nextInt();
        int y = s.nextInt();
        System.out.print("Enter the elements of the matrix 2 : ");
        int[][] num2 = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                num2[i][j] = s.nextInt();
            }
        }

    }
}
