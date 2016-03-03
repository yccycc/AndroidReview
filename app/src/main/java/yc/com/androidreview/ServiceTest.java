package yc.com.androidreview;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ServiceTest extends AppCompatActivity implements ServiceConnection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ServiceTest.this, MyService.class));
            }
        });
        findViewById(R.id.stp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ServiceTest.this, MyService.class));
            }
        });
        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(ServiceTest.this, MyService.class), ServiceTest.this, Context.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.btn_unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(ServiceTest.this);
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
       // Log.i("dabi", "onServiceConnected()"+service.as);
        //IInterface.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}