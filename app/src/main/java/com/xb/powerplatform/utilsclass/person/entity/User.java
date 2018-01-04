package com.xb.powerplatform.utilsclass.person.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2017/4/21.
 */

public class User implements Serializable {


    /**
     * success : true
     * errorCode : -1
     * msg : 登录成功！
     * body : {"bmList":[{"id":"702bc7b9a01b4d98b3e786a53529de31","isNewRecord":false,"remarks":null,"createDate":"2018-01-04 04:37:28","updateDate":"2018-01-04 04:37:28","staffId":"b5b7db289f7648e8bf939887ef6b06d8","staffName":null,"crednumber":"370828199310201356","enrolName":"胡肖峰","enrolGender":"男","birthday":null,"nation":"汉族","address":"山东济宁","edu":"专科或同等学历","political":"","health":"健康","photo":"/images/5b6d712d-163a-410b-aa93-6302b16000f0.jpg","printState":"0","staff":null,"org":"总公司","cmpiMname":null,"company":"唐口煤业","department":"充填中心","team":"班组一","worktype":{"id":"2d7bc688984c4cec9f182e1bd08ff8e5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"人行车跟车信号工","workType":"4","flag":null},"workpost":{"id":"5224a33517e14295b82c9ed87ff367de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"总经理助理","workType":"5","flag":null},"cmpiWorktype":null,"cmpiTitleprof":"19291cbf84e4485087f9bfd6c8a16152","titleprof":{"id":"19291cbf84e4485087f9bfd6c8a16152","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"name":"正高级"},"classId":"a202f7c69ede47719687be389321fb27","classType":null,"className":"2017年12月29日普通班级 1500 第1期","majorId":"e1159c61cd494ddabec9ccc42464c58b","classList":null,"classExamState":null,"icCard":"","enrolTime":"2018-01-04","enrolEndTime":null,"isOpenExam":"0","examState":"0","isPhoneExam":"0","isAchieve":null,"signCount":0,"signRuleCount":0,"phone":null,"times":null,"score":null,"passScore":null,"searchBy":null,"erRepeatExamCount":null,"examCount":null}],"userInfo":{"id":"901afb893df84313b2caace23d3837f2","isNewRecord":false,"remarks":null,"createDate":"2017-12-28 07:06:31","updateDate":"2018-01-04 04:37:28","group":{"id":"1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"总公司","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"company":{"id":"1cfee864a9944b07b3741d678dc8a903","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"唐口煤业","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"cmpiUtype":null,"department":{"id":"df86f86aa900469d98e5d06f914fe7e6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"充填中心","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"team":{"id":"922e8a07e3ea49869aaa5ca404040072","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"班组一","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"cmpiName":"胡肖峰","cmpiSex":"男","cmpiCredtype":null,"cmpiBdate":null,"cmpiCrednumber":"370828199310201356","cmpiTitleprof":"19291cbf84e4485087f9bfd6c8a16152","titleprof":{"id":"19291cbf84e4485087f9bfd6c8a16152","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"name":"正高级"},"cmpiAge":null,"cmpiPhone":null,"cmpiEducation":"专科或同等学历","worktype":{"id":"2d7bc688984c4cec9f182e1bd08ff8e5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"人行车跟车信号工","workType":null,"flag":null},"cmpiWorkType":"2d7bc688984c4cec9f182e1bd08ff8e5","cmpiPost":"5224a33517e14295b82c9ed87ff367de","post":{"id":"5224a33517e14295b82c9ed87ff367de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"总经理助理","workType":null,"flag":null},"hygiene":null,"partTimeJob":null,"entryDate":null,"changeTime":null,"nation":"汉族","address":"山东济宁","health":"健康","pictureUrl":"/images/5b6d712d-163a-410b-aa93-6302b16000f0.jpg","classInfo":null,"examScore":null,"trainInfo":null,"changeStartTime":null,"changeEndTime":null},"examClass":{}}
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
         * bmList : [{"id":"702bc7b9a01b4d98b3e786a53529de31","isNewRecord":false,"remarks":null,"createDate":"2018-01-04 04:37:28","updateDate":"2018-01-04 04:37:28","staffId":"b5b7db289f7648e8bf939887ef6b06d8","staffName":null,"crednumber":"370828199310201356","enrolName":"胡肖峰","enrolGender":"男","birthday":null,"nation":"汉族","address":"山东济宁","edu":"专科或同等学历","political":"","health":"健康","photo":"/images/5b6d712d-163a-410b-aa93-6302b16000f0.jpg","printState":"0","staff":null,"org":"总公司","cmpiMname":null,"company":"唐口煤业","department":"充填中心","team":"班组一","worktype":{"id":"2d7bc688984c4cec9f182e1bd08ff8e5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"人行车跟车信号工","workType":"4","flag":null},"workpost":{"id":"5224a33517e14295b82c9ed87ff367de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"总经理助理","workType":"5","flag":null},"cmpiWorktype":null,"cmpiTitleprof":"19291cbf84e4485087f9bfd6c8a16152","titleprof":{"id":"19291cbf84e4485087f9bfd6c8a16152","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"name":"正高级"},"classId":"a202f7c69ede47719687be389321fb27","classType":null,"className":"2017年12月29日普通班级 1500 第1期","majorId":"e1159c61cd494ddabec9ccc42464c58b","classList":null,"classExamState":null,"icCard":"","enrolTime":"2018-01-04","enrolEndTime":null,"isOpenExam":"0","examState":"0","isPhoneExam":"0","isAchieve":null,"signCount":0,"signRuleCount":0,"phone":null,"times":null,"score":null,"passScore":null,"searchBy":null,"erRepeatExamCount":null,"examCount":null}]
         * userInfo : {"id":"901afb893df84313b2caace23d3837f2","isNewRecord":false,"remarks":null,"createDate":"2017-12-28 07:06:31","updateDate":"2018-01-04 04:37:28","group":{"id":"1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"总公司","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"company":{"id":"1cfee864a9944b07b3741d678dc8a903","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"唐口煤业","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"cmpiUtype":null,"department":{"id":"df86f86aa900469d98e5d06f914fe7e6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"充填中心","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"team":{"id":"922e8a07e3ea49869aaa5ca404040072","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"班组一","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"},"cmpiName":"胡肖峰","cmpiSex":"男","cmpiCredtype":null,"cmpiBdate":null,"cmpiCrednumber":"370828199310201356","cmpiTitleprof":"19291cbf84e4485087f9bfd6c8a16152","titleprof":{"id":"19291cbf84e4485087f9bfd6c8a16152","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"name":"正高级"},"cmpiAge":null,"cmpiPhone":null,"cmpiEducation":"专科或同等学历","worktype":{"id":"2d7bc688984c4cec9f182e1bd08ff8e5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"人行车跟车信号工","workType":null,"flag":null},"cmpiWorkType":"2d7bc688984c4cec9f182e1bd08ff8e5","cmpiPost":"5224a33517e14295b82c9ed87ff367de","post":{"id":"5224a33517e14295b82c9ed87ff367de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"总经理助理","workType":null,"flag":null},"hygiene":null,"partTimeJob":null,"entryDate":null,"changeTime":null,"nation":"汉族","address":"山东济宁","health":"健康","pictureUrl":"/images/5b6d712d-163a-410b-aa93-6302b16000f0.jpg","classInfo":null,"examScore":null,"trainInfo":null,"changeStartTime":null,"changeEndTime":null}
         * examClass : {}
         */

