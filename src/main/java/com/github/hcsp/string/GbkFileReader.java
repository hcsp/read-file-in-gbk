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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append(System.lineSeparator());
                }
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
