package com.bz.mc.converter.form;

import com.bz.mc.model.charge.Origin;
import org.springframework.core.convert.converter.Converter;
/**
 * User: Shahidul
 * Date: 05/01/20
 * Time: 11:00 am
 */


public class OriginConverter implements Converter<String, Origin> {
    @Override
    public Origin convert(String source) {
        try {
            return Origin.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
