package com.xb.powerplatform.thread;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.xb.powerplatform.DB.Constant;
import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.activity.ErrorActivity;
import com.xb.powerplatform.education_and_training.activity.MoreSelectActivity;
import com.xb.powerplatform.education_and_training.activity.OneSelectActivity;
import com.xb.powerplatform.education_and_training.activity.TorFActivity;
import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.util.BaseRequestAssessLisenter;

import java.util.List;


/**
 * Created by dell on 2017/12/18.
 */

public class GetDataThread {

    //得到单选题
    public static void getOneSelectData(final OneSelectActivity oneSelectActivity, final String classId, final MyDatabaseHelper helper,
                                     final List<assess.BodyBean.ListBean> beanList,
                                     final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from moni where classid='"+classId+"' and quType='0'";
                // cursor = db.query(Constant.TABBLE_NAME,null,Constant.ANSWER+"=?",new String[]{"1"},null,null,Constant.ID+" desc");
                Cursor cursor = DbManager.queryBySQL(db, sql, null);
                while (cursor.moveToNext()) {
                    // 根据参数指定的字段来读取字段下标
                    int index = cursor.getColumnIndex(Constant.ID);
                    // 根据参数中指定的字段下标来获取指定的数据
                    int id = cursor.getInt(index);
                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
                    assess.BodyBean.ListBean resultBean = new assess.BodyBean.ListBean
                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer, quAnalyze, classId);
                    beanList.add(resultBean);
                }
                for (int i = 0; i < beanList.size(); i++) {
                    viewItems.add(oneSelectActivity.getLayoutInflater().inflate(
                            R.layout.vote_submit_viewpager_item, null));
                }
                //通过回调讲结果发出
                if (baseRequestAssessLisenter!=null){
                    baseRequestAssessLisenter.success(viewItems,beanList);
                }

            }
        }).start();
    }


    //得到判断题
    public static void getTorFData(final TorFActivity torFActivity, final String classId, final MyDatabaseHelper helper,
                                   final List<assess.BodyBean.ListBean> beanList,
                                   final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from moni where classid='"+classId+"' and quType='2'";
                // cursor = db.query(Constant.TABBLE_NAME,null,Constant.ANSWER+"=?",new String[]{"1"},null,null,Constant.ID+" desc");
                Cursor cursor = DbManager.queryBySQL(db, sql, null);
                while (cursor.moveToNext()) {
                    // 根据参数指定的字段来读取字段下标
                    int index = cursor.getColumnIndex(Constant.ID);
                    // 根据参数中指定的字段下标来获取指定的数据
                    int id = cursor.getInt(index);
                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
                    assess.BodyBean.ListBean resultBean = new assess.BodyBean.ListBean
                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer, quAnalyze, classId);
                    beanList.add(resultBean);
                }
                for (int i = 0; i < beanList.size(); i++) {
                    viewItems.add(torFActivity.getLayoutInflater().inflate(
                            R.layout.vote_submit_viewpager_item, null));
                }
                //通过回调讲结果发出
                if (baseRequestAssessLisenter!=null){
                    baseRequestAssessLisenter.success(viewItems,beanList);
                }

            }
        }).start();
    }



    //得到判断题
    public static void getMoreSelectData(final MoreSelectActivity moreSelectActivity, final String classId, final MyDatabaseHelper helper,
                                         final List<assess.BodyBean.ListBean> beanList,
                                         final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from moni where classid='"+classId+"' and quType='1'";
                // cursor = db.query(Constant.TABBLE_NAME,null,Constant.ANSWER+"=?",new String[]{"1"},null,null,Constant.ID+" desc");
                Cursor cursor = DbManager.queryBySQL(db, sql, null);
                while (cursor.moveToNext()) {
                    // 根据参数指定的字段来读取字段下标
                    int index = cursor.getColumnIndex(Constant.ID);
                    // 根据参数中指定的字段下标来获取指定的数据
                    int id = cursor.getInt(index);
                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
                    assess.BodyBean.ListBean resultBean = new assess.BodyBean.ListBean
                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer, quAnalyze, classId);
                    beanList.add(resultBean);
                }
                for (int i = 0; i < beanList.size(); i++) {
                    viewItems.add(moreSelectActivity.getLayoutInflater().inflate(
                            R.layout.vote_submit_viewpager_item, null));
                }
                //通过回调讲结果发出
                if (baseRequestAssessLisenter!=null){
                    baseRequestAssessLisenter.success(viewItems,beanList);
                }

            }
        }).start();
    }



    //得到错题集
    public static void getErrorData(final ErrorActivity errorActivity, final String classId, final MyDatabaseHelper helper,
                                    final List<assess.BodyBean.ListBean> beanList,
                                    final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from error";
                Cursor cursor = DbManager.queryBySQL(db, sql, null);
                while (cursor.moveToNext()) {
                    // 根据参数指定的字段来读取字段下标
                    int index = cursor.getColumnIndex(Constant.ID);
                    // 根据参数中指定的字段下标来获取指定的数据
                    int id = cursor.getInt(index);
                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
                    assess.BodyBean.ListBean resultBean = new assess.BodyBean.ListBean
                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer, quAnalyze, classId);
                    beanList.add(resultBean);
                }
                for (int i = 0; i < beanList.size(); i++) {
                    viewItems.add(errorActivity.getLayoutInflater().inflate(
                            R.layout.vote_submit_viewpager_item, null));
                }
                //通过回调讲结果发出
                if (baseRequestAssessLisenter!=null){
                    baseRequestAssessLisenter.success(viewItems,beanList);
                }

            }
        }).start();
    }
}
