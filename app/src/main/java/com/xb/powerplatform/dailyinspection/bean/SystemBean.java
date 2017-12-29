package com.xb.powerplatform.dailyinspection.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2017/11/29.
 */

public class SystemBean implements Serializable {
    private int id;
    private String name;
    private boolean flag = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<SystemChildBean> getChild() {
        return child;
    }

    public void setChild(List<SystemChildBean> child) {
        this.child = child;
    }

    private List<SystemChildBean> child;
}
