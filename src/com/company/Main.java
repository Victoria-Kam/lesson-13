package com.company;

import com.company.logic.Check.CheckStrings;
import com.company.logic.Read;
import com.company.logic.Write;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> filePath = new ArrayList<>();
        Set<MyFile> myFiles = new HashSet<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {          //   Вводим путь к файлам, и добавляем в лист
            System.out.print("Введите путь к файлу: ");

            String path = scanner.next();               // вводим путь с консоли

            if(path.equals("0")){
                break;
            }
            path = CheckStrings.checkPath(path);        // проверка ввода пути
            if(CheckStrings.isExist(path)){
                filePath.add(path);
            }
        }

        Read read = new Read(filePath);
        read.loadFiles();
        myFiles = read.getFileList();

        Write writeFile = new Write(myFiles);
        writeFile.writeData();

    }
}
