package com.github.hcsp.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line + "\n");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

}
