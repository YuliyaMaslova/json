package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {
    private DateUtils dateUtils = new DateUtils();

    @Test
    void returningTheNextDayToThePassedDate() {
        //given
        LocalDate actualDay = LocalDate.of(2023, Month.MARCH, 12);
        LocalDate expectedNext = LocalDate.of(2023, Month.MARCH, 13);

        //when
        LocalDate nextDay = dateUtils.nextDay(actualDay);

        //then
        Assertions.assertEquals(expectedNext, nextDay);

    }

    @Test
    void activeRange() {
        //given
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        //when
        boolean isActive = dateUtils.isActive(startDate, endDate);

        //then
        Assertions.assertTrue(isActive);

    }

    @Test
    void inActiveRangeMin() {
        //given
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);

        // when
        boolean isActive = dateUtils.isActive(startDate, endDate);

        // then
        Assertions.assertFalse(isActive);

    }

    @Test
    void inActiveRangeMax() {
        //given
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 12, 31);

        // when
        boolean isActive = dateUtils.isActive(startDate, endDate);

        // then
        Assertions.assertFalse(isActive);

    }

    @Test
    void testThatReturnsTheDayOfTheWeekForAGivenDate() {
        //given
        LocalDate date = LocalDate.now();

        //when
        DayOfWeek dayOfWeek = dateUtils.getDayOfWeek(date);

        //then
        Assertions.assertEquals(date.getDayOfWeek(), dayOfWeek);
    }

    @Test
    void methodThatReturnsTheNumberOfDaysBetweenTwoDates() {
        //given
        LocalDate date1 = LocalDate.of(2023, 12, 13);
        LocalDate date2 = LocalDate.of(2023, 12, 31);

        //when
        long countDays = dateUtils.daysBetween(date1, date2);

        //then
        Assertions.assertEquals(18, countDays);

    }

    @Test
    void methodConvertDateToTimestamp() {
        //given
        LocalDate date = LocalDate.of(2023, 12, 31);

        //when
        long timestamp = dateUtils.toTimestamp(date);

        //then
        Assertions.assertEquals(1703980800, timestamp);

    }

    @Test
    void convertDateTimeToTimestamp() {
        //given
        LocalDateTime dateTime = LocalDateTime.of(2023, 12, 31, 23, 59, 59);

        //when
        long timestamp = dateUtils.localDateTimeToTimestamp(dateTime);

        //then
        Assertions.assertEquals(1704067199, timestamp);

    }

    @Test
    void methodConvertTimestampToDate() {
        //given
        long timestamp = 1703980800;
        LocalDate dateExpected = LocalDate.of(2023, 12, 31);

        //when
        LocalDate date = dateUtils.timestampToLocalDate(timestamp);

        //then
        Assertions.assertEquals(dateExpected, date);

    }

    @Test
    void methodConvertTimestampToLocalDateTime() {
        //given
        long timestamp = 1704067199;
        LocalDateTime localDateTime = LocalDateTime.of(2023, 12, 31, 23, 59, 59);

        //when
        LocalDateTime dateTime = dateUtils.timestampToLocalDateTime(timestamp);

        //then
        Assertions.assertEquals(localDateTime, dateTime);

    }


}