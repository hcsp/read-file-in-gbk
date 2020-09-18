package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        String line = bf.readLine();
        while (line != null) {
            sb.append(line);
            line = bf.readLine();
            if (line != null) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
