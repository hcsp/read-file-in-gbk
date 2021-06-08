package com.github.hcsp.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")))) {

            String tmp;
            while ((tmp = reader.readLine()) != null) {
                str.append(tmp).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
