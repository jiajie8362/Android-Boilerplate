package cn.funvideo.android_boilerplate.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import cn.funvideo.android_boilerplate.BoilerplateApplication;

@EBean
public class DbOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ribots.db";
    public static final int DATABASE_VERSION = 2;

    @RootContext
    Context context;

    public DbOpenHelper() {
        super(BoilerplateApplication.applicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(Db.RibotProfileTable.CREATE);
            //Add other tables here
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
