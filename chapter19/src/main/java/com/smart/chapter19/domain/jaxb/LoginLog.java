package com.smart.chapter19.domain.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;

/**
 * LoginLog
 *
 * @author ascend
 * @date 2018/7/12 17:44.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginLog", propOrder = {
    "userId",
    "ip",
    "loginDate"
})
public class LoginLog {
    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    protected String ip;

    protected Calendar loginDate;
}
