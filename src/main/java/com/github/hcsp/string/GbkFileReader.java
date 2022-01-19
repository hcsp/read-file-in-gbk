package com.github.hcsp.string;

import java.io.*;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) throws Exception {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws Exception {

        byte[] bytes = Files.readAllBytes(file.toPath());
        return new String(bytes, "GBK");


    }
}
