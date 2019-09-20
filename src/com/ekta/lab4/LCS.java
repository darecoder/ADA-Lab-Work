package com.ekta.lab4;

public class LCS {
    public static void main(String[] args) {
        String f ="aman";
        String s ="naman";
        Integer[][] mem = new Integer[f.length()+1][s.length()+1];
        System.out.println(lcs(f,s,f.length(),s.length(),mem));

    }

    public static int lcs(String f,String s,int flen,int slen,Integer[][] mem){
        for (int i = 0; i <= flen ; i++) {
            for (int j = 0; j <= slen; j++) {
                if(i == 0 || j == 0){
                    mem[i][j] = 0;
                }else {
                    if(f.charAt(i - 1) == s.charAt(j - 1)){
                        mem[i][j] = 1 + mem[i-1][j-1];
                    }else{
                        mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
                    }
                }
            }
        }
        return mem[flen][slen];
    }
}
