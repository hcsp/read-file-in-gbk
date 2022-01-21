package com.github.hcsp.string;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
//        return bufferedReader.lines().collect(Collectors.joining("\n"));
        byte[] bytes = Files.readAllBytes(file.toPath());
        return new String(bytes, "GBK");
    }
}
