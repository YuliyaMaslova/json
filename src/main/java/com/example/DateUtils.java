package com.example;

import java.security.Timestamp;
import java.time.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateUtils {

    // метод возвращающий следующий день к переданной дате
    public LocalDate nextDay(LocalDate day) {
        day = day.plusDays(1);
        return day;
    }

    // метод возвращает true если переданный диапазон активен (startDate <= текущая дата >= endDate
    public boolean isActive(LocalDate startDate, LocalDate endDate) {
        LocalDate dateNow = LocalDate.now();
        return !dateNow.isBefore(startDate) && !dateNow.isAfter(endDate);

    }

    // Написать метод, который возвращает день недели для заданной даты
    public DayOfWeek getDayOfWeek(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day;

    }

    // Написать метод, который возвращает количество дней между двумя датами
    public long daysBetween(LocalDate date1, LocalDate date2) {
        long daysBetween = DAYS.between(date1, date2);
        return daysBetween;
    }

    // преобразование даты к таймстемп
    public long toTimestamp(LocalDate date) {
        LocalDateTime dateTime = date.atStartOfDay();
        return dateTime.toEpochSecond(java.time.ZoneOffset.UTC);
    }

    // преобразование даты времени к таймстемп
    public long localDateTimeToTimestamp(LocalDateTime date) {
        return date.toEpochSecond(java.time.ZoneOffset.UTC);
    }

    //         преобразование таймстемп к LocalDate
    public LocalDate timestampToLocalDate(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalDate();

    }

    // преобразование таймстемп к LocalDateTime
    public LocalDateTime timestampToLocalDateTime(long timestamp) {
//
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("UTC"));
        return dateTime;
    }
}

