package com.company.logic;

import com.company.MyFile;
import com.company.logic.Check.CheckStrings;

import java.io.*;
import java.util.*;


/*
 * В классе Read реализованы методы:
 * Read(ArrayList<String> path) - конструктор с параметрами, в который передается лист с путями к файлам
 * loadFile() - чтение из файлов, которые находятся в папке resources
 * getFileList() - возвращает список документов
 * */

public final class Read {

    private final String SOURCE_PATH = "src/resources/file.txt";
    BufferedReader bufferedReader;
    ArrayList<String> pathsFiles = new ArrayList<>();
    Set<MyFile> fileList;

    public Read(ArrayList<String> path) {
        pathsFiles = path;
        fileList = new HashSet<>();
    }

    public void loadFiles() throws IOException {  // Чтение из файла, который находится в папке resources

        String line;

        try {
            for (String path : pathsFiles) {
                FileReader reader = new FileReader(path);
                bufferedReader = new BufferedReader(reader, 100);

                while ((line = bufferedReader.readLine()) != null) {
                    fileList.add(new MyFile(line, CheckStrings.checkLine(line)));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }

    public Set<MyFile> getFileList() {
        return fileList;
    }
}
