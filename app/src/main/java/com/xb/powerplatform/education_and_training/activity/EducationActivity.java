package com.xb.powerplatform.education_and_training.activity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.xb.powerplatform.DB.Constant;
import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.education_and_training.adapter.TestNormalAdapter;
import com.xb.powerplatform.education_and_training.bean.ClassName;
import com.xb.powerplatform.education_and_training.bean.Question;
import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.presenter.ClassPresenter;
import com.xb.powerplatform.education_and_training.presenter.IPresenter;
import com.xb.powerplatform.education_and_training.presenter.impl.ClassPresenterimpl;
import com.xb.powerplatform.education_and_training.presenter.impl.Presenterimpl;
import com.xb.powerplatform.education_and_training.view.ClassView;
import com.xb.powerplatform.education_and_training.view.IView;
import com.xb.powerplatform.utilsclass.base.AlertDialogCallBack;
import com.xb.powerplatform.utilsclass.myViews.StatusBarUtils;
import com.xb.powerplatform.utilsclass.utils.AlertDialogUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xb.powerplatform.R.string.no_question;

public class EducationActivity extends AppCompatActivity implements ClassView, IView {
    //implements IView
    //教育培训
    @Bind(R.id.rellPagerView)
    RollPagerView rellPagerView;
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    ImageView btn3;
    @Bind(R.id.left)
    ImageView left;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.right)
    TextView right;
    private MyDatabaseHelper helper;
    SQLiteDatabase db;
    List<Question.BodyBean.ListBean> beanListR = new ArrayList<Question.BodyBean.ListBean>();
    List<Question.BodyBean.ListBean> beanListM = new ArrayList<Question.BodyBean.ListBean>();
    List<Question.BodyBean.ListBean> beanListJ = new ArrayList<Question.BodyBean.ListBean>();
    List<Question.BodyBean.ListBean> beanList = new ArrayList<Question.BodyBean.ListBean>();
    List<ClassName> classNamesbeanList = new ArrayList<ClassName>();
    List<ClassName> dwoClassNamesbeanList = new ArrayList<ClassName>();

    IPresenter presenter;
    Intent intent;

    List<String> listName = new ArrayList<>();
    List<String> listId = new ArrayList<>();
    List<String> listType = new ArrayList<>();

    List<String> listNamed = new ArrayList<>();
    List<String> listIdd = new ArrayList<>();

    List<Question.BodyBean.RuleBean> listrule = new ArrayList<>();
    List<Question.BodyBean.RuleBean> listRb = new ArrayList<>();
    SharedPreferencesHelper preference;
    private String classId;
    String classId1;
    int erLength;
    private AlertDialogUtil alertDialogUtil;

    ClassPresenter classPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        ButterKnife.bind(this);
        new StatusBarUtils().setWindowStatusBarColor(EducationActivity.this, R.color.color_bg_selected);

        classPresenter = new ClassPresenterimpl(this, this);

        helper = DbManager.getInstance(EducationActivity.this);
        db = helper.getReadableDatabase();

        left.setVisibility(View.VISIBLE);
        title.setText(getResources().getString(R.string.education_and_training));
        right.setText(getResources().getString(R.string.downlod));

        preference = new SharedPreferencesHelper(this, "login");
        //设置播放时间间隔
        rellPagerView.setPlayDelay(3000);
        //设置透明度
        rellPagerView.setAnimationDurtion(500);
        //设置适配器
        rellPagerView.setAdapter(new TestNormalAdapter());

        presenter = new Presenterimpl(this, this);

        getDwoClassNameData();
        if (listNamed.size() != 0) {
            title.setText(listNamed.get(0));
            classId = listIdd.get(0);
        }
    }

    //查询数据库获得试题
    private void getData() {
        beanListR.clear();
        beanListM.clear();
        beanListJ.clear();
        beanList.clear();
        Cursor cursor;
        String sql1 = "select * from rule where classid='" + classId + "'";
        cursor = DbManager.queryBySQL(db, sql1, null);
        listrule = DbManager.cursorTorule(cursor);
        if (listrule.size() == 0) {
            alertDialogUtil = new AlertDialogUtil(this);
            alertDialogUtil.showSmallDialog(getResources().getString(R.string.first_download));
        } else {
            int raNum = listrule.get(0).getRadioNum();
            int muNum = listrule.get(0).getMultiNum();
            int juNum = listrule.get(0).getJudgeNum();

            String sqlR = "select * from moni where classid='" + classId + "' and quType='0' order by random() limit '" + raNum + "'";// order by random() limit 100
            cursor = DbManager.queryBySQL(db, sqlR, null);
            beanListR = DbManager.cursorToPerson(cursor);

            String sqlM = "select * from moni where classid='" + classId + "' and quType='1' order by random() limit '" + muNum + "'";// order by random() limit 100
            cursor = DbManager.queryBySQL(db, sqlM, null);
            beanListM = DbManager.cursorToPerson(cursor);

            String sqlJ = "select * from moni where classid='" + classId + "' and quType='2' order by random() limit '" + juNum + "'";// order by random() limit 100
            cursor = DbManager.queryBySQL(db, sqlJ, null);
            beanListJ = DbManager.cursorToPerson(cursor);

            for (int i = 0; i < beanListR.size(); i++) {
                beanList.add(beanListR.get(i));
            }
            for (int i = 0; i < beanListM.size(); i++) {
                beanList.add(beanListM.get(i));
            }
            for (int i = 0; i < beanListJ.size(); i++) {
                beanList.add(beanListJ.get(i));
            }
        }
        String sqlerLength = "select * from rule where classid='" + classId + "'";
        cursor = DbManager.queryBySQL(db, sqlerLength, null);
        listRb = DbManager.cursorTorule(cursor);
        if (listRb.size() == 0) {
//            alertDialogUtil= new AlertDialogUtil(this);
//            alertDialogUtil.showSmallDialog(getResources().getString(R.string.first_download));
        } else {
            erLength = listRb.get(0).getErLength();
        }
    }


    //获取已经下载的班级
    private void getDwoClassNameData() {
        listIdd.clear();
        listNamed.clear();
        Cursor cursor;
        String sql = "select * from dwoClassName";
        cursor = DbManager.queryBySQL(db, sql, null);
        dwoClassNamesbeanList = DbManager.cursorToClassName(cursor);
        for (int i = 0; i < dwoClassNamesbeanList.size(); i++) {
            String className = dwoClassNamesbeanList.get(i).getClassName();
            listNamed.add(className);
            String classId = dwoClassNamesbeanList.get(i).getClassId();
            listIdd.add(classId);
        }
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.left, R.id.title, R.id.right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                getData();
                if (beanList.size() != 0) {
                    intent = new Intent(EducationActivity.this, EducationMoNiActivity.class);
                    intent.putExtra("classId", classId);
                    intent.putExtra("erLength", String.valueOf(erLength));
                    intent.putExtra("list", (Serializable) beanList);
                    startActivity(intent);
                } else {
                    alertDialogUtil= new AlertDialogUtil(this);
                    alertDialogUtil.showSmallDialog(getResources().getString(R.string.first_download));
                }
                break;
            case R.id.btn2:
                getData();
                if (beanList.size() != 0) {
                    intent = new Intent(EducationActivity.this, EducationZaiXianActivity.class);
                    intent.putExtra("classId", classId);
                    startActivity(intent);
                } else {
                    alertDialogUtil= new AlertDialogUtil(this);
                    alertDialogUtil.showSmallDialog(getResources().getString(R.string.first_download));
                }
                break;
            case R.id.btn3:
                classId1 = preference.getData(this, "classId", "");
                if (!classId1.equals("")) {
                    new AlertDialogUtil(this).showDialog("是否开启考试", new AlertDialogCallBack() {
                        @Override
                        public void confirm() {
                            intent = new Intent(EducationActivity.this, RegularAssessActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void cancel() {
                        }
                    });

                } else {
                    alertDialogUtil = new AlertDialogUtil(this);
                    alertDialogUtil.showSmallDialog(getResources().getString(no_question));
                }
                break;
            case R.id.left:
                finish();
                break;
            case R.id.title:
                getDwoClassNameData();
                if (listNamed.size() == 0) {
                    alertDialogUtil = new AlertDialogUtil(this);
                    alertDialogUtil.showSmallDialog(getResources().getString(R.string.first_download));
                } else {
                    final String[] arrName = (String[]) listNamed.toArray(new String[listNamed.size()]);
                    final String[] arrId = (String[]) listIdd.toArray(new String[listIdd.size()]);
                    new AlertDialog.Builder(EducationActivity.this)
                            .setTitle(getResources().getString(R.string.pelease_select))
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setSingleChoiceItems(arrName,
                                    0, new DialogInterface.OnClickListener() {

                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            dialog.dismiss();
                                            title.setText(arrName[which]);
                                            classId = arrId[which];
                                        }
                                    }).show();
                }
                break;
            case R.id.right:
                classPresenter.getPresenteerData(preference.getData(this, "cred", ""));
                break;
        }
    }

    @Override
    public void getViewData(Question assess) {
        int num = assess.getBody().getList().size();
        if (num != 0) {
            for (int i = 0; i < assess.getBody().getList().size(); i++) {
                String ID = assess.getBody().getList().get(i).getId();
                String quContent = assess.getBody().getList().get(i).getQuContent();//题目
                String quAnalyze = assess.getBody().getList().get(i).getQuAnalyze();//题目解析
                String quAnswer = assess.getBody().getList().get(i).getQuAnswer();//答案
                String quA = assess.getBody().getList().get(i).getQuA();
                String quB = assess.getBody().getList().get(i).getQuB();
                String quC = assess.getBody().getList().get(i).getQuC();
                String quD = assess.getBody().getList().get(i).getQuD();
                String quE = assess.getBody().getList().get(i).getQuE();
                String quF = assess.getBody().getList().get(i).getQuF();
                String quCategory = assess.getBody().getList().get(i).getQuCategory();
                String quType = assess.getBody().getList().get(i).getQuType();//类型 0单选 1多选 2判断
                ContentValues values = new ContentValues();
                values.put(Constant.ID, ID);
                values.put(Constant.QUTYPE, quType);
                values.put(Constant.QUCONTENT, quContent);
                values.put(Constant.QUA, quA);
                values.put(Constant.QUB, quB);
                values.put(Constant.QUC, quC);
                values.put(Constant.QUD, quD);
                values.put(Constant.QUE, quE);
                values.put(Constant.QUF, quF);
                values.put(Constant.QUANSWER, quAnswer);
                values.put(Constant.QUANALYZE, quAnalyze);
                values.put(Constant.QUCATEGORY, quCategory);
                values.put(Constant.CLASSID, classId);
                db.insert(Constant.TABBLE_NAME, null, values);
                values.clear();
            }
            Toast.makeText(this, getResources().getString(R.string.download_ok), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getResources().getString(no_question), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    @Override
    public void getClassViewData(assess assess) {
        listName.clear();
        listId.clear();
        listType.clear();
        if (assess.getBody().getBmList().size() != 0) {
            classId = assess.getBody().getExamClass().getClassId();
            if (classId != null) {
                preference.saveData(this, "classId", classId);
            }
            List<assess.BodyBean.BmListBean> list = new ArrayList<>();
            list = assess.getBody().getBmList();
            ContentValues values = new ContentValues();
            for (int k = 0; k < list.size(); k++) {
                listName.add(list.get(k).getClassName());
                listId.add(list.get(k).getClassId());
                listType.add(list.get(k).getClassType());
                int erScoreRadioSafety = assess.getBody().getBmList().get(k).getExamRule().getErScoreRadioSafety();//安全知识单选分值
                int erScoreRadioLaws = assess.getBody().getBmList().get(k).getExamRule().getErScoreRadioLaws();//法律法规单选分数
                int erScoreRadioMajor = assess.getBody().getBmList().get(k).getExamRule().getErScoreRadioMajor();//专业知识单选分数
                int erScoreMultiSafety = assess.getBody().getBmList().get(k).getExamRule().getErScoreMultiSafety();//多选安全知识分值
                int erScoreMultiLaws = assess.getBody().getBmList().get(k).getExamRule().getErScoreMultiLaws();//多选法律法规分数
                int erScoreMultiMajor = assess.getBody().getBmList().get(k).getExamRule().getErScoreMultiMajor();//多选专业知识分数
                int erScoreJudgeSafety = assess.getBody().getBmList().get(k).getExamRule().getErScoreJudgeSafety();//判断安全知识分值
                int erScoreJudgeLaws = assess.getBody().getBmList().get(k).getExamRule().getErScoreJudgeLaws();//判断法律法规分数
                int erScoreJudgeMajor = assess.getBody().getBmList().get(k).getExamRule().getErScoreJudgeMajor();//判断专业知识分数
                String classId = assess.getBody().getBmList().get(k).getClassId();

                int radioNum = assess.getBody().getBmList().get(k).getExamRule().getRadioNum();
                int multiNum = assess.getBody().getBmList().get(k).getExamRule().getMultiNum();
                int judgeNum = assess.getBody().getBmList().get(k).getExamRule().getJudgeNum();
                int erLength = assess.getBody().getBmList().get(k).getExamRule().getErLength();
                int erPassMark = assess.getBody().getBmList().get(k).getExamRule().getErPassMark();//及格分数
                values.put(Constant.CLASSID, classId);
                values.put(Constant.RADIONUM, radioNum);
                values.put(Constant.MULTINUM, multiNum);
                values.put(Constant.JUDGENUM, judgeNum);
                values.put(Constant.ERLENGTH, erLength);
                values.put(Constant.ERPASSMARK, erPassMark);

                values.put(Constant.ERSCORERADIOSAFETY, erScoreRadioSafety);
                values.put(Constant.ERSCORERADIOLAWS, erScoreRadioLaws);
                values.put(Constant.ERSCORERADIOMAJOR, erScoreRadioMajor);
                values.put(Constant.ERSCOREMULTISAFETY, erScoreMultiSafety);
                values.put(Constant.ERSCOREMULTILAWS, erScoreMultiLaws);
                values.put(Constant.ERSCOREMULTIMAJOR, erScoreMultiMajor);
                values.put(Constant.ERSCOREJUDGESAFETY, erScoreJudgeSafety);
                values.put(Constant.ERSCOREJUDGELAWS, erScoreJudgeLaws);
                values.put(Constant.ERSCOREJUDGEMAJOR, erScoreJudgeMajor);

                db.insert(Constant.TABBLE_NAME_RULE, null, values);
                values.clear();
            }
            //list转数组
            final String[] arrName = (String[]) listName.toArray(new String[listName.size()]);
            final String[] arrId = (String[]) listId.toArray(new String[listId.size()]);
            final String[] arrType = (String[]) listType.toArray(new String[listType.size()]);
            if (listName.size() == 0) {
                alertDialogUtil = new AlertDialogUtil(this);
                alertDialogUtil.showSmallDialog(getResources().getString(no_question));
            } else {
                //dialog
                new AlertDialog.Builder(this)
                        .setTitle(getResources().getString(R.string.pelease_select))
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setSingleChoiceItems(arrName,
                                0, new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        dialog.dismiss();
                                        getDwoClassNameData();
                                        if (listNamed.contains(arrName[which])) {
                                            alertDialogUtil = new AlertDialogUtil(EducationActivity.this);
                                            alertDialogUtil.showSmallDialog(getResources().getString(R.string.download_old));
                                            title.setText(arrName[which]);
                                            classId = arrId[which];
                                        } else {
                                            if (!"0".equals(arrType[which])){
                                                new AlertDialogUtil(EducationActivity.this).showSmallDialog("手机不支持循环考试和闯关竞赛");
                                            }else {
                                                classId = arrId[which];
                                                String dwoStatic = "Yes";
                                                ContentValues values = new ContentValues();
                                                values.put(Constant.CLASSID, arrId[which]);
                                                values.put(Constant.CLASSNAME, arrName[which]);
                                                values.put(Constant.DWOSTATIC, dwoStatic);
                                                title.setText(arrName[which]);
                                                classId = arrId[which];
                                                db.insert(Constant.TABBLE_DOW_CLASS_NAME, null, values);
                                                values.clear();
                                                //下载试题
                                                presenter.getPresenteerData(arrId[which]);
                                            }
                                        }
                                    }
                                }).show();
            }
        } else {
            new AlertDialogUtil(this).showSmallDialog(getResources().getString(R.string.no_assess));
        }

    }
}