package com.github.hcsp.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        Charset charset = Charset.forName("GBK");
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(file.toPath(), charset);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder stringInFile = new StringBuilder();
        String temp;
        try {
             while ((temp = bufferedReader.readLine()) != null) {
                 stringInFile.append(temp).append("\n");
             }
             stringInFile.deleteCharAt(stringInFile.length() - 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringInFile.toString();
    }
}
