package com.github.hcsp.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath(), Charset.forName("GBK"))) {
            int ch;
            while ((ch = bufferedReader.read()) != -1) {
                stringBuilder.append((char) ch);
            }
        }
        return stringBuilder.toString();
    }
}
