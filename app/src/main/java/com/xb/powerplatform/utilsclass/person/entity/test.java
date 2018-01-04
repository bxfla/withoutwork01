package com.xb.powerplatform.utilsclass.person.entity;

import java.util.List;

/**
 * Created by dell on 2018/1/4.
 */

public class test {

    /**
     * success : true
     * errorCode : -1
     * msg : 登录成功,没有报名信息！
     * body : {"user":{"id":"90b664caa9c64091986921c0012bfc6f","isNewRecord":false,"remarks":null,"createDate":"2017-12-11 01:17:45","updateDate":"2018-01-04 02:34:15","mobile":"15269179758","cred":"370828199310201356","pwd":"434077516342de5d4b023fe70886d27e4fc7c048fe3d83ed6eb7448e"},"bmList":[]}
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
         * user : {"id":"90b664caa9c64091986921c0012bfc6f","isNewRecord":false,"remarks":null,"createDate":"2017-12-11 01:17:45","updateDate":"2018-01-04 02:34:15","mobile":"15269179758","cred":"370828199310201356","pwd":"434077516342de5d4b023fe70886d27e4fc7c048fe3d83ed6eb7448e"}
         * bmList : []
         */

        private UserBean user;
        private List<?> bmList;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getBmList() {
            return bmList;
        }

        public void setBmList(List<?> bmList) {
            this.bmList = bmList;
        }

        public static class UserBean {
            /**
             * id : 90b664caa9c64091986921c0012bfc6f
             * isNewRecord : false
             * remarks : null
             * createDate : 2017-12-11 01:17:45
             * updateDate : 2018-01-04 02:34:15
             * mobile : 15269179758
             * cred : 370828199310201356
             * pwd : 434077516342de5d4b023fe70886d27e4fc7c048fe3d83ed6eb7448e
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private String mobile;
            private String cred;
            private String pwd;

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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getCred() {
                return cred;
            }

            public void setCred(String cred) {
                this.cred = cred;
            }

            public String getPwd() {
                return pwd;
            }

            public void setPwd(String pwd) {
                this.pwd = pwd;
            }
        }
    }
}
