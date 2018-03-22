package com.smart.chapter17.domain;

import java.beans.PropertyEditorSupport;

/**
 * UserEditor
 *
 * @author zziaa
 * @date 2018/03/22 21:43
 */
public class UserEditorGlobal extends PropertyEditorSupport {
    /**
     * Sets the property value by parsing a given String.  May raise
     * java.lang.IllegalArgumentException if either the String is
     * badly formatted or if this kind of property can't be expressed
     * as text.
     *
     * @param text The string to be parsed.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        if (text != null) {
            String[] items = text.split(":");
            user.setUserName(items[0]+" by propertiesEditor global");
            user.setPassword(items[1]);
            user.setRealName(items[2]);
        }
        setValue(user);
    }
}
