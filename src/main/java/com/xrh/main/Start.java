package com.xrh.main;

import com.xrh.utils.TimeService;

/**
 * Created by buptxuruhong on 2018/4/30.
 */
public class Start {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(TimeService.currentTimeMillis() + "11");
            System.out.println(TimeService.currentTimeMillis());
        }
    }
}
