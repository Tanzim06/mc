package com.bz.mc.converter.form;

import com.bz.mc.model.common.UserStatus;
import org.springframework.core.convert.converter.Converter;

/**
 * User: ziaurrahman
 * Date: 2019-11-09
 * Time: 14:26
 */
public class UserStatusConverter implements Converter<String, UserStatus> {
    @Override public UserStatus convert(String source) {
        try {
            return UserStatus.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