        private UserInfoBean userInfo;
        private ExamClassBean examClass;
        private List<BmListBean> bmList;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

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

        public static class UserInfoBean {
            /**
             * id : 901afb893df84313b2caace23d3837f2
             * isNewRecord : false
             * remarks : null
             * createDate : 2017-12-28 07:06:31
             * updateDate : 2018-01-04 04:37:28
             * group : {"id":"1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"总公司","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"}
             * company : {"id":"1cfee864a9944b07b3741d678dc8a903","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"唐口煤业","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"}
             * cmpiUtype : null
             * department : {"id":"df86f86aa900469d98e5d06f914fe7e6","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"充填中心","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"}
             * team : {"id":"922e8a07e3ea49869aaa5ca404040072","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"parentIds":null,"name":"班组一","sort":30,"area":null,"code":null,"type":"2","grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,"primaryPerson":null,"deputyPerson":null,"childDeptList":null,"parentId":"0"}
             * cmpiName : 胡肖峰
             * cmpiSex : 男
             * cmpiCredtype : null
             * cmpiBdate : null
             * cmpiCrednumber : 370828199310201356
             * cmpiTitleprof : 19291cbf84e4485087f9bfd6c8a16152
             * titleprof : {"id":"19291cbf84e4485087f9bfd6c8a16152","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"name":"正高级"}
             * cmpiAge : null
             * cmpiPhone : null
             * cmpiEducation : 专科或同等学历
             * worktype : {"id":"2d7bc688984c4cec9f182e1bd08ff8e5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"人行车跟车信号工","workType":null,"flag":null}
             * cmpiWorkType : 2d7bc688984c4cec9f182e1bd08ff8e5
             * cmpiPost : 5224a33517e14295b82c9ed87ff367de
             * post : {"id":"5224a33517e14295b82c9ed87ff367de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"总经理助理","workType":null,"flag":null}
             * hygiene : null
             * partTimeJob : null
             * entryDate : null
             * changeTime : null
             * nation : 汉族
             * address : 山东济宁
             * health : 健康
             * pictureUrl : /images/5b6d712d-163a-410b-aa93-6302b16000f0.jpg
             * classInfo : null
             * examScore : null
             * trainInfo : null
             * changeStartTime : null
             * changeEndTime : null
             */

