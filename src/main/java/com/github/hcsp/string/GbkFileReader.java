package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.lines(file.toPath(), Charset.forName("GBK")).map(s -> s + '\n').forEachOrdered(sb::append);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
