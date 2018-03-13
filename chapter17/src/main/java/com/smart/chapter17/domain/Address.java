package com.smart.chapter17.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Address
 *
 * @author ascend
 * @date 2018/3/13 8:57.
 */
public class Address {
    private String tel;
    private String zoneCode;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
