package yc.com.androidreview;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
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
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		assignViews();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getReadableDatabase();
        Log.i("bigbitch",((Long) DatabaseUtils.longForQuery(db, "PRAGMA user_version;", null)).intValue()+"");
		mMainaStateSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("username", "psy");
                cv.put("password", "psy456");
                db.insert("mytable", null, cv);
                cv.put("username", "xd");
                cv.put("password", "xd123");
                db.insert("mytable", null, cv);
            }
        });
        mMainaStateSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.query("mytable",null,null,null,null,null,null);
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
        mMainaStateModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "update mytable set password = 'xindeddddiii' where username='xd'";
                db.execSQL(sql);
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
	private static final String DB_NAME = "yccdatayycc.db";
	private static final int version = 1;

	public DatabaseHelper(Context context)
	{
		super(context, DB_NAME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
        Log.i("sexybitch","onCreate(SQLiteDatabase db)");
        String sql1 = "create table mytable(username varchar(20) not null , password varchar(60) not null );";
        db.execSQL(sql1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
	}
}
