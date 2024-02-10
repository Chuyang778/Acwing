package com.xuechuyang.binary_check;

import java.util.ArrayList;

/**
 * @author ChuYang
 * @version 1.0
 */
public class template {
    public static void main(String[] args) {

    }
}

class Template{

    public static int get_left(int ll, int rr){
        int l = ll,r = rr;
        while(l < r){
            int mid = (l + r) >> 1;
            if(check(mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static int get_right(int ll, int rr){
        int l = ll,r = rr;
        while(l < r){
            int mid = (l + r + 1) >> 1;
            if(check(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    public static boolean check(int mid){
        return true;
    }
}