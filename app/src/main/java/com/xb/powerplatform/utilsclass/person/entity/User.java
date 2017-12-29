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
     * body : {"bmList":[{"id":"d25a1fc12bc448dea7df860368e55174","isNewRecord":false,"remarks":null,"createDate":"2017-12-11 07:10:45","updateDate":"2017-12-11 07:14:35","classId":"a0a94920ef01456f89954aa5f1c3ff30","classType":null,"className":"2017年12月11日闯关竞赛班 闯关竞赛专业 第1期","crednumber":"370883199211265113","enrolName":"王发秋","enrolGender":"男","birthday":"1994-11-09","nation":"汉","address":"山东济南","edu":"研究生及以上","political":"中共党员","icCard":"001","org":"总公司","company":"唐口煤业","department":"重点工区","worktype":"变配电工","workpost":null,"team":"班组长","cmpiTitleprof":"高级","titleprof":null,"health":"健康","photo":"","enrolTime":"2017-12-11","isOpenExam":"0","examState":"2","isPhoneExam":"0","signCount":0,"signRuleCount":20,"isAchieve":null,"classExamState":"2","majorId":"2dd6815026b44545809c05f2490c9fb3","score":null,"passScore":null,"times":null,"cmpiMname":null,"cmpiWorktype":null,"searchBy":null,"staff":null,"staffId":"f12116522848440ba4be256fa008c20d","staffName":null},{"id":"0a3db5d1c43f440c99a189c0e9254a96","isNewRecord":false,"remarks":null,"createDate":"2017-12-09 09:19:28","updateDate":"2017-12-11 09:38:51","classId":"d6b7e115d4a64284a8083305f605684a","classType":null,"className":"2017年12月9日普通班级班 班组长 第1期","crednumber":"370883199211265113","enrolName":"王发秋","enrolGender":"男","birthday":"1994-11-09","nation":"汉","address":"山东济南","edu":"研究生及以上","political":"中共党员","icCard":"999","org":"总公司","company":"唐口煤业","department":"重点工区","worktype":"变配电工","workpost":null,"team":"班组长","cmpiTitleprof":null,"titleprof":null,"health":"健康","photo":"","enrolTime":"2017-12-09","isOpenExam":"0","examState":"0","isPhoneExam":"1","signCount":0,"signRuleCount":20,"isAchieve":null,"classExamState":"0","majorId":"4c0472866c2e4ecda1dec04f33f08322","score":null,"passScore":null,"times":null,"cmpiMname":null,"cmpiWorktype":null,"searchBy":null,"staff":null,"staffId":null,"staffName":null}],"examClass":{"classId":"d6b7e115d4a64284a8083305f605684a","className":"2017年12月9日普通班级班 班组长 第1期"}}
     */

    public boolean success;
    public String errorCode;
    public String msg;
    public BodyBean body;

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
         * bmList : [{"id":"d25a1fc12bc448dea7df860368e55174","isNewRecord":false,"remarks":null,"createDate":"2017-12-11 07:10:45","updateDate":"2017-12-11 07:14:35","classId":"a0a94920ef01456f89954aa5f1c3ff30","classType":null,"className":"2017年12月11日闯关竞赛班 闯关竞赛专业 第1期","crednumber":"370883199211265113","enrolName":"王发秋","enrolGender":"男","birthday":"1994-11-09","nation":"汉","address":"山东济南","edu":"研究生及以上","political":"中共党员","icCard":"001","org":"总公司","company":"唐口煤业","department":"重点工区","worktype":"变配电工","workpost":null,"team":"班组长","cmpiTitleprof":"高级","titleprof":null,"health":"健康","photo":"","enrolTime":"2017-12-11","isOpenExam":"0","examState":"2","isPhoneExam":"0","signCount":0,"signRuleCount":20,"isAchieve":null,"classExamState":"2","majorId":"2dd6815026b44545809c05f2490c9fb3","score":null,"passScore":null,"times":null,"cmpiMname":null,"cmpiWorktype":null,"searchBy":null,"staff":null,"staffId":"f12116522848440ba4be256fa008c20d","staffName":null},{"id":"0a3db5d1c43f440c99a189c0e9254a96","isNewRecord":false,"remarks":null,"createDate":"2017-12-09 09:19:28","updateDate":"2017-12-11 09:38:51","classId":"d6b7e115d4a64284a8083305f605684a","classType":null,"className":"2017年12月9日普通班级班 班组长 第1期","crednumber":"370883199211265113","enrolName":"王发秋","enrolGender":"男","birthday":"1994-11-09","nation":"汉","address":"山东济南","edu":"研究生及以上","political":"中共党员","icCard":"999","org":"总公司","company":"唐口煤业","department":"重点工区","worktype":"变配电工","workpost":null,"team":"班组长","cmpiTitleprof":null,"titleprof":null,"health":"健康","photo":"","enrolTime":"2017-12-09","isOpenExam":"0","examState":"0","isPhoneExam":"1","signCount":0,"signRuleCount":20,"isAchieve":null,"classExamState":"0","majorId":"4c0472866c2e4ecda1dec04f33f08322","score":null,"passScore":null,"times":null,"cmpiMname":null,"cmpiWorktype":null,"searchBy":null,"staff":null,"staffId":null,"staffName":null}]
         * examClass : {"classId":"d6b7e115d4a64284a8083305f605684a","className":"2017年12月9日普通班级班 班组长 第1期"}
         */

        public ExamClassBean examClass;
        public List<BmListBean> bmList;

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
             * classId : d6b7e115d4a64284a8083305f605684a
             * className : 2017年12月9日普通班级班 班组长 第1期
             */

            public String classId;
            public String className;

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
             * id : d25a1fc12bc448dea7df860368e55174
             * isNewRecord : false
             * remarks : null
             * createDate : 2017-12-11 07:10:45
             * updateDate : 2017-12-11 07:14:35
             * classId : a0a94920ef01456f89954aa5f1c3ff30
             * classType : null
             * className : 2017年12月11日闯关竞赛班 闯关竞赛专业 第1期
             * crednumber : 370883199211265113
             * enrolName : 王发秋
             * enrolGender : 男
             * birthday : 1994-11-09
             * nation : 汉
             * address : 山东济南
             * edu : 研究生及以上
             * political : 中共党员
             * icCard : 001
             * org : 总公司
             * company : 唐口煤业
             * department : 重点工区
             * worktype : 变配电工
             * workpost : null
             * team : 班组长
             * cmpiTitleprof : 高级
             * titleprof : null
             * health : 健康
             * photo :
             * enrolTime : 2017-12-11
             * isOpenExam : 0
             * examState : 2
             * isPhoneExam : 0
             * signCount : 0
             * signRuleCount : 20
             * isAchieve : null
             * classExamState : 2
             * majorId : 2dd6815026b44545809c05f2490c9fb3
             * score : null
             * passScore : null
             * times : null
             * cmpiMname : null
             * cmpiWorktype : null
             * searchBy : null
             * staff : null
             * staffId : f12116522848440ba4be256fa008c20d
             * staffName : null
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private String classId;
            private Object classType;
            private String className;
            private String crednumber;
            private String enrolName;
            private String enrolGender;
            private String birthday;
            private String nation;
            private String address;
            private String edu;
            private String political;
            private String icCard;
            private String org;
            private String company;
            private String department;
            private Object worktype;
            private Object workpost;
            private String team;
            private String cmpiTitleprof;
            private Object titleprof;
            private String health;
            private String photo;
            private String enrolTime;
            private String isOpenExam;
            private String examState;
            private String isPhoneExam;
            private int signCount;
            private int signRuleCount;
            private Object isAchieve;
            private String classExamState;
            private String majorId;
            private Object score;
            private Object passScore;
            private Object times;
            private Object cmpiMname;
            private Object cmpiWorktype;
            private Object searchBy;
            private Object staff;
            private String staffId;
            private Object staffName;

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

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
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

            public String getIcCard() {
                return icCard;
            }

            public void setIcCard(String icCard) {
                this.icCard = icCard;
            }

            public String getOrg() {
                return org;
            }

            public void setOrg(String org) {
                this.org = org;
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

            public Object getWorktype() {
                return worktype;
            }

            public void setWorktype(String worktype) {
                this.worktype = worktype;
            }

            public Object getWorkpost() {
                return workpost;
            }

            public void setWorkpost(Object workpost) {
                this.workpost = workpost;
            }

            public String getTeam() {
                return team;
            }

            public void setTeam(String team) {
                this.team = team;
            }

            public String getCmpiTitleprof() {
                return cmpiTitleprof;
            }

            public void setCmpiTitleprof(String cmpiTitleprof) {
                this.cmpiTitleprof = cmpiTitleprof;
            }

            public Object getTitleprof() {
                return titleprof;
            }

            public void setTitleprof(Object titleprof) {
                this.titleprof = titleprof;
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

            public String getEnrolTime() {
                return enrolTime;
            }

            public void setEnrolTime(String enrolTime) {
                this.enrolTime = enrolTime;
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

            public Object getIsAchieve() {
                return isAchieve;
            }

            public void setIsAchieve(Object isAchieve) {
                this.isAchieve = isAchieve;
            }

            public String getClassExamState() {
                return classExamState;
            }

            public void setClassExamState(String classExamState) {
                this.classExamState = classExamState;
            }

            public String getMajorId() {
                return majorId;
            }

            public void setMajorId(String majorId) {
                this.majorId = majorId;
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

            public Object getTimes() {
                return times;
            }

            public void setTimes(Object times) {
                this.times = times;
            }

            public Object getCmpiMname() {
                return cmpiMname;
            }

            public void setCmpiMname(Object cmpiMname) {
                this.cmpiMname = cmpiMname;
            }

            public Object getCmpiWorktype() {
                return cmpiWorktype;
            }

            public void setCmpiWorktype(Object cmpiWorktype) {
                this.cmpiWorktype = cmpiWorktype;
            }

            public Object getSearchBy() {
                return searchBy;
            }

            public void setSearchBy(Object searchBy) {
                this.searchBy = searchBy;
            }

            public Object getStaff() {
                return staff;
            }

            public void setStaff(Object staff) {
                this.staff = staff;
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
        }
    }
}
