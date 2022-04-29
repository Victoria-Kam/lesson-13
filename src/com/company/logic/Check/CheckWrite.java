package com.company.logic.Check;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * В классе CheckWrite реализованы методы:
 * createADirectory() - создает папку, куда будут сохраняться файл-отчеты
 * createGeneralReport() - создает общий файл-отчет
 * */

public final class CheckWrite {

    private final String PROJECT_PATH = "src/";
    private final String DIRECTORY_NAME = "report";
    private String filePath;

    public void createADirectory() {
        File directory = new File(PROJECT_PATH + "/" + DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdir();
        }
        filePath = PROJECT_PATH + "/" + DIRECTORY_NAME;

    }


    public String createGeneralReport() throws IOException {

        Path generalReport = Paths.get(filePath + "/" + "generalReport.txt");

        File notValidData = new File(generalReport.toString());
        if (!notValidData.exists()) {
            Files.createFile(generalReport);
        }
        return filePath + "/" + "generalReport.txt";
    }
}
