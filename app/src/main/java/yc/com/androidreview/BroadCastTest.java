package yc.com.androidreview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BroadCastTest extends Activity {
    private EditText mMainaStateEt;
    private Button mMainaStateSaveBtn;
    private Button mMainaStateAddBtn;
    private Button mMainaStateDelBtn;
    private Button mMainaStateModifyBtn;
    private Button mMainaStateSelectBtn;

    private void assignViews() {
        mMainaStateEt = (EditText) findViewById(R.id.maina_state_et);
        mMainaStateSaveBtn = (Button) findViewById(R.id.maina_state_save_btn);
        mMainaStateAddBtn = (Button) findViewById(R.id.maina_state_add_btn);
        mMainaStateDelBtn = (Button) findViewById(R.id.maina_state_del_btn);
        mMainaStateModifyBtn = (Button) findViewById(R.id.maina_state_modify_btn);
        mMainaStateSelectBtn = (Button) findViewById(R.id.maina_state_select_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ycc_broad");   //为BroadcastReceiver指定action，使之用于接收同action的广播
        registerReceiver(new MyBroadcastReceiver(), intentFilter);
        mMainaStateSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("ycc_broad");
                intent.putExtra("msg", "hi,我通过广播发送消息了");
                sendBroadcast(intent);
            }
        });
    }
}
class  MyBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("sexybitch", "onReceive");
    }
}