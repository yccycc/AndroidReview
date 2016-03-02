package yc.com.androidreview;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class DbNoUseHelper extends AppCompatActivity {
    private SQLiteDatabase db;
    public static final String DB_NAME="studentdata.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase(DB_NAME, this.MODE_PRIVATE, null);
    }
}
