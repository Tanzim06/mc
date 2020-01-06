package com.bz.mc.model.charge;

import com.bz.mc.exception.NotFoundException;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * User: Shahidul
 * Date: 05/01/20
 * Time: 10:18 am
 */
@Getter
@AllArgsConstructor
public enum Origin {
    LOCAL(1, "Local", "origin.type.local"),
    FOREIGN(2, "Foreign", "origin.type.foreign"),
    BOTH(3, "Both", "origin.type.both");

    private int id;
    private String name;
    private String key;

    public static Origin getById(int id) {
        return Arrays.stream(values())
                .filter(origin -> origin.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    public static List<Origin> all() {
        return Arrays.asList(values());
    }


}
