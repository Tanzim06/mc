package com.bz.mc.converter.attribute;


import com.bz.mc.model.common.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * User: ziaurrahman
 * Date: 2019-11-09
 * Time: 16:01
 */
@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {
    @Override public Integer convertToDatabaseColumn(UserType type) {
        return type.getId();
    }

    @Override public UserType convertToEntityAttribute(Integer id) {
        return UserType.getById(id);
    }
}
