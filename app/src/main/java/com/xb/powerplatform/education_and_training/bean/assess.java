package com.xb.powerplatform.education_and_training.bean;

import java.io.Serializable;
import java.util.List;

public class assess implements Serializable {
    /**
     * success : true
     * errorCode : -1
     * msg : 获取数据成功！
     * body : {"bmList":[{"classId":"9466e2cddf5f4d7885244e031b9eb79a","examRule":{"id":"0093f8e63e844a909ca8e699384fa09c","isNewRecord":false,"remarks":null,"createDate":"2018-02-02 01:12:18","updateDate":"2018-02-02 01:12:18","name":"普通考试规则","erLength":10,"erPassMark":60,"erRepeatExamCount":1,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":0,"erScoreMajor":100,"erRadioNumSafety":0,"erRadioNumLaws":0,"erRadioNumMajor":10,"erMultiNumSafety":0,"erMultiNumLaws":0,"erMultiNumMajor":10,"erJudgeNumSafety":0,"erJudgeNumLaws":0,"erJudgeNumMajor":30,"erScoreRadioSafety":0,"erScoreRadioLaws":0,"erScoreRadioMajor":2,"erScoreMultiSafety":0,"erScoreMultiLaws":0,"erScoreMultiMajor":2,"erScoreJudgeSafety":0,"erScoreJudgeLaws":0,"erScoreJudgeMajor":2,"flag":null,"passCount":1,"ruleType":"0","radioNum":10,"multiNum":10,"judgeNum":30,"loopexamRule":null},"crednumber":"370828199310201356","className":"2018年2月2日普通班级 安全管理人员（矿处级） 第1期"},{"classId":"a15959d849be427396efd8f7c0096cbf","examRule":{"id":"44a4c29edf2448bd9dc7331ceecb6c00","isNewRecord":false,"remarks":null,"createDate":"2018-02-02 01:49:41","updateDate":"2018-02-02 01:49:41","name":"循环考试规则","erLength":5,"erPassMark":20,"erRepeatExamCount":0,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":0,"erScoreMajor":100,"erRadioNumSafety":0,"erRadioNumLaws":0,"erRadioNumMajor":10,"erMultiNumSafety":0,"erMultiNumLaws":0,"erMultiNumMajor":10,"erJudgeNumSafety":0,"erJudgeNumLaws":0,"erJudgeNumMajor":30,"erScoreRadioSafety":0,"erScoreRadioLaws":0,"erScoreRadioMajor":2,"erScoreMultiSafety":0,"erScoreMultiLaws":0,"erScoreMultiMajor":2,"erScoreJudgeSafety":0,"erScoreJudgeLaws":0,"erScoreJudgeMajor":2,"flag":null,"passCount":1,"ruleType":"2","radioNum":10,"multiNum":10,"judgeNum":30,"loopexamRule":{"id":"ba2cf4cc8e964d039995a5a9e7770302","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"examCycle":"2018-02-02至2018-03-28","examNode":"2018-2-2至2018-2-13,2018-2-20至2018-2-23,2018-2-28至2018-3-9,2018-3-20至2018-3-27","examCount":"4","classId":null,"examCycleStart":"2018-02-02","examCycleEnd":"2018-03-28"}},"crednumber":"370828199310201356","className":"2018年2月2日循环考试 循环考试 第2期"}],"examClass":{"classId":"9466e2cddf5f4d7885244e031b9eb79a","className":"2018年2月2日普通班级 安全管理人员（矿处级） 第1期"}}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyBean body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * bmList : [{"classId":"9466e2cddf5f4d7885244e031b9eb79a","examRule":{"id":"0093f8e63e844a909ca8e699384fa09c","isNewRecord":false,"remarks":null,"createDate":"2018-02-02 01:12:18","updateDate":"2018-02-02 01:12:18","name":"普通考试规则","erLength":10,"erPassMark":60,"erRepeatExamCount":1,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":0,"erScoreMajor":100,"erRadioNumSafety":0,"erRadioNumLaws":0,"erRadioNumMajor":10,"erMultiNumSafety":0,"erMultiNumLaws":0,"erMultiNumMajor":10,"erJudgeNumSafety":0,"erJudgeNumLaws":0,"erJudgeNumMajor":30,"erScoreRadioSafety":0,"erScoreRadioLaws":0,"erScoreRadioMajor":2,"erScoreMultiSafety":0,"erScoreMultiLaws":0,"erScoreMultiMajor":2,"erScoreJudgeSafety":0,"erScoreJudgeLaws":0,"erScoreJudgeMajor":2,"flag":null,"passCount":1,"ruleType":"0","radioNum":10,"multiNum":10,"judgeNum":30,"loopexamRule":null},"crednumber":"370828199310201356","className":"2018年2月2日普通班级 安全管理人员（矿处级） 第1期"},{"classId":"a15959d849be427396efd8f7c0096cbf","examRule":{"id":"44a4c29edf2448bd9dc7331ceecb6c00","isNewRecord":false,"remarks":null,"createDate":"2018-02-02 01:49:41","updateDate":"2018-02-02 01:49:41","name":"循环考试规则","erLength":5,"erPassMark":20,"erRepeatExamCount":0,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":0,"erScoreMajor":100,"erRadioNumSafety":0,"erRadioNumLaws":0,"erRadioNumMajor":10,"erMultiNumSafety":0,"erMultiNumLaws":0,"erMultiNumMajor":10,"erJudgeNumSafety":0,"erJudgeNumLaws":0,"erJudgeNumMajor":30,"erScoreRadioSafety":0,"erScoreRadioLaws":0,"erScoreRadioMajor":2,"erScoreMultiSafety":0,"erScoreMultiLaws":0,"erScoreMultiMajor":2,"erScoreJudgeSafety":0,"erScoreJudgeLaws":0,"erScoreJudgeMajor":2,"flag":null,"passCount":1,"ruleType":"2","radioNum":10,"multiNum":10,"judgeNum":30,"loopexamRule":{"id":"ba2cf4cc8e964d039995a5a9e7770302","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"examCycle":"2018-02-02至2018-03-28","examNode":"2018-2-2至2018-2-13,2018-2-20至2018-2-23,2018-2-28至2018-3-9,2018-3-20至2018-3-27","examCount":"4","classId":null,"examCycleStart":"2018-02-02","examCycleEnd":"2018-03-28"}},"crednumber":"370828199310201356","className":"2018年2月2日循环考试 循环考试 第2期"}]
         * examClass : {"classId":"9466e2cddf5f4d7885244e031b9eb79a","className":"2018年2月2日普通班级 安全管理人员（矿处级） 第1期"}
         */

