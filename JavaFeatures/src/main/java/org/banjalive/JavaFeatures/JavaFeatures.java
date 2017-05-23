package main.java.org.banjalive.JavaFeatures;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by a.lebedjko on 2017.01.04..
 */
public class JavaFeatures {
    private static final Logger log = LoggerFactory.getLogger(JavaFeatures.class);
    public final String constant = "const";

    public static void main(String[] args) {

        testNewVsValueOf_New();
        testNewVsValueOf_ValueOf();

        System.out.println();

        concatWithPlus();
        concatWithAppend();
        concatWithAppendStringBuffer();

        System.out.println();

        numberTypeConversionCastByPlus();
        numberTypeConversionCastByValueOf();

        charToIntGetNumericalValue();
        charToIntGetDigit();

        stringToByteConstructor();
        stringToByteValueOf();
        stringToByteParseByte();
        stringToBytesGetBytes();


        stringPadZeroesFromLeftWithPlus();
        stringPadZeroesFromLeftWithStringBuilder();
        stringPadZeroesFromLeftWithStringUtils();
        integerPadZeroesFromLeft(1, 7);

//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("01101981").getConvertedDates());
//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("431210").getConvertedDates());
//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("19741007").getConvertedDates());
//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("603786294").getConvertedDates());
//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("9208920877").getConvertedDates());
//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("19741007").getConvertedDates());
//
//        System.out.println(convertCustomerIdToDateComparisonFormat("19780725129").getConvertedDates());
//        System.out.println(convertCustomerIdToDateComparisonFormat("207807251298").getConvertedDates());
//
//
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("", ""));
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("197507034770", "03071975"));
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("197410077841", "741007"));
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("196904290100", "29.04.1969"));
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("", "29.04.1969"));
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("196905290100", "29.04.1969"));
//        System.out.println(isCompareNotApplicableOrCustomerIdMatchesBirthDate("197207118295", "11071972"));


//        System.out.println(convertCustomerIdToDateComparisonFormat("7807251298").getConvertedDates());


