/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mhieu
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static java.util.Date toUtilDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return new java.util.Date(date.getTime());
    }

    public static java.sql.Date toSqlDate(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    public static String convertDate(java.sql.Date date) {
        if (date == null) {
            return "";
        }
        return sdf.format(DateUtil.toUtilDate(date));
    }

    public static java.sql.Date convertDate(String date) {
        if (date == null) {
            return null;
        }
        try {
            java.util.Date date1 = sdf.parse(date);
            return DateUtil.toSqlDate(date1);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String convertDate(java.util.Date ngaysinh) {
        if (ngaysinh == null) {
            return "";
        }
        return sdf.format(DateUtil.toUtilDate((java.sql.Date) ngaysinh));
    }
}