            private String id;
            private boolean isNewRecord;
            private String cmpiCrednumber;
            private Object remarks;

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public String getCmpiCrednumber() {
                return cmpiCrednumber;
            }

            public void setCmpiCrednumber(String cmpiCrednumber) {
                this.cmpiCrednumber = cmpiCrednumber;
            }

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

            public static class GroupBean {
                /**
                 * id : 1
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 总公司
                 * sort : 30
                 * area : null
                 * code : null
                 * type : 2
                 * grade : null
                 * address : null
                 * zipCode : null
                 * master : null
                 * phone : null
                 * fax : null
                 * email : null
                 * useable : null
                 * primaryPerson : null
                 * deputyPerson : null
                 * childDeptList : null
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object parentIds;
                private String name;
                private int sort;
                private Object area;
                private Object code;
                private String type;
                private Object grade;
                private Object address;
                private Object zipCode;
                private Object master;
                private Object phone;
                private Object fax;
                private Object email;
                private Object useable;
                private Object primaryPerson;
                private Object deputyPerson;
                private Object childDeptList;
                private String parentId;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getParentIds() {
                    return parentIds;
                }

                public void setParentIds(Object parentIds) {
                    this.parentIds = parentIds;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getArea() {
                    return area;
                }

                public void setArea(Object area) {
                    this.area = area;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Object getGrade() {
                    return grade;
                }

                public void setGrade(Object grade) {
                    this.grade = grade;
                }

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getZipCode() {
                    return zipCode;
                }

                public void setZipCode(Object zipCode) {
                    this.zipCode = zipCode;
                }

                public Object getMaster() {
                    return master;
                }

                public void setMaster(Object master) {
                    this.master = master;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getFax() {
                    return fax;
                }

                public void setFax(Object fax) {
                    this.fax = fax;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }

                public Object getUseable() {
                    return useable;
                }

                public void setUseable(Object useable) {
                    this.useable = useable;
                }

                public Object getPrimaryPerson() {
                    return primaryPerson;
                }

                public void setPrimaryPerson(Object primaryPerson) {
                    this.primaryPerson = primaryPerson;
                }

                public Object getDeputyPerson() {
                    return deputyPerson;
                }

                public void setDeputyPerson(Object deputyPerson) {
                    this.deputyPerson = deputyPerson;
                }

                public Object getChildDeptList() {
                    return childDeptList;
                }

                public void setChildDeptList(Object childDeptList) {
                    this.childDeptList = childDeptList;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }

            public static class CompanyBean {
                /**
                 * id : 1cfee864a9944b07b3741d678dc8a903
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 唐口煤业
                 * sort : 30
                 * area : null
                 * code : null
                 * type : 2
                 * grade : null
                 * address : null
                 * zipCode : null
                 * master : null
                 * phone : null
                 * fax : null
                 * email : null
                 * useable : null
                 * primaryPerson : null
                 * deputyPerson : null
                 * childDeptList : null
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object parentIds;
                private String name;
                private int sort;
                private Object area;
                private Object code;
                private String type;
                private Object grade;
                private Object address;
                private Object zipCode;
                private Object master;
                private Object phone;
                private Object fax;
                private Object email;
                private Object useable;
                private Object primaryPerson;
                private Object deputyPerson;
                private Object childDeptList;
                private String parentId;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getParentIds() {
                    return parentIds;
                }

                public void setParentIds(Object parentIds) {
                    this.parentIds = parentIds;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getArea() {
                    return area;
                }

                public void setArea(Object area) {
                    this.area = area;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Object getGrade() {
                    return grade;
                }

                public void setGrade(Object grade) {
                    this.grade = grade;
                }

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getZipCode() {
                    return zipCode;
                }

                public void setZipCode(Object zipCode) {
                    this.zipCode = zipCode;
                }

                public Object getMaster() {
                    return master;
                }

                public void setMaster(Object master) {
                    this.master = master;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getFax() {
                    return fax;
                }

                public void setFax(Object fax) {
                    this.fax = fax;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }

                public Object getUseable() {
                    return useable;
                }

                public void setUseable(Object useable) {
                    this.useable = useable;
                }

                public Object getPrimaryPerson() {
                    return primaryPerson;
                }

                public void setPrimaryPerson(Object primaryPerson) {
                    this.primaryPerson = primaryPerson;
                }

                public Object getDeputyPerson() {
                    return deputyPerson;
                }

                public void setDeputyPerson(Object deputyPerson) {
                    this.deputyPerson = deputyPerson;
                }

                public Object getChildDeptList() {
                    return childDeptList;
                }

                public void setChildDeptList(Object childDeptList) {
                    this.childDeptList = childDeptList;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }

            public static class DepartmentBean {
                /**
                 * id : df86f86aa900469d98e5d06f914fe7e6
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 充填中心
                 * sort : 30
                 * area : null
                 * code : null
                 * type : 2
                 * grade : null
                 * address : null
                 * zipCode : null
                 * master : null
                 * phone : null
                 * fax : null
                 * email : null
                 * useable : null
                 * primaryPerson : null
                 * deputyPerson : null
                 * childDeptList : null
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object parentIds;
                private String name;
                private int sort;
                private Object area;
                private Object code;
                private String type;
                private Object grade;
                private Object address;
                private Object zipCode;
                private Object master;
                private Object phone;
                private Object fax;
                private Object email;
                private Object useable;
                private Object primaryPerson;
                private Object deputyPerson;
                private Object childDeptList;
                private String parentId;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getParentIds() {
                    return parentIds;
                }

                public void setParentIds(Object parentIds) {
                    this.parentIds = parentIds;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getArea() {
                    return area;
                }

                public void setArea(Object area) {
                    this.area = area;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Object getGrade() {
                    return grade;
                }

                public void setGrade(Object grade) {
                    this.grade = grade;
                }

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getZipCode() {
                    return zipCode;
                }

                public void setZipCode(Object zipCode) {
                    this.zipCode = zipCode;
                }

                public Object getMaster() {
                    return master;
                }

                public void setMaster(Object master) {
                    this.master = master;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getFax() {
                    return fax;
                }

                public void setFax(Object fax) {
                    this.fax = fax;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }

                public Object getUseable() {
                    return useable;
                }

                public void setUseable(Object useable) {
                    this.useable = useable;
                }

                public Object getPrimaryPerson() {
                    return primaryPerson;
                }

                public void setPrimaryPerson(Object primaryPerson) {
                    this.primaryPerson = primaryPerson;
                }

                public Object getDeputyPerson() {
                    return deputyPerson;
                }

                public void setDeputyPerson(Object deputyPerson) {
                    this.deputyPerson = deputyPerson;
                }

                public Object getChildDeptList() {
                    return childDeptList;
                }

                public void setChildDeptList(Object childDeptList) {
                    this.childDeptList = childDeptList;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }

            public static class TeamBean {
                /**
                 * id : 922e8a07e3ea49869aaa5ca404040072
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * parentIds : null
                 * name : 班组一
                 * sort : 30
                 * area : null
                 * code : null
                 * type : 2
                 * grade : null
                 * address : null
                 * zipCode : null
                 * master : null
                 * phone : null
                 * fax : null
                 * email : null
                 * useable : null
                 * primaryPerson : null
                 * deputyPerson : null
                 * childDeptList : null
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object parentIds;
                private String name;
                private int sort;
                private Object area;
                private Object code;
                private String type;
                private Object grade;
                private Object address;
                private Object zipCode;
                private Object master;
                private Object phone;
                private Object fax;
                private Object email;
                private Object useable;
                private Object primaryPerson;
                private Object deputyPerson;
                private Object childDeptList;
                private String parentId;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getParentIds() {
                    return parentIds;
                }

                public void setParentIds(Object parentIds) {
                    this.parentIds = parentIds;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public Object getArea() {
                    return area;
                }

                public void setArea(Object area) {
                    this.area = area;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Object getGrade() {
                    return grade;
                }

                public void setGrade(Object grade) {
                    this.grade = grade;
                }

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getZipCode() {
                    return zipCode;
                }

                public void setZipCode(Object zipCode) {
                    this.zipCode = zipCode;
                }

                public Object getMaster() {
                    return master;
                }

                public void setMaster(Object master) {
                    this.master = master;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getFax() {
                    return fax;
                }

                public void setFax(Object fax) {
                    this.fax = fax;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }

                public Object getUseable() {
                    return useable;
                }

                public void setUseable(Object useable) {
                    this.useable = useable;
                }

                public Object getPrimaryPerson() {
                    return primaryPerson;
                }

                public void setPrimaryPerson(Object primaryPerson) {
                    this.primaryPerson = primaryPerson;
                }

                public Object getDeputyPerson() {
                    return deputyPerson;
                }

                public void setDeputyPerson(Object deputyPerson) {
                    this.deputyPerson = deputyPerson;
                }

                public Object getChildDeptList() {
                    return childDeptList;
                }

                public void setChildDeptList(Object childDeptList) {
                    this.childDeptList = childDeptList;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }

            public static class TitleprofBean {
                /**
                 * id : 19291cbf84e4485087f9bfd6c8a16152
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * name : 正高级
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String name;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class WorktypeBean {
                /**
                 * id : 2d7bc688984c4cec9f182e1bd08ff8e5
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * workCategory : null
                 * name : 人行车跟车信号工
                 * workType : null
                 * flag : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object workCategory;
                private String name;
                private Object workType;
                private Object flag;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getWorkCategory() {
                    return workCategory;
                }

                public void setWorkCategory(Object workCategory) {
                    this.workCategory = workCategory;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getWorkType() {
                    return workType;
                }

                public void setWorkType(Object workType) {
                    this.workType = workType;
                }

                public Object getFlag() {
                    return flag;
                }

                public void setFlag(Object flag) {
                    this.flag = flag;
                }
            }

            public static class PostBean {
            }
        }

        public static class ExamClassBean {
        }

        public static class BmListBean {
            /**
             * id : 702bc7b9a01b4d98b3e786a53529de31
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-01-04 04:37:28
             * updateDate : 2018-01-04 04:37:28
             * staffId : b5b7db289f7648e8bf939887ef6b06d8
             * staffName : null
             * crednumber : 370828199310201356
             * enrolName : 胡肖峰
             * enrolGender : 男
             * birthday : null
             * nation : 汉族
             * address : 山东济宁
             * edu : 专科或同等学历
             * political :
             * health : 健康
             * photo : /images/5b6d712d-163a-410b-aa93-6302b16000f0.jpg
             * printState : 0
             * staff : null
             * org : 总公司
             * cmpiMname : null
             * company : 唐口煤业
             * department : 充填中心
             * team : 班组一
             * worktype : {"id":"2d7bc688984c4cec9f182e1bd08ff8e5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"人行车跟车信号工","workType":"4","flag":null}
             * workpost : {"id":"5224a33517e14295b82c9ed87ff367de","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"workCategory":null,"name":"总经理助理","workType":"5","flag":null}
             * cmpiWorktype : null
             * cmpiTitleprof : 19291cbf84e4485087f9bfd6c8a16152
             * titleprof : {"id":"19291cbf84e4485087f9bfd6c8a16152","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"name":"正高级"}
             * classId : a202f7c69ede47719687be389321fb27
             * classType : null
             * className : 2017年12月29日普通班级 1500 第1期
             * majorId : e1159c61cd494ddabec9ccc42464c58b
             * classList : null
             * classExamState : null
             * icCard :
             * enrolTime : 2018-01-04
             * enrolEndTime : null
             * isOpenExam : 0
             * examState : 0
             * isPhoneExam : 0
             * isAchieve : null
             * signCount : 0
             * signRuleCount : 0
             * phone : null
             * times : null
             * score : null
             * passScore : null
             * searchBy : null
             * erRepeatExamCount : null
             * examCount : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private String staffId;
            private Object staffName;
            private String crednumber;
            private String enrolName;
            private String enrolGender;
            private Object birthday;
            private String nation;
            private String address;
            private String edu;
            private String political;
            private String health;
            private String photo;
            private String printState;
            private Object staff;
            private String org;
            private Object cmpiMname;
            private String company;
            private String department;
            private String team;
            private WorktypeBeanX worktype;
            private WorkpostBean workpost;
            private Object cmpiWorktype;
            private String cmpiTitleprof;
            private TitleprofBeanX titleprof;
            private String classId;
            private Object classType;
            private String className;
            private String majorId;
            private Object classList;
            private Object classExamState;
            private String icCard;
            private String enrolTime;
            private Object enrolEndTime;
            private String isOpenExam;
            private String examState;
            private String isPhoneExam;
            private Object isAchieve;
            private int signCount;
            private int signRuleCount;
            private Object phone;
            private Object times;
            private Object score;
            private Object passScore;
            private Object searchBy;
            private Object erRepeatExamCount;
            private Object examCount;

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

            public String getStaffId() {
                return staffId;
            }

            public void setStaffId(String staffId) {
                this.staffId = staffId;
            }

            public Object getStaffName() {
                return staffName;
            }

            public void setStaffName(Object staffName) {
                this.staffName = staffName;
            }

            public String getCrednumber() {
                return crednumber;
            }

            public void setCrednumber(String crednumber) {
                this.crednumber = crednumber;
            }

            public String getEnrolName() {
                return enrolName;
            }

            public void setEnrolName(String enrolName) {
                this.enrolName = enrolName;
            }

            public String getEnrolGender() {
                return enrolGender;
            }

            public void setEnrolGender(String enrolGender) {
                this.enrolGender = enrolGender;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getEdu() {
                return edu;
            }

            public void setEdu(String edu) {
                this.edu = edu;
            }

            public String getPolitical() {
                return political;
            }

            public void setPolitical(String political) {
                this.political = political;
            }

            public String getHealth() {
                return health;
            }

            public void setHealth(String health) {
                this.health = health;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getPrintState() {
                return printState;
            }

            public void setPrintState(String printState) {
                this.printState = printState;
            }

            public Object getStaff() {
                return staff;
            }

            public void setStaff(Object staff) {
                this.staff = staff;
            }

            public String getOrg() {
                return org;
            }

            public void setOrg(String org) {
                this.org = org;
            }

            public Object getCmpiMname() {
                return cmpiMname;
            }

            public void setCmpiMname(Object cmpiMname) {
                this.cmpiMname = cmpiMname;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getTeam() {
                return team;
            }

            public void setTeam(String team) {
                this.team = team;
            }

            public WorktypeBeanX getWorktype() {
                return worktype;
            }

            public void setWorktype(WorktypeBeanX worktype) {
                this.worktype = worktype;
            }

            public WorkpostBean getWorkpost() {
                return workpost;
            }

            public void setWorkpost(WorkpostBean workpost) {
                this.workpost = workpost;
            }

            public Object getCmpiWorktype() {
                return cmpiWorktype;
            }

            public void setCmpiWorktype(Object cmpiWorktype) {
                this.cmpiWorktype = cmpiWorktype;
            }

            public String getCmpiTitleprof() {
                return cmpiTitleprof;
            }

            public void setCmpiTitleprof(String cmpiTitleprof) {
                this.cmpiTitleprof = cmpiTitleprof;
            }

            public TitleprofBeanX getTitleprof() {
                return titleprof;
            }

            public void setTitleprof(TitleprofBeanX titleprof) {
                this.titleprof = titleprof;
            }

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public Object getClassType() {
                return classType;
            }

            public void setClassType(Object classType) {
                this.classType = classType;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public String getMajorId() {
                return majorId;
            }

            public void setMajorId(String majorId) {
                this.majorId = majorId;
            }

            public Object getClassList() {
                return classList;
            }

            public void setClassList(Object classList) {
                this.classList = classList;
            }

            public Object getClassExamState() {
                return classExamState;
            }

            public void setClassExamState(Object classExamState) {
                this.classExamState = classExamState;
            }

            public String getIcCard() {
                return icCard;
            }

            public void setIcCard(String icCard) {
                this.icCard = icCard;
            }

            public String getEnrolTime() {
                return enrolTime;
            }

            public void setEnrolTime(String enrolTime) {
                this.enrolTime = enrolTime;
            }

            public Object getEnrolEndTime() {
                return enrolEndTime;
            }

            public void setEnrolEndTime(Object enrolEndTime) {
                this.enrolEndTime = enrolEndTime;
            }

            public String getIsOpenExam() {
                return isOpenExam;
            }

            public void setIsOpenExam(String isOpenExam) {
                this.isOpenExam = isOpenExam;
            }

            public String getExamState() {
                return examState;
            }

            public void setExamState(String examState) {
                this.examState = examState;
            }

            public String getIsPhoneExam() {
                return isPhoneExam;
            }

            public void setIsPhoneExam(String isPhoneExam) {
                this.isPhoneExam = isPhoneExam;
            }

            public Object getIsAchieve() {
                return isAchieve;
            }

            public void setIsAchieve(Object isAchieve) {
                this.isAchieve = isAchieve;
            }

            public int getSignCount() {
                return signCount;
            }

            public void setSignCount(int signCount) {
                this.signCount = signCount;
            }

            public int getSignRuleCount() {
                return signRuleCount;
            }

            public void setSignRuleCount(int signRuleCount) {
                this.signRuleCount = signRuleCount;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getTimes() {
                return times;
            }

            public void setTimes(Object times) {
                this.times = times;
            }

            public Object getScore() {
                return score;
            }

            public void setScore(Object score) {
                this.score = score;
            }

            public Object getPassScore() {
                return passScore;
            }

            public void setPassScore(Object passScore) {
                this.passScore = passScore;
            }

            public Object getSearchBy() {
                return searchBy;
            }

            public void setSearchBy(Object searchBy) {
                this.searchBy = searchBy;
            }

            public Object getErRepeatExamCount() {
                return erRepeatExamCount;
            }

            public void setErRepeatExamCount(Object erRepeatExamCount) {
                this.erRepeatExamCount = erRepeatExamCount;
            }

            public Object getExamCount() {
                return examCount;
            }

            public void setExamCount(Object examCount) {
                this.examCount = examCount;
            }

            public static class WorktypeBeanX {
                /**
                 * id : 2d7bc688984c4cec9f182e1bd08ff8e5
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * workCategory : null
                 * name : 人行车跟车信号工
                 * workType : 4
                 * flag : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object workCategory;
                private String name;
                private String workType;
                private Object flag;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getWorkCategory() {
                    return workCategory;
                }

                public void setWorkCategory(Object workCategory) {
                    this.workCategory = workCategory;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getWorkType() {
                    return workType;
                }

                public void setWorkType(String workType) {
                    this.workType = workType;
                }

                public Object getFlag() {
                    return flag;
                }

                public void setFlag(Object flag) {
                    this.flag = flag;
                }
            }

            public static class WorkpostBean {
                /**
                 * id : 5224a33517e14295b82c9ed87ff367de
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * workCategory : null
                 * name : 总经理助理
                 * workType : 5
                 * flag : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object workCategory;
                private String name;
                private String workType;
                private Object flag;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getWorkCategory() {
                    return workCategory;
                }

                public void setWorkCategory(Object workCategory) {
                    this.workCategory = workCategory;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getWorkType() {
                    return workType;
                }

                public void setWorkType(String workType) {
                    this.workType = workType;
                }

                public Object getFlag() {
                    return flag;
                }

                public void setFlag(Object flag) {
                    this.flag = flag;
                }
            }

            public static class TitleprofBeanX {
                /**
                 * id : 19291cbf84e4485087f9bfd6c8a16152
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * name : 正高级
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String name;

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

                public Object getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(Object createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
