package yc.com.androidreview;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.SoftReference;

public class MyService extends Service
{
    private String tag = "bitch";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(tag, "onBind()"+"&"+Thread.currentThread());
        SoftReference<MyService> ss;
        return new Binder(){
            String getName()
            {
                return "ycc";
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(MyService.this,"from service",Toast.LENGTH_LONG).show();
        Log.i(tag, "onCreate()");
        new Thread(){
            @Override
            public void run() {
                super.run();
                for(;;){
                  //  Log.i("bitch", "onCreate()"+Thread.currentThread());//main
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(tag, "onStartCommand()" );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(tag, "onStart()" );
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(tag, "onDestroy(()");
    }
}
