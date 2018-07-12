package com.smart.chapter19.domain.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * User
 *
 * @author ascend
 * @date 2018/7/12 17:37.
 */
public class User {
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String password;
    protected int credits;
    @XmlElement(required = true)
    protected String lastIp;





    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"loginLogList"})
    public static class Logs {
        protected List<LoginLog> loginLogList;

        public List<LoginLog> getLoginLogList() {
            if (this.loginLogList == null) {
                loginLogList = new ArrayList<>();
            }
            return loginLogList;
        }
    }


}