//        System.out.println(convertCustomerBirthDateToDateComparisonFormatUAT("20170212").getConvertedDates());
        System.out.println(testArithmetical());
        System.out.println(testBitwise());

        System.out.println(org.apache.commons.lang3.StringUtils.trim("Aß東\uD801\uDC00001"));

        System.out.println(compareVectors1());
        System.out.println(compareVectors2());

    }

    public static boolean compareVectors1() {
        Vector<Integer> integerVector = new Vector<Integer>();
        Vector<String> stringVectorector = new Vector<String>();
        return integerVector.getClass() == stringVectorector.getClass();
    }

    public static boolean compareVectors2() {
        Vector<Integer> integerVector = new Vector<Integer>();
        Vector<String> stringVectorector = new Vector<String>();
        return integerVector.getClass().equals(stringVectorector.getClass());
    }

    public static int testBitwise() {
        Stopwatch timer = Stopwatch.createStarted();
        int x = 10950;

        x += (x << 5) + 1;
        timer.stop();
        System.out.println("testBitwise() -> That took " + timer.toString());
        return x;
    }

    public static int testArithmetical() {
        Stopwatch timer = Stopwatch.createStarted();
        int x = 10950;
        x = x * 5 + 1;
        timer.stop();
        System.out.println("testArithmetical() -> That took " + timer.toString());
        return x;

    }


    public static void testNewVsValueOf_New() {
        Stopwatch timer = Stopwatch.createStarted();

        Integer i = new Integer(100);
        Long l = new Long(100);
        String s = new String("A");


        System.out.println("testNewVsValueOf_New() -> That took " + timer.stop());

    }

    public static void testNewVsValueOf_ValueOf() {
        Stopwatch timer = Stopwatch.createStarted();

        Integer i = Integer.valueOf(100);
        Long l = 100L;//это тоже самое что Long.valueOf(100L);
        String s = "A";
        timer.stop();
        System.out.println("testNewVsValueOf_ValueOf() -> That took " + timer.toString());

    }

    public static void stringPadZeroesFromLeftWithPlus() {
        Stopwatch timer = Stopwatch.createStarted();
        String s = "1";
        while (s.length() < 7) {
            s = "0" + s;
        }
        timer.stop();
        System.out.println("stringPadZeroesFromLeftWithPlus -> That took " + timer.toString());
    }

    public static void stringPadZeroesFromLeftWithStringBuilder() {
        Stopwatch timer = Stopwatch.createStarted();
        StringBuilder s = new StringBuilder("1");
        while (s.length() < 7) {
            s.insert(0, "0");
        }
        timer.stop();
        System.out.println("stringPadZeroesFromLeftWithStringBuilder -> That took " + timer.toString());
    }

    public static void stringPadZeroesFromLeftWithStringUtils() {
        Stopwatch timer = Stopwatch.createStarted();
        String s = "1";
        StringUtils.leftPad(s, 7, "0");
        timer.stop();
        System.out.println("stringPadZeroesFromLeftWithStringUtils -> That took " + timer.toString());
    }

    public static String integerPadZeroesFromLeft(int in, int fill) {
        Stopwatch timer = Stopwatch.createStarted();


        boolean negative = false;
        int value, len = 0;

        if (in >= 0) {
            value = in;
        } else {
            negative = true;
            value = -in;
            in = -in;
            len++;
        }

        if (value == 0) {
            len = 1;
        } else {
            for (; value != 0; len++) {
                value /= 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (negative) {
            sb.append('-');
        }

        for (int i = fill; i > len; i--) {
            sb.append('0');
        }

        sb.append(in);

        timer.stop();

        System.out.println("integerPadZeroesFromLeft -> That took " + timer.toString());
        return sb.toString();
    }

    public static String concatWithPlus() {
        //медленно
        String[] fields = new String[]{"a", "b", "c", "e", "f", "g", "h", "i", "j"};

        Stopwatch timer = Stopwatch.createStarted();
        String s = "";
        for (int i = 0; i < fields.length; i++) {
            s = s + fields[i];
        }
        timer.stop();
        System.out.println("concatWithPlus -> That took " + timer.toString());

        return s;
    }


    @NotNull
    public static String concatWithAppend() {
        //быстро
        String[] fields = new String[]{"a", "b", "c", "e", "f", "g", "h", "i", "j"};

        Stopwatch timer = Stopwatch.createStarted();

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            s.append(fields[i]);
        }
        timer.stop();
        System.out.println("concatWithAppend -> That took " + timer.toString());

        return s.toString();
    }

    public static String concatWithAppendStringBuffer() {
        //быстро
        String[] fields = new String[]{"a", "b", "c", "e", "f", "g", "h", "i", "j"};

        Stopwatch timer = Stopwatch.createStarted();

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < fields.length; i++) {
            s.append(fields[i]);
        }

        timer.stop();
        System.out.println("concatWithAppendStringBuffer -> That took " + timer.toString());

        return s.toString();
    }

    public static void numberTypeConversionCastByPlus() {

        Stopwatch timer = Stopwatch.createStarted();
        int a = 12;
        String s = a + "";
        timer.stop();

        System.out.println("numberTypeConversionCastByPlus -> That took " + timer.toString());
    }

    public static void numberTypeConversionCastByValueOf() {

        Stopwatch timer = Stopwatch.createStarted();
        int a = 12;
        String s = String.valueOf(a);

        timer.stop();
        System.out.println("numberTypeConversionCastByValueOf -> That took " + timer.toString());
    }

    public static void charToIntGetNumericalValue() {

        Stopwatch timer = Stopwatch.createStarted();

        char ch = '9';

        // c использованием метода getNumericValue
        // класса Character
        int i1 = Character.getNumericValue(ch);
        timer.stop();
        System.out.println("charToIntGetNumericalValue -> That took " + timer.toString());

    }

    public static void charToIntGetDigit() {

        Stopwatch timer = Stopwatch.createStarted();

        char ch = '9';

        // c использованием метода digit класса Character
        int i2 = Character.digit(ch, 10);
        timer.stop();
        System.out.println("charToIntGetDigit -> That took " + timer.toString());

    }

    public static byte stringToByteConstructor() {
        Stopwatch timer = Stopwatch.createStarted();

        byte b1 = 0;
        try {
            b1 = new Byte("10");
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        timer.stop();
        System.out.println("stringToByteConstructor -> That took " + timer.toString());
        return b1;
    }

    public static byte stringToByteValueOf() {
        Stopwatch timer = Stopwatch.createStarted();

        Byte b2 = 0;
        String str1 = "111";
        try {
            b2 = Byte.valueOf(str1);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        timer.stop();
        System.out.println("stringToByteValueOf -> That took " + timer.toString());
        return b2;
    }

    public static byte stringToByteParseByte() {
        Stopwatch timer = Stopwatch.createStarted();

        byte b = 0;
        String str2 = "100";
        try {
            b = Byte.parseByte(str2);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки, ублюдок!");
        }

        timer.stop();
        System.out.println("stringToByteParseByte -> That took " + timer.toString());
        return b;
    }


    public static byte stringToBytesGetBytes() {
        Stopwatch timer = Stopwatch.createStarted();

        byte b = 0;
        String str2 = "100";
        try {
            b = str2.getBytes()[1];
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        timer.stop();
        System.out.println("stringToBytesGetBytes -> That took " + timer.toString().trim());
        return b;
    }




    public static DateConversionResult convertCustomerBirthDateToDateComparisonFormatUAT(String customerBirthDate) {
        Stopwatch timer = Stopwatch.createStarted();
        DateConversionResult dateConversionResult = new DateConversionResult();
        if (StringUtils.isEmpty(customerBirthDate)) {
            return dateConversionResult;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        // check for format dMMyyXXXX
        if (customerBirthDate.length() == 9) {
            customerBirthDate = customerBirthDate.substring(0, 5);
        }

        try {
            Date newDate;
            if (NumberUtils.isDigits(customerBirthDate)) {
                newDate = DateUtils.parseDateStrictly(customerBirthDate, "ddMMyyyy", "ddMMyy", "yyMMdd", "yyyyMMdd",
                        "dMMyy");
            } else {
                newDate = DateUtils.parseDateStrictly(customerBirthDate, "dd.MM.yyyy");
            }
            dateConversionResult.setConvertedDate(simpleDateFormat.format(newDate));
            dateConversionResult.setConverted(true);
        } catch (ParseException e) {
            log.error("Unable to convert date string \"" + customerBirthDate + "\"");
        }
        System.out.println("convertCustomerBirthDateToDateComparisonFormatUAT -> That took " + timer.toString());
        return dateConversionResult;
    }

    private static DateConversionResult convertCustomerIdToDateComparisonFormat(String customerId) {
        Stopwatch timer = Stopwatch.createStarted();
        DateConversionResult dateConversionResult = new DateConversionResult();
        if (StringUtils.isEmpty(customerId) || !NumberUtils.isDigits(customerId)) {
            return dateConversionResult;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String dateString;

        // try to convert only if customer id length is not less than 8
        // characters
        if (!(customerId.length() < 8)) {
            if (!(customerId.length() < 12) && customerId.startsWith("19") || customerId.startsWith("20")) {
                dateString = customerId.substring(2, 8);
            } else {
                dateString = customerId.substring(0, 6);
            }

            try {
//                Date newDate = simpleDateFormat.parse(dateString);
                Date newDate = DateUtils.parseDateStrictly(dateString, "yyMMdd");
                dateConversionResult.setConvertedDate(simpleDateFormat.format(newDate));
                dateConversionResult.setConverted(true);
            } catch (ParseException e) {
                log.error("Unable to convert date string \"" + dateString + "\"");
            }
        }

        System.out.println("convertCustomerIdToDateComparisonFormat -> That took " + timer.toString());
        return dateConversionResult;
    }

    private static boolean isCompareNotApplicableOrCustomerIdMatchesBirthDate(String customerId, String customerBirthDate) {
        Stopwatch timer = Stopwatch.createStarted();
        DateConversionResult birthDateConversionResult = !StringUtils.isEmpty(customerBirthDate)
                ? convertCustomerBirthDateToDateComparisonFormatUAT(customerBirthDate) : null;
        DateConversionResult customerIdConversionResult = !StringUtils.isEmpty(customerId)
                ? convertCustomerIdToDateComparisonFormat(customerId) : null;

        if (birthDateConversionResult != null && customerIdConversionResult != null
                && birthDateConversionResult.isConverted() && customerIdConversionResult.isConverted()) {
            System.out.println("isCompareNotApplicableOrCustomerIdMatchesBirthDate -> That took " + timer.toString());
            return birthDateConversionResult.getConvertedDate().equals(customerIdConversionResult.getConvertedDate());
        } else {
            System.out.println("isCompareNotApplicableOrCustomerIdMatchesBirthDate -> That took " + timer.toString());
            return true;
        }
    }

//    public static DateConversionResult convertCustomerBirthDateToDateComparisonFormat(Customer customer,
//                                                                                      HistoryLog historyLog) {
//        DateConversionResult dateConversionResult = new DateConversionResult();
//        String customerBirthDate = customer.getCustomerId();
//        if (StringUtils.isEmpty(customerBirthDate)) {
//            return dateConversionResult;
//        }
//
//        try {
//            Date newDate;
//            // setup minYear and maxYear
//            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
//            Calendar cal = Calendar.getInstance();
//            int minYear = Integer.parseInt(yearFormat.format(cal.getTime())) - 150;
//            int maxYear = Integer.parseInt(yearFormat.format(cal.getTime()));
//
//            // check for format dMMyyXXXX
//            if (customerBirthDate.length() == 9) {
//                customerBirthDate = customerBirthDate.substring(0, 5);
//                newDate = DateUtils.parseDateStrictly(customerBirthDate, "dMMyy");
//
//                // check if input date format is numeric
//            } else if (NumberUtils.isDigits(customerBirthDate)) {
//                // when numeric and length between 6 and 7 characters try
//                // formats "yyMMdd" and "ddMMyy"
//                if (!(customerBirthDate.length() < 6) && customerBirthDate.length() < 8) {
//
//                    int yyDigits = Integer.parseInt(customerBirthDate.substring(0, 2));
//                    int ddDigits = Integer.parseInt(customerBirthDate.substring(4, 6));
//
//                    if (!(yyDigits < 31 && ddDigits < 31)) {
//                        if (yyDigits > 31 && ddDigits < 31) {
//                            newDate = DateUtils.parseDateStrictly(customerBirthDate, "yyMMdd");
//                        } else {
//                            newDate = DateUtils.parseDateStrictly(customerBirthDate, "ddMMyy");
//                        }
//
//                    } else {
//                        historyLog.logError(
//                                "Unable to convert date string \"" + customerBirthDate
//                                        + "\", since it can be represented in two conflicting formats \"yyMMdd\" and \"ddMMyy\" simultaneosly",
//                                customer.getCustomerNo());
//                        return dateConversionResult;
//                    }
//                    // if not less than 8
//                } else if (!(customerBirthDate.length() < 8)) {
//                    int yyyyDigits = Integer.parseInt(customerBirthDate.substring(0, 4));
//                    int mmDigits = Integer.parseInt(customerBirthDate.substring(4, 6));
//                    int ddDigits = Integer.parseInt(customerBirthDate.substring(6, 8));
//
//                    if (yyyyDigits > minYear && yyyyDigits < maxYear && mmDigits < 13 && ddDigits < 32) {
//                        newDate = DateUtils.parseDateStrictly(customerBirthDate, "yyyyMMdd");
//                    } else {
//                        newDate = DateUtils.parseDateStrictly(customerBirthDate, "ddMMyyyy");
//                    }
//                } else {
//                    newDate = DateUtils.parseDateStrictly(customerBirthDate, "dMMyy");
//                }
//
//            } else {
//                newDate = DateUtils.parseDateStrictly(customerBirthDate, "dd.MM.yyyy");
//            }
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
//            dateConversionResult.setConvertedDate(simpleDateFormat.format(newDate));
//            dateConversionResult.setConverted(true);
//        } catch (ParseException e) {
//            historyLog.logError("Unable to convert date string \"" + customerBirthDate + "\"",
//                    customer.getCustomerNo());
//        }
//
//        return dateConversionResult;
//    }
}
