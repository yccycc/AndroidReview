package yc.com.debugtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import yc.com.androidreview.R;

public class DebugActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                intent.putExtra("extra_data", "ss");
                startActivity(intent);
                Intent intent1 = getIntent();
                String data = intent1.getStringExtra("extra_data");
                Log.d("SecondActivity", data);
            }
        });
    }
    public void cookMill()
    {
        int a =1;
        int b =1;
        int c = a+b;
        buyGoods();
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void buyGoods()
    {
        giveM(666);
    }
    public void giveM(int a)
    {
        int dd =0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        Log.d("bitchb", "assa");
    }
}
