package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        StringBuilder stringBuilder = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
            int b;
            stringBuilder = new StringBuilder();
            while ((b = inputStreamReader.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
