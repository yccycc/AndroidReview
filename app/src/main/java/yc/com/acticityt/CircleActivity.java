package yc.com.acticityt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import yc.com.androidreview.MainActivity;
import yc.com.androidreview.R;

public class CircleActivity extends Activity
{
    private Button mBtnFinish;
    private Button mBtnShowDialog;
    private Button mBtnOpenAno;
    private String tag = "bitch1";

    private void assignViews() {
        mBtnFinish = (Button) findViewById(R.id.btn_finish);
        mBtnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        mBtnOpenAno = (Button) findViewById(R.id.btn_open_ano);
    }


    @Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle);
		Log.i(tag, "onCreate");
		assignViews();
		mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircleActivity.this.finish();
            }
        });
		mBtnShowDialog.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(CircleActivity.this);
                builder.setMessage("是否接受文件?").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
					public void onClick(DialogInterface dialog, int which)
					{

					}
				}).setNegativeButton("否", new AlertDialog.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
					}
				});

				AlertDialog ad = builder.create();
				ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
				ad.setCanceledOnTouchOutside(false);
				ad.show();
			}
		});
        mBtnOpenAno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CircleActivity.this, MainActivity.class));
            }
        });
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.i(tag, "onStart");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.i(tag, "onResume");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i(tag, "onPause");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(tag, "onStop");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(tag, "onDestroy");
	}
}
