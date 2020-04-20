package com.example.testc.service;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

/**
 * Date: 2020/4/17
 * Time: 17:32
 * author: cmt
 * desc:
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobSchService extends JobService {
    public static void startJob(Context context){
        Log.e("MyJobSchService", "startJob: " );
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(3,new ComponentName(context.getPackageName(),MyJobSchService.class.getName())).setPersisted(true);
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            builder.setPeriodic(1000);
        }else{
            builder.setMinimumLatency(1000);
        }
        jobScheduler.schedule(builder.build());
    }
    @Override
    public boolean onStartJob(JobParameters params) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            Log.e("hahha","we restart");
            startJob(this);
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
