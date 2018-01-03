package com.xb.powerplatform.utilsclass.person.entity;

import java.io.Serializable;

/**
 * Created by dell on 2018/1/3.
 */

public class upApp implements Serializable {

    /**
     * code : 200
     * version : app-release.apk
     */

    private String code;
    private String version;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
