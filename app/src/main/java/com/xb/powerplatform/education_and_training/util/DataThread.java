package com.xb.powerplatform.education_and_training.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.education_and_training.bean.Question;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;

import java.util.List;

/**
 * Created by dell on 2017/12/13.
 */

public class DataThread {


    public static void getDbData(List<Question.BodyBean.ListBean> beanList, final SQLiteDatabase db, MyDatabaseHelper helper, final BaseRequestBackLisenter baseRequestBackLisenter) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String sql = "select * from moni where quType='1'";
                Cursor cursor = DbManager.queryBySQL(db, sql, null);
                //beanList = DbManager.cursorToPerson(cursor);
                //通过回调讲结果发出
                if (baseRequestBackLisenter!=null){
                    baseRequestBackLisenter.success(DbManager.cursorToPerson(cursor));
                }
            }
        }).start();
    }
}
