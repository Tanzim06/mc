package com.bz.mc.converter.attribute;


import com.bz.mc.model.common.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * User: ziaurrahman
 * Date: 2019-11-09
 * Time: 14:31
 */
@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
    @Override public Integer convertToDatabaseColumn(UserStatus status) {
        return status.getId();
    }

    @Override public UserStatus convertToEntityAttribute(Integer id) {
        return UserStatus.getById(id);
    }
}
