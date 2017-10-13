package com.aldoapps.autoformatedittext;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CurrencyWithDotGroupSeparatorTest {

    @Before
    public void setup() {
        CurrencyLocale.getInstance().useLocaleWithDotGroupSeparator();
    }

    @Test
    public void testNoDecimal() throws Exception {
        String moneyNoDecimal = "15000000";

        String result1 = NewAutoFormatUtil.formatWithoutDecimal(moneyNoDecimal);
        assertEquals("15.000.000", result1);
    }

    @Test
    public void testDecimal() throws Exception {
        String moneyWithTwoDecimal = "15000000.42";
        String moneyWithThreeDecimal = "15000000.999";
        String moneyWithManyDecimal = "15000000.889989";

        String result1 = NewAutoFormatUtil.formatWithDecimal(moneyWithTwoDecimal);
        assertEquals("15.000.000,42", result1);

        String result2 = NewAutoFormatUtil.formatWithDecimal(moneyWithThreeDecimal);
        assertEquals("15.000.000,999", result2);

        String result3 = NewAutoFormatUtil.formatWithDecimal(moneyWithManyDecimal);
        assertEquals("15.000.000,889989", result3);
    }

}