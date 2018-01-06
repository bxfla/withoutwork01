package com.xb.powerplatform.utilsclass.person.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/1/6.
 */

public class AssessList implements Serializable {

    /**
     * success : true
     * errorCode : -1
     * msg : 数据获取成功
     * body : {"scoreList":[{"score":"50","examDate":"2018年01月06日","className":"2018年1月6日普通班级 班组长 第1期"},{"score":"-1","examDate":"2018年01月05日","className":"2018年1月5日普通班级 安全管理人员（矿处级） 第1期"}]}
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
        private List<ScoreListBean> scoreList;

        public List<ScoreListBean> getScoreList() {
            return scoreList;
        }

        public void setScoreList(List<ScoreListBean> scoreList) {
            this.scoreList = scoreList;
        }

        public static class ScoreListBean {
            /**
             * score : 50
             * examDate : 2018年01月06日
             * className : 2018年1月6日普通班级 班组长 第1期
             */

            private String score;
            private String examDate;
            private String className;

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getExamDate() {
                return examDate;
            }

            public void setExamDate(String examDate) {
                this.examDate = examDate;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }
        }
    }
}
