package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file){
        try {
            Charset charset = Charset.forName("GBK");
            byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
            return new String(bytes, "GBK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
