package com.company.logic;

import com.company.MyFile;
import com.company.logic.Check.CheckWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * * В классе Write реализованы методы:
 * setFileList() - присваивает fileList данные, которые были переданы в этот метод
 * createFiles() - вызывает методы из класса CheckWrite для создания файлов, если их не существует, и возвращает путь к этим файлам
 * writeData() - записывает данные из fileList в файлы
 * addDataInMap() - добавляем данные в Map Map<String, String>
 * writeAllData() - записывает  данные в файл generalReport.txt
 * findTheReason() - возвращает строку, которая указывает причину невалидности данных
 */

public final class Write {

    private FileWriter fileWriterGeneral;

    private Set<MyFile> files = new HashSet<>();
    private Map<String, String> allFiles = new HashMap<>();
    private CheckWrite checkWrite;

    private String generalReport;

    public Write(Set<MyFile> files) {
        this.files = files;
        checkWrite = new CheckWrite();
        this.createFiles();
    }


    public void createFiles() {

        try {
            checkWrite.createADirectory();
            generalReport = checkWrite.createGeneralReport();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void writeData() {

        try {
            this.addDataInMap();
            this.writeAllData();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeAllData() throws IOException {

        File fileWrite = new File(generalReport);
        fileWriterGeneral = new FileWriter(fileWrite);

        try (BufferedWriter writer = new BufferedWriter(fileWriterGeneral)) {
            for (Map.Entry<String, String> file : allFiles.entrySet()) {
                writer.write(file.getKey() + "\t" + file.getValue() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addDataInMap() {
        for (MyFile file : files) {
            allFiles.put(file.getNumber(), this.findTheReason(file));
        }
    }

    private String findTheReason(MyFile file) {

        Pattern patternThree = Pattern.compile("\\W");  // "\\W" - все символы, кроме букв и цифр
        Matcher m = patternThree.matcher(file.getNumber());

        if (file.getNumber().length() > 15) {
            return "Больше положенной длины";
        } else if (m.find()) {
            return "Есть иные символы";
        } else return "Валиден";
    }
}
