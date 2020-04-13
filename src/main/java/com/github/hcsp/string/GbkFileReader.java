package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"))) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = new char[20];
            int ch;
            while ((ch = bufferedReader.read(chars, 0, chars.length)) != -1) {
                stringBuilder.append(chars, 0, ch);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
