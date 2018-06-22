package com.smart.chapter18.domain;

import com.smart.chapter18.util.MyReflectionToStringBuilder;

import java.io.Serializable;

/**
 * BaseDomain
 *
 * @author zziaa
 * @date 2018/04/22 12:07
 */
public class BaseDomain implements Serializable{
    protected static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MyReflectionToStringBuilder.toString(this);
    }
}
