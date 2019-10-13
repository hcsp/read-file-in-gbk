package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            Files.readAllLines(file.toPath(), Charset.forName("GBK"))
                    .forEach(s -> sb.append(s).append("\n"));
            sb.deleteCharAt(sb.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
