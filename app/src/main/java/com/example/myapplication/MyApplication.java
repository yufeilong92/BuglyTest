package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: SutdyProgcet
 * @Package com.example.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2019.02.21 下午 1:33
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
//        CrashReport.initCrashReport(getApplicationContext(),"02634cd288",true);
        CrashReport.initCrashReport(getApplicationContext());
    }

    private String getProcessName(int i) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + "test" + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
