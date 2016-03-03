package yc.com.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import yc.com.androidreview.R;

public class Aa extends AppCompatActivity {
    private int cc;
    private TextView textView;
    private String tag = "aabitch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa);
        Log.i(tag,"onCreate");
        textView = (TextView) findViewById(R.id.tv);
        findViewById(R.id.aa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aa.this,Bb.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.i(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.i(tag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.i(tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
       // Log.i(tag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "onDestroy");
    }
}
