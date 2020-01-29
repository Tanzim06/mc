package com.bz.mc.converter.attribute;


import com.bz.mc.model.studentRegistration.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * User: moly
 * Date: 23/12/19
 * Time: 12:31 PM
 */
@Converter(autoApply = true)
public class  GenderConverter implements AttributeConverter<Gender,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return gender == null ? null : gender.getId();
    }
    @Override
    public Gender convertToEntityAttribute(Integer id) {
        return id == null ? null : Gender.getById(id);
    }
}