        private ExamClassBean examClass;
        private List<BmListBean> bmList;

        public ExamClassBean getExamClass() {
            return examClass;
        }

        public void setExamClass(ExamClassBean examClass) {
            this.examClass = examClass;
        }

        public List<BmListBean> getBmList() {
            return bmList;
        }

        public void setBmList(List<BmListBean> bmList) {
            this.bmList = bmList;
        }

        public static class ExamClassBean {
            /**
             * classId : 9466e2cddf5f4d7885244e031b9eb79a
             * className : 2018年2月2日普通班级 安全管理人员（矿处级） 第1期
             */

            private String classId;
            private String className;

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }
        }

        public static class BmListBean {
            /**
             * classId : 9466e2cddf5f4d7885244e031b9eb79a
             * examRule : {"id":"0093f8e63e844a909ca8e699384fa09c","isNewRecord":false,"remarks":null,"createDate":"2018-02-02 01:12:18","updateDate":"2018-02-02 01:12:18","name":"普通考试规则","erLength":10,"erPassMark":60,"erRepeatExamCount":1,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":0,"erScoreMajor":100,"erRadioNumSafety":0,"erRadioNumLaws":0,"erRadioNumMajor":10,"erMultiNumSafety":0,"erMultiNumLaws":0,"erMultiNumMajor":10,"erJudgeNumSafety":0,"erJudgeNumLaws":0,"erJudgeNumMajor":30,"erScoreRadioSafety":0,"erScoreRadioLaws":0,"erScoreRadioMajor":2,"erScoreMultiSafety":0,"erScoreMultiLaws":0,"erScoreMultiMajor":2,"erScoreJudgeSafety":0,"erScoreJudgeLaws":0,"erScoreJudgeMajor":2,"flag":null,"passCount":1,"ruleType":"0","radioNum":10,"multiNum":10,"judgeNum":30,"loopexamRule":null}
             * crednumber : 370828199310201356
             * className : 2018年2月2日普通班级 安全管理人员（矿处级） 第1期
             */

            private String classId;
            private ExamRuleBean examRule;
            private String crednumber;
            private String className;
            private String classType;

            public String getClassType() {
                return classType;
            }

            public void setClassType(String classType) {
                this.classType = classType;
            }

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public ExamRuleBean getExamRule() {
                return examRule;
            }

            public void setExamRule(ExamRuleBean examRule) {
                this.examRule = examRule;
            }

            public String getCrednumber() {
                return crednumber;
            }

            public void setCrednumber(String crednumber) {
                this.crednumber = crednumber;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public static class ExamRuleBean {
                /**
                 * id : 0093f8e63e844a909ca8e699384fa09c
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-02-02 01:12:18
                 * updateDate : 2018-02-02 01:12:18
                 * name : 普通考试规则
                 * erLength : 10
                 * erPassMark : 60
                 * erRepeatExamCount : 1
                 * erTotalScore : 100
                 * erScoreSafety : 0
                 * erScoreLaws : 0
                 * erScoreMajor : 100
                 * erRadioNumSafety : 0
                 * erRadioNumLaws : 0
                 * erRadioNumMajor : 10
                 * erMultiNumSafety : 0
                 * erMultiNumLaws : 0
                 * erMultiNumMajor : 10
                 * erJudgeNumSafety : 0
                 * erJudgeNumLaws : 0
                 * erJudgeNumMajor : 30
                 * erScoreRadioSafety : 0
                 * erScoreRadioLaws : 0
                 * erScoreRadioMajor : 2
                 * erScoreMultiSafety : 0
                 * erScoreMultiLaws : 0
                 * erScoreMultiMajor : 2
                 * erScoreJudgeSafety : 0
                 * erScoreJudgeLaws : 0
                 * erScoreJudgeMajor : 2
                 * flag : null
                 * passCount : 1
                 * ruleType : 0
                 * radioNum : 10
                 * multiNum : 10
                 * judgeNum : 30
                 * loopexamRule : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String name;
                private int erLength;
                private int erPassMark;
                private int erRepeatExamCount;
                private int erTotalScore;
                private int erScoreSafety;
                private int erScoreLaws;
                private int erScoreMajor;
                private int erRadioNumSafety;
                private int erRadioNumLaws;
                private int erRadioNumMajor;
                private int erMultiNumSafety;
                private int erMultiNumLaws;
                private int erMultiNumMajor;
                private int erJudgeNumSafety;
                private int erJudgeNumLaws;
                private int erJudgeNumMajor;
                private int erScoreRadioSafety;
                private int erScoreRadioLaws;
                private int erScoreRadioMajor;
                private int erScoreMultiSafety;
                private int erScoreMultiLaws;
                private int erScoreMultiMajor;
                private int erScoreJudgeSafety;
                private int erScoreJudgeLaws;
                private int erScoreJudgeMajor;
                private Object flag;
                private int passCount;
                private String ruleType;
                private int radioNum;
                private int multiNum;
                private int judgeNum;
                private Object loopexamRule;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public Object getRemarks() {
                    return remarks;
                }

                public void setRemarks(Object remarks) {
                    this.remarks = remarks;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate) {
                    this.updateDate = updateDate;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getErLength() {
                    return erLength;
                }

                public void setErLength(int erLength) {
                    this.erLength = erLength;
                }

                public int getErPassMark() {
                    return erPassMark;
                }

                public void setErPassMark(int erPassMark) {
                    this.erPassMark = erPassMark;
                }

                public int getErRepeatExamCount() {
                    return erRepeatExamCount;
                }

                public void setErRepeatExamCount(int erRepeatExamCount) {
                    this.erRepeatExamCount = erRepeatExamCount;
                }

                public int getErTotalScore() {
                    return erTotalScore;
                }

                public void setErTotalScore(int erTotalScore) {
                    this.erTotalScore = erTotalScore;
                }

                public int getErScoreSafety() {
                    return erScoreSafety;
                }

                public void setErScoreSafety(int erScoreSafety) {
                    this.erScoreSafety = erScoreSafety;
                }

                public int getErScoreLaws() {
                    return erScoreLaws;
                }

                public void setErScoreLaws(int erScoreLaws) {
                    this.erScoreLaws = erScoreLaws;
                }

                public int getErScoreMajor() {
                    return erScoreMajor;
                }

                public void setErScoreMajor(int erScoreMajor) {
                    this.erScoreMajor = erScoreMajor;
                }

                public int getErRadioNumSafety() {
                    return erRadioNumSafety;
                }

                public void setErRadioNumSafety(int erRadioNumSafety) {
                    this.erRadioNumSafety = erRadioNumSafety;
                }

                public int getErRadioNumLaws() {
                    return erRadioNumLaws;
                }

                public void setErRadioNumLaws(int erRadioNumLaws) {
                    this.erRadioNumLaws = erRadioNumLaws;
                }

                public int getErRadioNumMajor() {
                    return erRadioNumMajor;
                }

                public void setErRadioNumMajor(int erRadioNumMajor) {
                    this.erRadioNumMajor = erRadioNumMajor;
                }

                public int getErMultiNumSafety() {
                    return erMultiNumSafety;
                }

                public void setErMultiNumSafety(int erMultiNumSafety) {
                    this.erMultiNumSafety = erMultiNumSafety;
                }

                public int getErMultiNumLaws() {
                    return erMultiNumLaws;
                }

                public void setErMultiNumLaws(int erMultiNumLaws) {
                    this.erMultiNumLaws = erMultiNumLaws;
                }

                public int getErMultiNumMajor() {
                    return erMultiNumMajor;
                }

                public void setErMultiNumMajor(int erMultiNumMajor) {
                    this.erMultiNumMajor = erMultiNumMajor;
                }

                public int getErJudgeNumSafety() {
                    return erJudgeNumSafety;
                }

                public void setErJudgeNumSafety(int erJudgeNumSafety) {
                    this.erJudgeNumSafety = erJudgeNumSafety;
                }

                public int getErJudgeNumLaws() {
                    return erJudgeNumLaws;
                }

                public void setErJudgeNumLaws(int erJudgeNumLaws) {
                    this.erJudgeNumLaws = erJudgeNumLaws;
                }

                public int getErJudgeNumMajor() {
                    return erJudgeNumMajor;
                }

                public void setErJudgeNumMajor(int erJudgeNumMajor) {
                    this.erJudgeNumMajor = erJudgeNumMajor;
                }

                public int getErScoreRadioSafety() {
                    return erScoreRadioSafety;
                }

                public void setErScoreRadioSafety(int erScoreRadioSafety) {
                    this.erScoreRadioSafety = erScoreRadioSafety;
                }

                public int getErScoreRadioLaws() {
                    return erScoreRadioLaws;
                }

                public void setErScoreRadioLaws(int erScoreRadioLaws) {
                    this.erScoreRadioLaws = erScoreRadioLaws;
                }

                public int getErScoreRadioMajor() {
                    return erScoreRadioMajor;
                }

                public void setErScoreRadioMajor(int erScoreRadioMajor) {
                    this.erScoreRadioMajor = erScoreRadioMajor;
                }

                public int getErScoreMultiSafety() {
                    return erScoreMultiSafety;
                }

                public void setErScoreMultiSafety(int erScoreMultiSafety) {
                    this.erScoreMultiSafety = erScoreMultiSafety;
                }

                public int getErScoreMultiLaws() {
                    return erScoreMultiLaws;
                }

                public void setErScoreMultiLaws(int erScoreMultiLaws) {
                    this.erScoreMultiLaws = erScoreMultiLaws;
                }

                public int getErScoreMultiMajor() {
                    return erScoreMultiMajor;
                }

                public void setErScoreMultiMajor(int erScoreMultiMajor) {
                    this.erScoreMultiMajor = erScoreMultiMajor;
                }

                public int getErScoreJudgeSafety() {
                    return erScoreJudgeSafety;
                }

                public void setErScoreJudgeSafety(int erScoreJudgeSafety) {
                    this.erScoreJudgeSafety = erScoreJudgeSafety;
                }

                public int getErScoreJudgeLaws() {
                    return erScoreJudgeLaws;
                }

                public void setErScoreJudgeLaws(int erScoreJudgeLaws) {
                    this.erScoreJudgeLaws = erScoreJudgeLaws;
                }

                public int getErScoreJudgeMajor() {
                    return erScoreJudgeMajor;
                }

                public void setErScoreJudgeMajor(int erScoreJudgeMajor) {
                    this.erScoreJudgeMajor = erScoreJudgeMajor;
                }

                public Object getFlag() {
                    return flag;
                }

                public void setFlag(Object flag) {
                    this.flag = flag;
                }

                public int getPassCount() {
                    return passCount;
                }

                public void setPassCount(int passCount) {
                    this.passCount = passCount;
                }

                public String getRuleType() {
                    return ruleType;
                }

                public void setRuleType(String ruleType) {
                    this.ruleType = ruleType;
                }

                public int getRadioNum() {
                    return radioNum;
                }

                public void setRadioNum(int radioNum) {
                    this.radioNum = radioNum;
                }

                public int getMultiNum() {
                    return multiNum;
                }

                public void setMultiNum(int multiNum) {
                    this.multiNum = multiNum;
                }

                public int getJudgeNum() {
                    return judgeNum;
                }

                public void setJudgeNum(int judgeNum) {
                    this.judgeNum = judgeNum;
                }

                public Object getLoopexamRule() {
                    return loopexamRule;
                }

                public void setLoopexamRule(Object loopexamRule) {
                    this.loopexamRule = loopexamRule;
                }
            }
        }
    }
//
//
//    /**
//     * success : true
//     * errorCode : -1
//     * msg : 获取数据成功！
//     * body : {"bmList":[{"classId":"65ee2b26c27d4ea9b637c708076dff9b","examRule":{"id":"266a80d7c0ea4ac68dd7af4754a0528d","isNewRecord":false,"remarks":null,"createDate":"2017-12-27 05:50:05","updateDate":"2017-12-27 05:50:31","name":"班组长规则","erLength":10,"erPassMark":30,"erRepeatExamCount":2,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":100,"erScoreMajor":0,"erRadioNumSafety":0,"erRadioNumLaws":40,"erRadioNumMajor":0,"erMultiNumSafety":0,"erMultiNumLaws":20,"erMultiNumMajor":0,"erJudgeNumSafety":0,"erJudgeNumLaws":40,"erJudgeNumMajor":0,"erScoreRadioSafety":null,"erScoreRadioLaws":1,"erScoreRadioMajor":null,"erScoreMultiSafety":null,"erScoreMultiLaws":1,"erScoreMultiMajor":null,"erScoreJudgeSafety":null,"erScoreJudgeLaws":1,"erScoreJudgeMajor":null,"flag":null,"passCount":1,"ruleType":"0","radioNum":40,"multiNum":20,"judgeNum":40},"crednumber":"370828199310201356","className":"2018年1月5日普通班级 班组长 第1期"}],"examClass":{"classId":"65ee2b26c27d4ea9b637c708076dff9b","className":"2018年1月5日普通班级 班组长 第1期"}}
//     */
//
//    private boolean success;
//    private String errorCode;
//    private String msg;
//    private BodyBean body;
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public BodyBean getBody() {
//        return body;
//    }
//
//    public void setBody(BodyBean body) {
//        this.body = body;
//    }
//
//    public static class BodyBean {
//        /**
//         * bmList : [{"classId":"65ee2b26c27d4ea9b637c708076dff9b","examRule":{"id":"266a80d7c0ea4ac68dd7af4754a0528d","isNewRecord":false,"remarks":null,"createDate":"2017-12-27 05:50:05","updateDate":"2017-12-27 05:50:31","name":"班组长规则","erLength":10,"erPassMark":30,"erRepeatExamCount":2,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":100,"erScoreMajor":0,"erRadioNumSafety":0,"erRadioNumLaws":40,"erRadioNumMajor":0,"erMultiNumSafety":0,"erMultiNumLaws":20,"erMultiNumMajor":0,"erJudgeNumSafety":0,"erJudgeNumLaws":40,"erJudgeNumMajor":0,"erScoreRadioSafety":null,"erScoreRadioLaws":1,"erScoreRadioMajor":null,"erScoreMultiSafety":null,"erScoreMultiLaws":1,"erScoreMultiMajor":null,"erScoreJudgeSafety":null,"erScoreJudgeLaws":1,"erScoreJudgeMajor":null,"flag":null,"passCount":1,"ruleType":"0","radioNum":40,"multiNum":20,"judgeNum":40},"crednumber":"370828199310201356","className":"2018年1月5日普通班级 班组长 第1期"}]
//         * examClass : {"classId":"65ee2b26c27d4ea9b637c708076dff9b","className":"2018年1月5日普通班级 班组长 第1期"}
//         */
//
//        private ExamClassBean examClass;
//        private List<BmListBean> bmList;
//
//        public ExamClassBean getExamClass() {
//            return examClass;
//        }
//
//        public void setExamClass(ExamClassBean examClass) {
//            this.examClass = examClass;
//        }
//
//        public List<BmListBean> getBmList() {
//            return bmList;
//        }
//
//        public void setBmList(List<BmListBean> bmList) {
//            this.bmList = bmList;
//        }
//
//        public static class ExamClassBean {
//            /**
//             * classId : 65ee2b26c27d4ea9b637c708076dff9b
//             * className : 2018年1月5日普通班级 班组长 第1期
//             */
//
//            private String classId;
//            private String className;
//
//            public String getClassId() {
//                return classId;
//            }
//
//            public void setClassId(String classId) {
//                this.classId = classId;
//            }
//
//            public String getClassName() {
//                return className;
//            }
//
//            public void setClassName(String className) {
//                this.className = className;
//            }
//        }
//
//        public static class BmListBean {
//            /**
//             * classId : 65ee2b26c27d4ea9b637c708076dff9b
//             * examRule : {"id":"266a80d7c0ea4ac68dd7af4754a0528d","isNewRecord":false,"remarks":null,"createDate":"2017-12-27 05:50:05","updateDate":"2017-12-27 05:50:31","name":"班组长规则","erLength":10,"erPassMark":30,"erRepeatExamCount":2,"erTotalScore":100,"erScoreSafety":0,"erScoreLaws":100,"erScoreMajor":0,"erRadioNumSafety":0,"erRadioNumLaws":40,"erRadioNumMajor":0,"erMultiNumSafety":0,"erMultiNumLaws":20,"erMultiNumMajor":0,"erJudgeNumSafety":0,"erJudgeNumLaws":40,"erJudgeNumMajor":0,"erScoreRadioSafety":null,"erScoreRadioLaws":1,"erScoreRadioMajor":null,"erScoreMultiSafety":null,"erScoreMultiLaws":1,"erScoreMultiMajor":null,"erScoreJudgeSafety":null,"erScoreJudgeLaws":1,"erScoreJudgeMajor":null,"flag":null,"passCount":1,"ruleType":"0","radioNum":40,"multiNum":20,"judgeNum":40}
//             * crednumber : 370828199310201356
//             * className : 2018年1月5日普通班级 班组长 第1期
//             */
//
//            private String classId;
//            private ExamRuleBean examRule;
//            private String crednumber;
//            private String className;
//
//            public String getClassId() {
//                return classId;
//            }
//
//            public void setClassId(String classId) {
//                this.classId = classId;
//            }
//
//            public ExamRuleBean getExamRule() {
//                return examRule;
//            }
//
//            public void setExamRule(ExamRuleBean examRule) {
//                this.examRule = examRule;
//            }
//
//            public String getCrednumber() {
//                return crednumber;
//            }
//
//            public void setCrednumber(String crednumber) {
//                this.crednumber = crednumber;
//            }
//
//            public String getClassName() {
//                return className;
//            }
//
//            public void setClassName(String className) {
//                this.className = className;
//            }
//
//            public static class ExamRuleBean {
//                /**
//                 * id : 266a80d7c0ea4ac68dd7af4754a0528d
//                 * isNewRecord : false
//                 * remarks : null
//                 * createDate : 2017-12-27 05:50:05
//                 * updateDate : 2017-12-27 05:50:31
//                 * name : 班组长规则
//                 * erLength : 10
//                 * erPassMark : 30
//                 * erRepeatExamCount : 2
//                 * erTotalScore : 100
//                 * erScoreSafety : 0
//                 * erScoreLaws : 100
//                 * erScoreMajor : 0
//                 * erRadioNumSafety : 0
//                 * erRadioNumLaws : 40
//                 * erRadioNumMajor : 0
//                 * erMultiNumSafety : 0
//                 * erMultiNumLaws : 20
//                 * erMultiNumMajor : 0
//                 * erJudgeNumSafety : 0
//                 * erJudgeNumLaws : 40
//                 * erJudgeNumMajor : 0
//                 * erScoreRadioSafety : null
//                 * erScoreRadioLaws : 1
//                 * erScoreRadioMajor : null
//                 * erScoreMultiSafety : null
//                 * erScoreMultiLaws : 1
//                 * erScoreMultiMajor : null
//                 * erScoreJudgeSafety : null
//                 * erScoreJudgeLaws : 1
//                 * erScoreJudgeMajor : null
//                 * flag : null
//                 * passCount : 1
//                 * ruleType : 0
//                 * radioNum : 40
//                 * multiNum : 20
//                 * judgeNum : 40
//                 */
//
//                private String id;
//                private boolean isNewRecord;
//                private int remarks;
//                private String createDate;
//                private String updateDate;
//                private String name;
//                private int erLength;
//                private int erPassMark;
//                private int erRepeatExamCount;
//                private int erTotalScore;
//                private int erScoreSafety;
//                private int erScoreLaws;
//                private int erScoreMajor;
//                private int erRadioNumSafety;
//                private int erRadioNumLaws;
//                private int erRadioNumMajor;
//                private int erMultiNumSafety;
//                private int erMultiNumLaws;
//                private int erMultiNumMajor;
//                private int erJudgeNumSafety;
//                private int erJudgeNumLaws;
//                private int erJudgeNumMajor;
//                private int erScoreRadioSafety;
//                private int erScoreRadioLaws;
//                private int erScoreRadioMajor;
//                private int erScoreMultiSafety;
//                private int erScoreMultiLaws;
//                private int erScoreMultiMajor;
//                private int erScoreJudgeSafety;
//                private int erScoreJudgeLaws;
//                private int erScoreJudgeMajor;
//                private int flag;
//                private int passCount;
//                private String ruleType;
//                private int radioNum;
//                private int multiNum;
//                private int judgeNum;
//
//                public String getId() {
//                    return id;
//                }
//
//                public void setId(String id) {
//                    this.id = id;
//                }
//
//                public boolean isIsNewRecord() {
//                    return isNewRecord;
//                }
//
//                public void setIsNewRecord(boolean isNewRecord) {
//                    this.isNewRecord = isNewRecord;
//                }
//
//                public Object getRemarks() {
//                    return remarks;
//                }
//
//                public void setRemarks(int remarks) {
//                    this.remarks = remarks;
//                }
//
//                public String getCreateDate() {
//                    return createDate;
//                }
//
//                public void setCreateDate(String createDate) {
//                    this.createDate = createDate;
//                }
//
//                public String getUpdateDate() {
//                    return updateDate;
//                }
//
//                public void setUpdateDate(String updateDate) {
//                    this.updateDate = updateDate;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public int getErLength() {
//                    return erLength;
//                }
//
//                public void setErLength(int erLength) {
//                    this.erLength = erLength;
//                }
//
//                public int getErPassMark() {
//                    return erPassMark;
//                }
//
//                public void setErPassMark(int erPassMark) {
//                    this.erPassMark = erPassMark;
//                }
//
//                public int getErRepeatExamCount() {
//                    return erRepeatExamCount;
//                }
//
//                public void setErRepeatExamCount(int erRepeatExamCount) {
//                    this.erRepeatExamCount = erRepeatExamCount;
//                }
//
//                public int getErTotalScore() {
//                    return erTotalScore;
//                }
//
//                public void setErTotalScore(int erTotalScore) {
//                    this.erTotalScore = erTotalScore;
//                }
//
//                public int getErScoreSafety() {
//                    return erScoreSafety;
//                }
//
//                public void setErScoreSafety(int erScoreSafety) {
//                    this.erScoreSafety = erScoreSafety;
//                }
//
//                public int getErScoreLaws() {
//                    return erScoreLaws;
//                }
//
//                public void setErScoreLaws(int erScoreLaws) {
//                    this.erScoreLaws = erScoreLaws;
//                }
//
//                public int getErScoreMajor() {
//                    return erScoreMajor;
//                }
//
//                public void setErScoreMajor(int erScoreMajor) {
//                    this.erScoreMajor = erScoreMajor;
//                }
//
//                public int getErRadioNumSafety() {
//                    return erRadioNumSafety;
//                }
//
//                public void setErRadioNumSafety(int erRadioNumSafety) {
//                    this.erRadioNumSafety = erRadioNumSafety;
//                }
//
//                public int getErRadioNumLaws() {
//                    return erRadioNumLaws;
//                }
//
//                public void setErRadioNumLaws(int erRadioNumLaws) {
//                    this.erRadioNumLaws = erRadioNumLaws;
//                }
//
//                public int getErRadioNumMajor() {
//                    return erRadioNumMajor;
//                }
//
//                public void setErRadioNumMajor(int erRadioNumMajor) {
//                    this.erRadioNumMajor = erRadioNumMajor;
//                }
//
//                public int getErMultiNumSafety() {
//                    return erMultiNumSafety;
//                }
//
//                public void setErMultiNumSafety(int erMultiNumSafety) {
//                    this.erMultiNumSafety = erMultiNumSafety;
//                }
//
//                public int getErMultiNumLaws() {
//                    return erMultiNumLaws;
//                }
//
//                public void setErMultiNumLaws(int erMultiNumLaws) {
//                    this.erMultiNumLaws = erMultiNumLaws;
//                }
//
//                public int getErMultiNumMajor() {
//                    return erMultiNumMajor;
//                }
//
//                public void setErMultiNumMajor(int erMultiNumMajor) {
//                    this.erMultiNumMajor = erMultiNumMajor;
//                }
//
//                public int getErJudgeNumSafety() {
//                    return erJudgeNumSafety;
//                }
//
//                public void setErJudgeNumSafety(int erJudgeNumSafety) {
//                    this.erJudgeNumSafety = erJudgeNumSafety;
//                }
//
//                public int getErJudgeNumLaws() {
//                    return erJudgeNumLaws;
//                }
//
//                public void setErJudgeNumLaws(int erJudgeNumLaws) {
//                    this.erJudgeNumLaws = erJudgeNumLaws;
//                }
//
//                public int getErJudgeNumMajor() {
//                    return erJudgeNumMajor;
//                }
//
//                public void setErJudgeNumMajor(int erJudgeNumMajor) {
//                    this.erJudgeNumMajor = erJudgeNumMajor;
//                }
//
//                public int getErScoreRadioSafety() {
//                    return erScoreRadioSafety;
//                }
//
//                public void setErScoreRadioSafety(int erScoreRadioSafety) {
//                    this.erScoreRadioSafety = erScoreRadioSafety;
//                }
//
//                public int getErScoreRadioLaws() {
//                    return erScoreRadioLaws;
//                }
//
//                public void setErScoreRadioLaws(int erScoreRadioLaws) {
//                    this.erScoreRadioLaws = erScoreRadioLaws;
//                }
//
//                public int getErScoreRadioMajor() {
//                    return erScoreRadioMajor;
//                }
//
//                public void setErScoreRadioMajor(int erScoreRadioMajor) {
//                    this.erScoreRadioMajor = erScoreRadioMajor;
//                }
//
//                public int getErScoreMultiSafety() {
//                    return erScoreMultiSafety;
//                }
//
//                public void setErScoreMultiSafety(int erScoreMultiSafety) {
//                    this.erScoreMultiSafety = erScoreMultiSafety;
//                }
//
//                public int getErScoreMultiLaws() {
//                    return erScoreMultiLaws;
//                }
//
//                public void setErScoreMultiLaws(int erScoreMultiLaws) {
//                    this.erScoreMultiLaws = erScoreMultiLaws;
//                }
//
//                public int getErScoreMultiMajor() {
//                    return erScoreMultiMajor;
//                }
//
//                public void setErScoreMultiMajor(int erScoreMultiMajor) {
//                    this.erScoreMultiMajor = erScoreMultiMajor;
//                }
//
//                public int getErScoreJudgeSafety() {
//                    return erScoreJudgeSafety;
//                }
//
//                public void setErScoreJudgeSafety(int erScoreJudgeSafety) {
//                    this.erScoreJudgeSafety = erScoreJudgeSafety;
//                }
//
//                public int getErScoreJudgeLaws() {
//                    return erScoreJudgeLaws;
//                }
//
//                public void setErScoreJudgeLaws(int erScoreJudgeLaws) {
//                    this.erScoreJudgeLaws = erScoreJudgeLaws;
//                }
//
//                public int getErScoreJudgeMajor() {
//                    return erScoreJudgeMajor;
//                }
//
//                public void setErScoreJudgeMajor(int erScoreJudgeMajor) {
//                    this.erScoreJudgeMajor = erScoreJudgeMajor;
//                }
//
//                public int getFlag() {
//                    return flag;
//                }
//
//                public void setFlag(int flag) {
//                    this.flag = flag;
//                }
//
//                public int getPassCount() {
//                    return passCount;
//                }
//
//                public void setPassCount(int passCount) {
//                    this.passCount = passCount;
//                }
//
//                public String getRuleType() {
//                    return ruleType;
//                }
//
//                public void setRuleType(String ruleType) {
//                    this.ruleType = ruleType;
//                }
//
//                public int getRadioNum() {
//                    return radioNum;
//                }
//
//                public void setRadioNum(int radioNum) {
//                    this.radioNum = radioNum;
//                }
//
//                public int getMultiNum() {
//                    return multiNum;
//                }
//
//                public void setMultiNum(int multiNum) {
//                    this.multiNum = multiNum;
//                }
//
//                public int getJudgeNum() {
//                    return judgeNum;
//                }
//
//                public void setJudgeNum(int judgeNum) {
//                    this.judgeNum = judgeNum;
//                }
//            }
//        }
//    }

}