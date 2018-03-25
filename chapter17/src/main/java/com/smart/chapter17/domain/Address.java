package com.smart.chapter17.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Address
 *
 * @author ascend
 * @date 2018/3/13 8:57.
 */
public class Address {
    private String tel;
    private String zoneCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
