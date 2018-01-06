package com.xb.powerplatform.education_and_training.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xb.powerplatform.DB.Constant;
import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.education_and_training.bean.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/1/5.
 */

public class AddErrorList {
    List<Question.BodyBean.ListBean> dataItems = new ArrayList<>();
    List<Question.BodyBean.ListBean> beanListE = new ArrayList<Question.BodyBean.ListBean>();
    MyDatabaseHelper errorHelper;
    SQLiteDatabase db;
    int position;
    Context context;
    List<String> list=new ArrayList<>();

    public AddErrorList(SQLiteDatabase db, MyDatabaseHelper errorHelper, List<Question.BodyBean.ListBean> beanListE,
                        List<Question.BodyBean.ListBean> dataItems, int position, Context contextObject) {
        this.errorHelper = errorHelper;
        this.db = db;
        this.dataItems = dataItems;
        this.beanListE = beanListE;
        this.position = position;
        this.context = contextObject;
    }

    public void AddErrorList() {
        String sql = "select * from error";
        Cursor cursor = DbManager.queryBySQL(db, sql, null);
        beanListE = DbManager.cursorToPerson(cursor);
        if (beanListE.size()==0){
            addErrorDb(position);
        }else {
            for (int i=0;i<beanListE.size();i++){
                list.add(beanListE.get(i).getQuContent());
            }
            if (list.indexOf(dataItems.get(position).getQuContent())==-1){
                addErrorDb(position);
            }
        }
    }

    //想错题表中添加数据
    private void addErrorDb(int mPosition1) {
//        errorHelper = DbManager.getInstance(context);
//        db = errorHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constant.ID, dataItems.get(mPosition1).getId());
        values.put(Constant.QUTYPE, dataItems.get(mPosition1).getQuType());
        values.put(Constant.QUCONTENT, dataItems.get(mPosition1).getQuContent());
        values.put(Constant.QUA, dataItems.get(mPosition1).getQuA());
        values.put(Constant.QUB, dataItems.get(mPosition1).getQuB());
        values.put(Constant.QUC, dataItems.get(mPosition1).getQuC());
        values.put(Constant.QUD, dataItems.get(mPosition1).getQuD());
        values.put(Constant.QUE, dataItems.get(mPosition1).getQuE());
        values.put(Constant.QUF, dataItems.get(mPosition1).getQuF());
        values.put(Constant.QUANSWER, dataItems.get(mPosition1).getQuAnswer());
        values.put(Constant.QUANALYZE, dataItems.get(mPosition1).getQuAnalyze());
        values.put(Constant.CLASSID, dataItems.get(mPosition1).getClasssId());
        values.put(Constant.CLASSID, dataItems.get(mPosition1).getQuCategory());
        db.insert(Constant.TABBLE_NAME_ERROR, null, values);
    }
}
