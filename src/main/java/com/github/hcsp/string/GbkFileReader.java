package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(file.toPath(), Charset.forName("GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings.stream().collect(Collectors.joining("\n"));
    }
}
