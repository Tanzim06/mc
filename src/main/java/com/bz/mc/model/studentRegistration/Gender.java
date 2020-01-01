package com.bz.mc.model.studentRegistration;


import com.bz.mc.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * User: moly
 * Date: 23/12/19
 * Time: 12:31 PM
 */
@Getter
@AllArgsConstructor
public enum Gender {

    MALE(1, "Male", "gender.type.male"),
    FEMALE(2, "Female", "gender.type.female"),
    OTHER(3, "Other", "gender.type.other");

    private int id;
    private String name;
    private String key;

    public static Gender getById(int id) {
        return Arrays.stream(values())
                .filter(gender -> gender.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    public static List<Gender> all() {
        return Arrays.asList(values());
    }
}
