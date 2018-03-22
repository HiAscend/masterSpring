package com.smart.chapter17.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * StringToUserConverter
 *
 * @author zziaa
 * @date 2018/03/22 21:03
 */
public class StringToUserConverter implements Converter<String, User> {
    private static final Logger LOG = LoggerFactory.getLogger(StringToUserConverter.class);

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     * <userName>:<password>:<realName>
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public User convert(String source) {
        LOG.debug("execute StringToUserConverter...");
        User user = new User();
        if (source != null) {
            String[] items = source.split(":");
            user.setUserName(items[0]);
            user.setPassword(items[1]);
            user.setRealName(items[2]);
        }
        return user;
    }
}
