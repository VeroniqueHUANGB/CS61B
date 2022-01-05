import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    static int n = 0, m = 0, N = 201000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A,B,C;
        A=sc.nextInt();
        B=sc.nextInt();
        C=sc.nextInt();
        String ans="";
        if(A==0&&B==0) {
            for(int i=1;i<=Math.min(2,C);i++) ans+='c';
            System.out.println(ans);
        }
        if(A==0&&C==0) {
            for(int i=1;i<=Math.min(2,B);i++) ans+='b';
            System.out.println(ans);
        }
        if(C==0&&B==0) {
            for(int i=1;i<=Math.min(2,A);i++) ans+='a';
            System.out.println(ans);
        }

        int mi=Math.min(Math.min(A,B),C);
        for(int x=0;x<mi;x++) {
            ans=ans+"abc";
        }
        A-=mi; B-=mi; C-=mi;
        mi=0;
        if(A>0&&B>0) {
            mi=Math.min(A,B);
        } else if(B>0&&C>0) {
            mi=Math.min(B,C);
        } else if(A>0&&C>0) {
            mi=Math.min(A,C);
        }
        for(int x=0;x<mi;x++) {
            if(A>0&&B>0) ans=ans+"ab";
            if(A>0&&C>0) ans=ans+"ac";
            if(B>0&&C>0) ans=ans+"bc";
        }
        A-=mi; B-=mi; C-=mi;
        String res="";
        if(A>0) {
            for(int i=0;i<ans.length();i++) {
                if((i-1<0||ans.charAt(i-1)!='a')&&ans.charAt(i)!='a') {
                    if(A>=2) {
                        res=res+"aa";
                        A-=2;
                    } else if(A==1) {
                        A--;
                        res=res+"a";
                    }
                    res+=ans.charAt(i);
                }
                else if(ans.charAt(i)=='a') {
                    if(A>0) {
                        res+="aa";
                        A--;
                    } else res+="a";
                }
                else res+=ans.charAt(i);
            }
            for(int i=1;i<=Math.min(2,A);i++) ans+='a';
        } else if(B>0) {
            for(int i=0;i<ans.length();i++) {
                if((i-1<0||ans.charAt(i-1)!='b')&&ans.charAt(i)!='b') {
                    if(B>=2) {
                        res=res+"bb";
                        B-=2;
                    } else if(B==1) {
                        B--;
                        res=res+"b";
                    }
                    res+=ans.charAt(i);
                }
                else if(ans.charAt(i)=='b') {
                    if(B>0) {
                        res+="bb";
                        B--;
                    } else res+="b";
                }
                else res+=ans.charAt(i);
            }
            for(int i=1;i<=Math.min(2,B);i++) ans+='b';
        } else if(C>0) {
            for(int i=0;i<ans.length();i++) {
                if((i-1<0||ans.charAt(i-1)!='c')&&ans.charAt(i)!='c') {
                    if(C>=2) {
                        res=res+"cc";
                        C-=2;
                    } else if(C==1) {
                        C--;
                        res=res+"c";
                    }
                    res+=ans.charAt(i);
                }
                else if(ans.charAt(i)=='c') {
                    if(C>0) {
                        res+="cc";
                        C--;
                    } else res+="c";
                }
                else res+=ans.charAt(i);
            }
            for(int i=1;i<=Math.min(2,C);i++) ans+='c';
        } else res=ans;
        System.out.println(res);
    }
}
