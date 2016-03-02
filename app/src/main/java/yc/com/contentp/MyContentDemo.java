package yc.com.contentp;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import yc.com.androidreview.R;

public class MyContentDemo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		insertRecord("MyUser");
		displayRecords();
	}

	private void insertRecord(String userName) {
		ContentValues values = new ContentValues();
		values.put(MyUsers.User.USER_NAME, userName);
		getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
	}

	private void displayRecords() {
		String columns[] = new String[] { MyUsers.User._ID, MyUsers.User.USER_NAME };
		Uri myUri = MyUsers.User.CONTENT_URI;
		Cursor cur = managedQuery(myUri, columns,null, null, null );
		if (cur.moveToFirst()) {
			String id = null;
			String userName = null;
			do {
				id = cur.getString(cur.getColumnIndex(MyUsers.User._ID));
				userName = cur.getString(cur.getColumnIndex(MyUsers.User.USER_NAME));
				Toast.makeText(this, id + "" + userName, Toast.LENGTH_LONG).show();
			} while (cur.moveToNext());
		}
	}
}