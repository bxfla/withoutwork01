package com.xb.powerplatform.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by shang on 2017/6/29.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public MyDatabaseHelper(Context context){
        super(context,Constant.DATABASE_NAME,null,Constant.DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建题库表
        String sql = "create table "+Constant.TABBLE_NAME
                +"("+Constant.ID+","+Constant.QUTYPE+","+Constant.QUCONTENT
                +","+Constant.QUA+","+Constant.QUB+","+Constant.QUC+","+Constant.QUD
                +","+Constant.QUE+","+Constant.QUF+","+Constant.QUANSWER+","+Constant.QUANALYZE
                +","+Constant.QUCATEGORY+","+Constant.CLASSID+")";
        Log.i("xyz",sql);
        db.execSQL(sql);

        //创建考试规则表
        String sql_rule = "create table "+Constant.TABBLE_NAME_RULE
                +"("+Constant.ID+","+Constant.RADIONUM+","+Constant.MULTINUM
                +","+Constant.JUDGENUM+","+Constant.CLASSID+","+Constant.ERLENGTH+","+Constant.ERPASSMARK
                +","+Constant.ERRADIONUMSAFETY+","+Constant.ERRADIONUMLAWS+","+Constant.ERRADIONUMMAJOR
                +","+Constant.ERMULTINUMSAFETY+","+Constant.ERMULTINUMLAWS+","+Constant.ERMULTINUMMAJOR
                +","+Constant.ERJUDGENUMSAFETY+","+Constant.ERJUDGENUMLAWS+","+Constant.ERJUDGENUMMAJOR
                +","+Constant.ERSCORERADIOSAFETY+","+Constant.ERSCORERADIOLAWS+","+Constant.ERSCORERADIOMAJOR
                +","+Constant.ERSCOREMULTISAFETY+","+Constant.ERSCOREMULTILAWS+","+Constant.ERSCOREMULTIMAJOR
                +","+Constant.ERSCOREJUDGESAFETY+","+Constant.ERSCOREJUDGELAWS+","+Constant.ERSCOREJUDGEMAJOR+")";
        Log.i("xyz",sql);
        db.execSQL(sql_rule);

        //创建错题表
        String sql_error = "create table "+Constant.TABBLE_NAME_ERROR
                +"("+Constant.ID+","+Constant.QUTYPE+","+Constant.QUCONTENT
                +","+Constant.QUA+","+Constant.QUB+","+Constant.QUC+","+Constant.QUD
                +","+Constant.QUE+","+Constant.QUF+","+Constant.QUANSWER+","+Constant.QUANALYZE
                +","+Constant.CLASSID+","+Constant.QUCATEGORY+")";
        Log.i("xyz",sql_error);
        db.execSQL(sql_error);

        //创建报考班级表
        String sql_class = "create table "+Constant.TABBLE_CLASS_NAME
                +"("+Constant.CLASSID+","+Constant.CLASSNAME+","+Constant.DWOSTATIC +")";
        Log.i("xyz",sql_class);
        db.execSQL(sql_class);

        //创建下载报考班级表
        String sql_dwo_class = "create table "+Constant.TABBLE_DOW_CLASS_NAME
                +"("+Constant.CLASSID+","+Constant.CLASSNAME+","+Constant.DWOSTATIC+")";
        Log.i("xyz",sql_dwo_class);
        db.execSQL(sql_dwo_class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
