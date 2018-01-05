package com.xb.powerplatform.utilsclass.person.entity;

import java.io.Serializable;

/**
 * Created by dell on 2017/4/21.
 */

public class User implements Serializable {

    /**
     * success : true
     * errorCode : -1
     * msg : 登录成功！
     * body : {"user":{"mobile":null,"cred":"370828199310201356","depart":"充填中心","name":"胡肖峰","company":"唐口煤业"}}
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
         * user : {"mobile":null,"cred":"370828199310201356","depart":"充填中心","name":"胡肖峰","company":"唐口煤业"}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * mobile : null
             * cred : 370828199310201356
             * depart : 充填中心
             * name : 胡肖峰
             * company : 唐口煤业
             */

            private Object mobile;
            private String cred;
            private String depart;
            private String name;
            private String company;

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public String getCred() {
                return cred;
            }

            public void setCred(String cred) {
                this.cred = cred;
            }

            public String getDepart() {
                return depart;
            }

            public void setDepart(String depart) {
                this.depart = depart;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }
        }
    }
}
