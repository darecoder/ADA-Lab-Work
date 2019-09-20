package com.ekta.lab3;

public class _01_KnapSack {
    public static void main(String[] args) {
        int[] p = {5, 10, 7, 5};
        int[] w = {2, 1, 2, 2};
        int cap = 3;
        Integer[][] mem = new Integer[cap + 1][p.length + 1];
        System.out.println(zeroOneDPitr(w,p,cap,p.length,mem));

    }

    public static int zeroOneDPitr(int[] wts, int[] prs, int cap, int size, Integer[][] mem){

        for (int c = 0; c <= cap; c++) {
            for (int s = 0; s <= size; s++) {
                if(s == 0){
                    mem[c][s] = 0;
                }else {
                    int acc = 0;
                    if(wts[s - 1] <= c){
                        acc = prs[s-1] + mem[c-wts[s-1]][s-1];
                    }

                    int reject = mem[c][s-1];
                    mem[c][s] = Math.max(acc,reject);
                }
            }
        }
        return mem[cap][size];
    }
}
