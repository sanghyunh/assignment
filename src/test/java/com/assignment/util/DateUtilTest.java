package com.assignment.util;

import java.time.LocalDateTime;
import java.util.Date;

import com.assignment.CommonTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateUtilTest extends CommonTest {

    @Test
    public void localDateTimeToDate_test() {
        Date date = this.dateUtil.localDateTimeToDate(LocalDateTime.now());
        System.out.println(date);
        Assertions.assertNotNull(date);
    }

    @Test
    public void makeExpirationDate_test() {
        Date date = this.dateUtil.makeExpirationDate(System.currentTimeMillis());
        System.out.println(date);
        Assertions.assertNotNull(date);
    }

    @Test
    public void dateToLocalDateTime_test() {
        LocalDateTime localDateTime = this.dateUtil.dateToLocalDateTime(new Date());
        System.out.println(localDateTime);
        Assertions.assertNotNull(localDateTime);
    }

    @Test
    public void expirationCheck_test() {
        Date date = this.dateUtil.makeExpirationDate(-1000 * 10L);
        Assertions.assertTrue(this.dateUtil.expirationCheck(date.getTime()));
    }

    @Test
    public void convertToFormat_test() {
        String date = this.dateUtil.convertToFormat(LocalDateTime.now(), "yyyy-MM-dd");
        System.out.println(date);
        Assertions.assertNotNull(date);

    }
}
