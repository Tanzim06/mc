package com.bz.mc.converter.form;

import com.bz.mc.model.studentRegistration.Gender;
import org.springframework.core.convert.converter.Converter;

/**
 * User: moly
 * Date: 23/12/19
 * Time: 12:31 PM
 */
public class GenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        try {
            return Gender.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
