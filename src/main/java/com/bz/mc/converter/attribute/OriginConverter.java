package com.bz.mc.converter.attribute;

import com.bz.mc.model.charge.Origin;

import javax.persistence.AttributeConverter;
/**
 * User: Shahidul
 * Date: 05/01/20
 * Time: 11:00 am
 */

public class OriginConverter implements AttributeConverter<Origin,Integer> {

    @Override
    public Integer convertToDatabaseColumn(Origin origin) {
        return origin == null ? null : origin.getId();
    }

    @Override
    public Origin convertToEntityAttribute(Integer id) {
        return id == null ? null : Origin.getById(id);
    }
}
