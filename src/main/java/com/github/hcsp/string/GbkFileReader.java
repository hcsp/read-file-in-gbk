package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> stringList = Files.readAllLines(file.toPath(), Charset.forName("GBK"));
            System.out.println(String.valueOf(stringList));
            for (String str : stringList) {
                stringBuilder.append(str).append("\n");
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
