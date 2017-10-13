package com.aldoapps.autoformatedittext;

import java.util.Locale;

/**
 * Created by aldo on 12/10/17.
 */

public class CurrencyLocale {

    private Locale locale;

    private static class LocaleHolder {
        private static final CurrencyLocale INSTANCE = new CurrencyLocale();
    }

    private CurrencyLocale() {
        locale = Locale.US;
    }

    public Locale getLocale() {
        return locale;
    }

    public void useLocaleWithCommaGroupSeparator() {
        locale = Locale.US;
    }

    public void useLocaleWithDotGroupSeparator() {
        locale = Locale.GERMANY;
    }

    public static CurrencyLocale getInstance() {
        return LocaleHolder.INSTANCE;
    }


}
