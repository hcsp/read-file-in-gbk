package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        List<String> strings = Files.readAllLines(file.toPath(), Charset.forName("GBK"));
        StringBuilder sb = new StringBuilder();
        if (!strings.isEmpty()) {
            sb.append(strings.remove(0));
            while (strings.iterator().hasNext()) {
                sb.append("\n");
                sb.append(strings.remove(0));
            }
        }
        return sb.toString();
    }
}
