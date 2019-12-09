package com.bz.mc.model.common;

import com.bz.mc.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * User: rafiq
 * Date: 3/11/19
 * Time: 3:48 PM
 */
@Getter
@AllArgsConstructor
public enum UserType {
    EMPLOYEE(1, "Employee"),
    MEMBER(2, "Member");

    private int id;
    private String name;

    public static UserType getById(int id) {
        return Arrays.stream(values())
                .filter(type -> type.id == id)
                .findAny()
                .orElseThrow(NotFoundException::new);
    }
}
