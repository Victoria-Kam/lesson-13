package com.company.logic.Check;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * В классе CheckStrings реализованы методы:
 * checkPath() -  проверяет введенный с консоли путь к файлу;
 * checkLine() - проверяет строку из файла на валидность
 * isExist() - проверка на существование файла
 * */

public class CheckStrings {

    private final static String CONTROL_PATH = "src/";

    public static String checkPath(String path) {            // если пользователь введет относительный путь

        Pattern p = Pattern.compile(CONTROL_PATH);
        Matcher m = p.matcher(path);
        if (m.find()) {
            return path;
        } else {
            path = CONTROL_PATH + path;
            return path;
        }
    }

    public static boolean checkLine(String line) {    // строка состоит только из букв/цифр, и длину строки 15 символов

        boolean isValid = false;

        Pattern patternThree = Pattern.compile("\\W");  // "\\W" - все символы, кроме букв и цифр
        Matcher mThree = patternThree.matcher(line);

        if ((!mThree.find()) && line.length() <= 15) {  // инверсируем шаблон, т.к. символы не нужны (нужны только буквы и цифры)
            isValid = true;
        } else {
            isValid = false;
        }

        return isValid;
    }

    public static boolean isExist(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        } else return false;
    }
}
