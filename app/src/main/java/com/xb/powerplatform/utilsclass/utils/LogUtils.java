package com.xb.powerplatform.utilsclass.utils;
import android.util.Log;

import com.xb.powerplatform.utilsclass.base.MyApplication;

/**
 * 打印信息控制类
 * 控制debug模式
 */

public class LogUtils {
    public static void logMessage(String message){
        if(MyApplication.IS_DEBUG){
            Log.e("Tag",message);
        }
    }
}
