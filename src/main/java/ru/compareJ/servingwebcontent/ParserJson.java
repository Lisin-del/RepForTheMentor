package ru.compareJ.servingwebcontent;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class ParserJson {
    //получаем все файлы из директории загрузок
    private File directoryUploads = new File("./src/main/resources/uploadFiles/");
    private File[] files = directoryUploads.listFiles();
    private File fileJson1 = files[0]; //one file json
    private File fileJson2 = files[1]; //two file json

    //streams and buffers
    private FileReader fileReaderFile1;
    private BufferedReader buffReaderFile1;
    private FileReader fileReaderFile2;
    private BufferedReader buffReaderFile2;

    //string for pars
    private StringBuilder resultStringFile1 = new StringBuilder();
    private StringBuilder resultStringFile2 = new StringBuilder();
    private String line;

    //reading data from a file json
    public void read() {
       try {
           fileReaderFile1 = new FileReader(fileJson1);
           buffReaderFile1 = new BufferedReader(fileReaderFile1);

            while((line = buffReaderFile1.readLine()) != null) {
                resultStringFile1.append(line);
            }

            fileReaderFile2 = new FileReader(fileJson2);
            buffReaderFile2 = new BufferedReader(fileReaderFile2);
            while((line = buffReaderFile2.readLine()) != null) {
                resultStringFile2.append(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //getting the result string
    public String getResultStringFile1() {
        return resultStringFile1.toString();
    }

    public String getResultStringFile2() {
        return resultStringFile2.toString();
    }



}
