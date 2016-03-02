package yc.com.contentp;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Administrator on 2016/3/2.
 */
public class MyUsers {
    public static final String AUTHORITY  = "com.wissen.MyContentProvider";

    // BaseColumn类中已经包含了 _id字段
    public static final class User implements BaseColumns {
        public static final Uri CONTENT_URI  = Uri.parse("content://com.wissen.MyContentProvider");
        // 表数据列
        public static final String  USER_NAME  = "USER_NAME";
    }
}
