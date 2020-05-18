package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        StringBuilder str = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            str.append(line).append("\n");
        }
        return str.substring(0, str.length() - 1);
    }
}
