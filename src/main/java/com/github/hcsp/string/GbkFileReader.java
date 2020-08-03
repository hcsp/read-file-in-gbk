package com.github.hcsp.string;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {

        BufferedReader strOfFile = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()), Charset.forName("GBK")));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str = strOfFile.readLine()) != null) {
            stringBuilder.append(str);
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();

    }
}
