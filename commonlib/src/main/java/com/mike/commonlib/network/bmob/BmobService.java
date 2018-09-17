package com.mike.commonlib.network.bmob;

import android.content.Context;

import cn.bmob.v3.Bmob;

public class BmobService {
    public static void init(Context context){
        Bmob.initialize(context,"09290e6a523856afd2a08a81f8f80007");
    }
}