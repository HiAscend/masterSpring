package com.smart.chapter17.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Dept
 *
 * @author ascend
 * @date 2018/3/13 8:51.
 */
public class Dept {
    private String deptId;
    private String deptNo;
    private String deptName;

    private Address address;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
