package com.company;

import java.util.Objects;

public final class MyFile {

   // private final String DOCUMENT = "docnum";
    //private final String CONTRACT = "contract";

    private boolean isValid;
    private String number;

    public MyFile(){

    }

    public MyFile(String number, boolean isValid){
        this.number = number;
        this.isValid = isValid;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFile myFile = (MyFile) o;
        return isValid == myFile.isValid && Objects.equals(number, myFile.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid, number);
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "isValid=" + isValid +
                ", number='" + number + '\'' +
                '}';
    }
}
