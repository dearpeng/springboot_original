package com.honeypeng.config.dataSourceConfig;

/**
 * Created by PengWX on 2020/11/25.
 */
public enum DsTypeEnum {

    ds1(1,"ds1"),
    ds2(2,"ds2");

    private Integer code;
    private String dsName;

    private DsTypeEnum(Integer code, String dsName) {
        this.code = code;
        this.dsName = dsName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }
}
