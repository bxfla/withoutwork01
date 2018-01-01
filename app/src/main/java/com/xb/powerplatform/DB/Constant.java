package com.xb.powerplatform.DB;

/**
 * Created by shang on 2017/6/29.
 */

public class Constant {

    //试题库
    public static final String DATABASE_NAME = "assess.db";
    public static final int DATA_VERSION = 1;
    public static final String TABBLE_NAME = "moni";
    public static final String ID = "id";
    public static final String  QUTYPE = "quType";//试题类型
    public static final String QUCONTENT = "quContent";//试题描述
    public static final String QUA = "quA";//试题A
    public static final String QUB = "quB";//试题B
    public static final String QUC = "quC";//试题C
    public static final String QUD = "quD";//试题D
    public static final String QUE = "quE";//试题E
    public static final String QUF = "quF";//试题F
    public static final String QUANSWER = "quAnswer";//答案
    public static final String QUANALYZE = "quAnalyze";//解析
    public static final String QUCATEGORY = "quCategory";//试题分类
    public static final String MAJORID = "majorId";//专业ID
    public static final String CLASSID = "classid";//班级ID

    //考试规则
    public static final String TABBLE_NAME_RULE = "rule";
    public static final String RADIONUM="radioNum";//单选题数目数
    public static final String MULTINUM="multiNum";//多选题目数
    public static final String JUDGENUM="judgeNum";//判断题目数

    public static final String ERRADIONUMSAFETY="erRadioNumSafety";//安全知识单选个数
    public static final String ERRADIONUMLAWS="erRadioNumLaws";//法律法规单选个数
    public static final String ERRADIONUMMAJOR="erRadioNumMajor";//专业知识单选个数
    public static final String ERMULTINUMSAFETY="erMultiNumSafety";//多选个数
    public static final String ERMULTINUMLAWS="erMultiNumLaws";
    public static final String ERMULTINUMMAJOR="erMultiNumMajor";
    public static final String ERJUDGENUMSAFETY="erJudgeNumSafety";//判断个数
    public static final String ERJUDGENUMLAWS="erJudgeNumLaws";
    public static final String ERJUDGENUMMAJOR="erJudgeNumMajor";
    public static final String ERSCORERADIOSAFETY="erScoreRadioSafety";//安全知识单选分数
    public static final String ERSCORERADIOLAWS="erScoreRadioLaws";
    public static final String ERSCORERADIOMAJOR="erScoreRadioMajor";
    public static final String ERSCOREMULTISAFETY="erScoreMultiSafety";
    public static final String ERSCOREMULTILAWS="erScoreMultiLaws";
    public static final String ERSCOREMULTIMAJOR="erScoreMultiMajor";
    public static final String ERSCOREJUDGESAFETY="erScoreJudgeSafety";
    public static final String ERSCOREJUDGELAWS="erScoreJudgeLaws";
    public static final String ERSCOREJUDGEMAJOR="erScoreJudgeMajor";
    public static final String ERPASSMARK="erPassMark";//及格分数
    public static final String ERLENGTH="erLength";//时长

    //考试题库表
    public static final String TABBLE_NAME_ERROR = "error";

    //报考班级表
    public static final String TABBLE_CLASS_NAME = "className";
    public static final String CLASSNAME = "className";//班级ID
    public static final String DWOSTATIC = "static";//是否下载

    //下载报考班级表
    public static final String TABBLE_DOW_CLASS_NAME = "dwoClassName";


}
