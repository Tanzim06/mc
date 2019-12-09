package com.bz.mc.util;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * User: rafiq
 * Date: 17/11/19
 * Time: 1:22 AM
 */
public final class DateTimeUtils {
    public static Date toDate(@Nonnull LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate toLocalDate(@Nonnull Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
