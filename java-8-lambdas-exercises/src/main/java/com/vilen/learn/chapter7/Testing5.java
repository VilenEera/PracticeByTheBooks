package com.vilen.learn.chapter7;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by vilen on 2017/10/15.
 */
public class Testing5 {
    private static final Logger logger = Logger.getLogger("Testing");

    public static List<String> allToUpperCase(List<String> words) {
        return words.stream().map(string-> string.toUpperCase())
                .collect(Collectors.toList());
    }

    //将列表中元素的第一个字母转换成大写
    public static List<String> elementFirstToUpperCaseLamdas(List<String> words) {
        return words.stream()
                .map(value ->{
                    char firstChar = Character.toUpperCase(
                            value.charAt(0));
                    return firstChar + value.substring(1);
                }).collect(Collectors.toList());
    }
    /*----------------------------------------------------*/
    //Lambdas转换
    public static List<String> elementFirstToUpperCase(List<String> words) {
        return words.stream().map(Testing5::firstToUppercase)
                .collect(Collectors.<String>toList());
    }
    public static String firstToUppercase(String value) {
        char firstChar = Character.toUpperCase(value.charAt(0));
        return firstChar + value.substring(1);
    }
    /*----------------------------------------------------*/

}
