package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        String collect = null;
        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath(), Charset.forName("GBK"))) {
            collect = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collect;
    }
}
