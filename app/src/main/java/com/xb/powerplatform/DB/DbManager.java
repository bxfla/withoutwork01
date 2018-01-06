package com.xb.powerplatform.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xb.powerplatform.education_and_training.bean.ClassName;
import com.xb.powerplatform.education_and_training.bean.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shang on 2017/6/29.
 */

public class DbManager {
    private static MyDatabaseHelper helper;
    //试题
    public static MyDatabaseHelper getInstance(Context context){
        if (helper==null){
            helper = new MyDatabaseHelper(context);
        }
        return helper;
    }

    public static Cursor queryBySQL(SQLiteDatabase db,String sql,String []selectionArgs){
        Cursor cursor = null;
        if (db!=null){
            cursor = db.rawQuery(sql,selectionArgs);
        }
        return cursor;
    }

    //将考试cause转化成list
    public static List<Question.BodyBean.ListBean> cursorToPerson(Cursor cursor){
        List<Question.BodyBean.ListBean> list = new ArrayList<>();
        while (cursor.moveToNext()){
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
            String quCategory = cursor.getString(cursor.getColumnIndex(Constant.QUCATEGORY));
            String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
            Question.BodyBean.ListBean resultBean = new Question.BodyBean.ListBean
                    (ID,quType,quContent,quA,quB,quC,quD,quE,quF,quAnswer,quAnalyze,quCategory,classId);
            list.add(resultBean);
        }
        return list;
    }

    //将班级cause转化成list
    public static List<ClassName> cursorToClassName(Cursor cursor){
        List<ClassName> list = new ArrayList<>();
        while (cursor.moveToNext()){
//            // 根据参数指定的字段来读取字段下标
//            int index = cursor.getColumnIndex(Constant.ID);
            // 根据参数中指定的字段下标来获取指定的数据
//            int id = cursor.getInt(index);
            String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
            String className = cursor.getString(cursor.getColumnIndex(Constant.CLASSNAME));
            String dwoStatic = cursor.getString(cursor.getColumnIndex(Constant.DWOSTATIC));
            ClassName resultBean = new ClassName
                    (className,classId,dwoStatic);
            list.add(resultBean);
        }
        return list;
    }

    //将规则cause转化成list
    public static List<Question.BodyBean.RuleBean> cursorTorule(Cursor cursor){
        List<Question.BodyBean.RuleBean> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int radioNum = cursor.getInt(cursor.getColumnIndex(Constant.RADIONUM));
            int multiNum = cursor.getInt(cursor.getColumnIndex(Constant.MULTINUM));
            int judgeNum = cursor.getInt(cursor.getColumnIndex(Constant.JUDGENUM));
            int erLength = cursor.getInt(cursor.getColumnIndex(Constant.ERLENGTH));
            int erPassMark = cursor.getInt(cursor.getColumnIndex(Constant.ERPASSMARK));
            int erScoreRadioSafety = cursor.getInt(cursor.getColumnIndex(Constant.ERSCORERADIOSAFETY));
            int erScoreRadioLaws = cursor.getInt(cursor.getColumnIndex(Constant.ERSCORERADIOLAWS));
            int erScoreRadioMajor = cursor.getInt(cursor.getColumnIndex(Constant.ERSCORERADIOMAJOR));
            int erScoreMultiSafety = cursor.getInt(cursor.getColumnIndex(Constant.ERSCOREMULTISAFETY));
            int erScoreMultiLaws = cursor.getInt(cursor.getColumnIndex(Constant.ERSCOREMULTILAWS));
            int erScoreMultiMajor = cursor.getInt(cursor.getColumnIndex(Constant.ERSCOREMULTIMAJOR));
            int erScoreJudgeSafety = cursor.getInt(cursor.getColumnIndex(Constant.ERSCOREJUDGESAFETY));
            int erScoreJudgeLaws = cursor.getInt(cursor.getColumnIndex(Constant.ERSCOREJUDGELAWS));
            int erScoreJudgeMajor = cursor.getInt(cursor.getColumnIndex(Constant.ERSCOREJUDGEMAJOR));
            String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
            Question.BodyBean.RuleBean resultBean = new Question.BodyBean.RuleBean
                    (classId,radioNum,multiNum,judgeNum,erLength,erPassMark,erScoreRadioSafety,erScoreRadioLaws
                    ,erScoreRadioMajor,erScoreMultiSafety,erScoreMultiLaws,erScoreMultiMajor,erScoreJudgeSafety
                    ,erScoreJudgeLaws,erScoreJudgeMajor);
//            Question.BodyBean.RuleBean resultBean = new Question.BodyBean.RuleBean
//                    (radioNum,multiNum,judgeNum,classId,erLength,erPassMark,erScoreRadioSafety,erScoreRadioLaws
//                            ,erScoreRadioMajor,erScoreMultiSafety,erScoreMultiLaws,erScoreMultiMajor,erScoreJudgeSafety
//                            ,erScoreJudgeLaws,erScoreJudgeMajor);
            list.add(resultBean);
        }
        return list;
    }

    public static int getTotalNum(SQLiteDatabase db,String table_name){
        int count = 0;
        if (db!=null){
            Cursor cursor = db.rawQuery("select * from "+table_name,null);
            count = cursor.getCount();
        }
        return count;
    }

    //当前页码数据的集合
    public static List<Question.BodyBean.ListBean> getListByCurrentPage(SQLiteDatabase db, String table_name, int currentPage, int pageSize){
        int index = (currentPage-1)*pageSize; // 获取当前页码第一条数据的下标
        Cursor cursor = null;
        if (db!=null){
            String sql = "select * from "+table_name+" limit ?,?";  // 两个参数，一个是当前页的第一个数据下标，第二个是当前页的数量
            cursor = db.rawQuery(sql,new String[]{index+"",pageSize+""});
        }
        return cursorToPerson(cursor);
    }


}
