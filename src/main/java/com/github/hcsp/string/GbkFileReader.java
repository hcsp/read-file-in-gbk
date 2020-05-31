package com.github.hcsp.string;

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
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                char[] temp = new char[1024];
                int end;
                if ((end = inputStreamReader.read(temp, 0, 1024)) == -1) {
                    break;
                }
                stringBuilder.append(temp, 0, end);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
