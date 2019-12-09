package com.bz.mc.converter.form;

import com.bz.mc.model.common.UserType;
import org.springframework.core.convert.converter.Converter;

/**
 * User: SHI
 * Date: 2019-12-09
 * Time: 16:53
 */
public class UserTypeConverter implements Converter<String, UserType> {
    @Override public UserType convert(String source) {
        try {
            return UserType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
