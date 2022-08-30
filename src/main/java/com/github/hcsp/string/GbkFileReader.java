package com.github.hcsp.string;

import java.io.*;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        String str;
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            str = new String(bytes, "GBK");
            str = str.replace('，', '\n').replace("。", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
