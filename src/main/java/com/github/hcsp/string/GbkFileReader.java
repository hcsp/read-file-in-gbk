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
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        StringBuilder builder = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {
            builder.append((char) ch);
        }
        return builder.toString();
//        return result.length() > 0 ? result.substring(0, result.length() - 2) : result;
    }
}
