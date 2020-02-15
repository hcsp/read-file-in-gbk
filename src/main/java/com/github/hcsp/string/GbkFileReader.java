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
        String words = null;
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            words = new String(bytes, Charset.forName("gbk"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
