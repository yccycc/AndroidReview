package yc.com.androidreview;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
    private SQLiteDatabase db = null;

    private EditText mMainaStateEt;
    private Button mMainaStateSaveBtn;
    private Button mMainaStateSelectBtn;

    private void assignViews() {
        mMainaStateEt = (EditText) findViewById(R.id.maina_state_et);
        mMainaStateSaveBtn = (Button) findViewById(R.id.maina_state_save_btn);
        mMainaStateSelectBtn = (Button) findViewById(R.id.maina_state_select_btn);
    }

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		assignViews();
        DatabaseHelper database = new DatabaseHelper(this);
        db = database.getReadableDatabase();
		mMainaStateSaveBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
                ContentValues cv = new ContentValues();
                cv.put("username","Jack Johnson");
                cv.put("password","iLovePopMusic");
                db.insert("user",null,cv);
			}
		});
        mMainaStateSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.query("user",null,null,null,null,null,null);
                if(c.moveToFirst()){
                    for(int i=0;i<c.getCount();i++){
                        Log.i("bitch", "--@" + i);
                        String username = c.getString(c.getColumnIndex("username"));
                        String password = c.getString(c.getColumnIndex("password"));
                        Log.i("bitch",username+"&"+password+"--"+i);
                        c.moveToNext();
                    }
                }
            }
        });
	}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}

class DatabaseHelper extends SQLiteOpenHelper
{
	private static final String DB_NAME = "mydata.db";
	private static final int version = 1;

	public DatabaseHelper(Context context)
	{
		super(context, DB_NAME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String sql = "create table user(username varchar(20) not null , password varchar(60) not null );";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
	}
}
