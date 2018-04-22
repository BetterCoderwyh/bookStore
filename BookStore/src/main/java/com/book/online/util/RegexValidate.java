package com.book.online.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidate {
    private static Pattern pattern;
    private static Matcher mather;
    
    public static boolean volidate(String regex,String str) {
        pattern=Pattern.compile(regex);
        mather=pattern.matcher(str);
        return mather.matches();
    }
}
