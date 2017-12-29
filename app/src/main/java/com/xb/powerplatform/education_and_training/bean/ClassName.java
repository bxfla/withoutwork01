package com.xb.powerplatform.education_and_training.bean;

import java.io.Serializable;

public class ClassName implements Serializable {


    public String className;
    public String classId;
    public String dwoStatic;

    public ClassName(String className, String classId, String dwoStatic) {
        this.className = className;
        this.classId = classId;
        this.dwoStatic = dwoStatic;
    }

    public String getDwoStatic() {
        return dwoStatic;
    }

    public void setDwoStatic(String dwoStatic) {
        this.dwoStatic = dwoStatic;
    }

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